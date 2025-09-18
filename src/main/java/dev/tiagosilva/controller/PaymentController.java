package dev.tiagosilva.controller;

import dev.tiagosilva.business.PaymentBusinessHandler;
import dev.tiagosilva.dto.PaymentRequestDTO;
import dev.tiagosilva.dto.PaymentResponseDTO;

import java.util.List;

public class PaymentController{
    public PaymentBusinessHandler paymentBusinessHandler = new PaymentBusinessHandler();

    public boolean create(PaymentRequestDTO paymentRequestDTO) {
        return paymentBusinessHandler.create(paymentRequestDTO);
    }

    public List<PaymentResponseDTO> getByUser(Long userId) {
        return paymentBusinessHandler.getByUser(userId);
    }

    public PaymentResponseDTO get(Long id) {
        return paymentBusinessHandler.get(id);
    }
}
