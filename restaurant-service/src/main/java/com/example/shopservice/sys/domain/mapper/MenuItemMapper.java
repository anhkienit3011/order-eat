package com.example.shopservice.sys.domain.mapper;
import com.example.shopservice.sys.domain.dto.request.MenuItemRequestDto;
import com.example.shopservice.sys.domain.dto.request.MenuRequestDto;
import com.example.shopservice.sys.domain.dto.response.MenuItemResponsetDto;
import com.example.shopservice.sys.domain.dto.response.MenuResponseDto;
import com.example.shopservice.sys.domain.entity.Menu;
import com.example.shopservice.sys.domain.entity.MenuItem;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring") // to use in spring (DI)
public interface MenuItemMapper {
    MenuItem toMenuItem (MenuItemRequestDto request);
    MenuItemResponsetDto toMenuItemResponse (MenuItem menuItem);


}
