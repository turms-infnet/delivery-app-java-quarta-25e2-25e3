package dev.tiagosilva.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResponseDTO{
    private Long id;
    private String username;
    private int role;
}
