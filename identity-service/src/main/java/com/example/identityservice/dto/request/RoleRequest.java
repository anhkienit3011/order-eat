package com.example.identityservice.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE) //all fields are private

public class RoleRequest {
    String name;
    String description;
    Set<String> permissions;


}
