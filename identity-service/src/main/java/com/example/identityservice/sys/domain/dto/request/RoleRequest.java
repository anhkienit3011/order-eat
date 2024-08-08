package com.example.identityservice.sys.domain.dto.request;

import java.util.Set;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE) // all fields are private
public class RoleRequest {
    String name;
    String description;
    Set<String> permissions;
}
