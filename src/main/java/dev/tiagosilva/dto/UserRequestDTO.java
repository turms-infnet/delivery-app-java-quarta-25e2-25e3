package dev.tiagosilva.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequestDTO {
    private Long id;
    private String username;
    private String password;
    private int role;
}