package com.example.restaurantservice.sys.domain.mapper;
import com.example.restaurantservice.sys.domain.dto.request.MenuRequestDto;
import com.example.restaurantservice.sys.domain.dto.response.MenuResponseDto;
import com.example.restaurantservice.sys.domain.entity.Menu;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring") // to use in spring (DI)
public interface MenuMapper {

    Menu toMenu (MenuRequestDto request);
    MenuResponseDto toMenuResponse (Menu menu);

    List<MenuResponseDto> toListMenuResponse (List<Menu> menus);
}
