package dev.tiagosilva.dto;

import dev.tiagosilva.controller.Controller;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class OrderDTO extends Controller<OrderDTO> {
    private Long id;
    private LocalDateTime date;
    private Float total;
    private int status;
    private String comments;
    private int rating;
    private String products;
    private Long id_user;
}
