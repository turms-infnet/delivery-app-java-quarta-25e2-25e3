package dev.tiagosilva.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentRequestDTO {
    private Long id;
    private String name;
    private String number;
    private int secret;
    private int month;
    private int year;
    private Long id_user;
}
