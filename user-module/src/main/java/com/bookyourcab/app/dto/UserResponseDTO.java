package com.bookyourcab.app.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class UserResponseDTO {
    private Long userId;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userMobile;
    private LocalDate userCreationDate;
}
