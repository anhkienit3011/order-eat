package com.example.identityservice.dto.request;

import com.example.identityservice.validator.DobContraint;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE) //all fields are private

public class UserCreationRequest {
    @Size(min = 5,message = "USERNAME_INVALID")
    String username;

    @Size(min = 8,message = "PASSWORD_INVALID")
    String password;
    String firstName;
    String lastName;

    @DobContraint(min = 18,message = "INVALID_DOB")
    LocalDate dob;
}
