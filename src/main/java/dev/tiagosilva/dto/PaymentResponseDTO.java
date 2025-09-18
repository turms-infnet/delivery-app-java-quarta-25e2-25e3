package dev.tiagosilva.dto;

import dev.tiagosilva.controller.Controller;
import dev.tiagosilva.model.PaymentModel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentResponseDTO {
    private Long id;
    private String name;
    private String number;
    private int month;
    private int year;

    public static PaymentResponseDTO modelToDto(PaymentModel payment) {
        PaymentResponseDTO item = new PaymentResponseDTO();
        item.setId(payment.getId());
        item.setName(payment.getName());
        item.setNumber(payment.getNumber());
        item.setMonth(payment.getMonth());
        item.setYear(payment.getYear());
        return item;
    }
}
