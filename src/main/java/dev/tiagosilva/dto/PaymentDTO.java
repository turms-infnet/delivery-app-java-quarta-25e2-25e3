package dev.tiagosilva.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentDTO {
    private Long id;
    private String name;
    private String number;
    private int month;
    private int year;
}
