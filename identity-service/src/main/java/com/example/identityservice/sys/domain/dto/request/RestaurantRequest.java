package com.example.identityservice.sys.domain.dto.request;

import com.example.identityservice.common.validator.DobContraint;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE) // all fields are private
public class RestaurantRequest {

    @Size(min = 5, message = "USERNAME_INVALID")
    String username;

    @Size(min = 8, message = "PASSWORD_INVALID")
    String password;
    String firstName;
    String lastName;

    @DobContraint(min = 18, message = "INVALID_DOB")
    LocalDate dob;



    String name;
    String description;
    String address;
    String phone;
    String email;
}
