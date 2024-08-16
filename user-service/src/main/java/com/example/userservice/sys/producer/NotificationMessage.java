package com.example.userservice.sys.producer;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Builder
@Getter
@Setter
public class NotificationMessage {
    String email;
    LocalDateTime dateOfOrder;
}
