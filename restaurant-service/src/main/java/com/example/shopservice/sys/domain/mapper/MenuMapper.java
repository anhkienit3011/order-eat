package com.example.shopservice.sys.domain.mapper;
import com.example.shopservice.sys.domain.dto.request.MenuRequestDto;
import com.example.shopservice.sys.domain.dto.response.MenuResponseDto;
import com.example.shopservice.sys.domain.entity.Menu;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring") // to use in spring (DI)
public interface MenuMapper {
    Menu toMenu (MenuRequestDto request);
    MenuResponseDto toMenuResponse (Menu menu);

    List<MenuResponseDto> toListMenuResponse (List<Menu> menus);
}
