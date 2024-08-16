package com.example.identityservice.sys.service;

import java.util.HashSet;
import java.util.List;

import com.example.identityservice.common.constant.PredefinedRole;
import com.example.identityservice.sys.domain.dto.request.RestaurantRequest;
import com.example.identityservice.sys.domain.entity.Role;
import com.example.identityservice.sys.domain.mapper.RestaurantMapper;
import com.example.identityservice.sys.repository.httpclient.RestaurantClient;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

import com.example.identityservice.sys.domain.dto.request.UserCreationRequest;
import com.example.identityservice.sys.domain.dto.request.UserUpdateRequest;
import com.example.identityservice.sys.domain.dto.response.UserResponse;
import com.example.identityservice.sys.domain.entity.User;

import com.example.identityservice.exception.AppException;
import com.example.identityservice.exception.ErrorCode;
import com.example.identityservice.sys.domain.mapper.UserMapper;
import com.example.identityservice.sys.repository.RoleRepository;
import com.example.identityservice.sys.repository.UserRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor // auto inject to "final" variable
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;
    RoleRepository roleRepository;
    RestaurantClient restaurantClient;
    RestaurantMapper restaurantMapper;

    public UserResponse createUser(UserCreationRequest request) {
        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        // set role
        HashSet<Role> roles = new HashSet<>();
        roleRepository.findById(PredefinedRole.USER_ROLE).ifPresent(roles::add);

        try {
            user.setRoles(roles);
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        return userMapper.toUserResponse(user);
    }
    public UserResponse createRestaurant(RestaurantRequest request) {
        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        // set role
        HashSet<Role> roles = new HashSet<>();
        roleRepository.findById(PredefinedRole.RESTAURANT_ROLE).ifPresent(roles::add);

        try {
            user.setRoles(roles);
            userRepository.save(user);

            var restaurantRequest = restaurantMapper.toRestaurantCreationRequest(request);
            restaurantRequest.setUserId(user.getId());
            log.info(restaurantRequest.toString());
            var restaurantResponse = restaurantClient.createRestaurant(restaurantRequest);

            log.info(restaurantResponse.toString());

        } catch (DataIntegrityViolationException e) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        return userMapper.toUserResponse(user);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')") // check role before go into method
    // @PreAuthorize("hasAuthority('READ_DATA')") //check permission before go into method
    public List<UserResponse> getAllUsers() {
        log.info("In method get Users");
        return userRepository.findAll().stream().map(userMapper::toUserResponse).toList();
    }

    //    @PostAuthorize("hasRole('ADMIN')") // check role after go into method (if true -> return)
    @PostAuthorize("returnObject.username == authentication.name") // just get ur info not others
    public UserResponse getUser(String id) {
        log.info("In method get user by Id ");
        return userMapper.toUserResponse(
                userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED)));
    }

    public UserResponse getMyInfo() {
        // get info user who  logging in
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();

        return userMapper.toUserResponse(
                userRepository.findByUsername(name).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED)));
    }

    public UserResponse updateUser(String userId, UserUpdateRequest request) {
        User user = userRepository.findById(userId).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        userMapper.updateUser(user, request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        var roles = roleRepository.findAllById(request.getRoles());
        user.setRoles(new HashSet<>(roles));

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
