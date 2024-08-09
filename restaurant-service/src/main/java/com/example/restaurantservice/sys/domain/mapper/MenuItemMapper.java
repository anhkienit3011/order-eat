package com.example.restaurantservice.sys.domain.mapper;
import com.example.restaurantservice.sys.domain.dto.request.MenuItemRequestDto;
import com.example.restaurantservice.sys.domain.dto.response.MenuItemResponseDto;
import com.example.restaurantservice.sys.domain.entity.MenuItem;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring") // to use in spring (DI)
public interface MenuItemMapper {
    MenuItem toMenuItem (MenuItemRequestDto request);
    MenuItemResponseDto toMenuItemResponse (MenuItem menuItem);


}
