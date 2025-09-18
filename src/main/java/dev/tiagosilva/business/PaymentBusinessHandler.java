package dev.tiagosilva.business;

import dev.tiagosilva.dto.PaymentRequestDTO;
import dev.tiagosilva.dto.PaymentResponseDTO;
import dev.tiagosilva.dto.ProductResponseDTO;
import dev.tiagosilva.model.PaymentModel;
import dev.tiagosilva.model.ProductModel;

import java.util.List;

public class PaymentBusinessHandler {
    public PaymentModel paymentModel;

    public boolean create(PaymentRequestDTO paymentRequestDTO) {
        try {
            paymentModel = new PaymentModel();
            PaymentModel result = paymentModel.find("number", paymentRequestDTO.getNumber());
            if (result == null || result.getNumber() == null) {
                paymentModel.setName(paymentRequestDTO.getName());
                paymentModel.setNumber(paymentRequestDTO.getNumber());
                paymentModel.setSecret(paymentRequestDTO.getSecret());
                paymentModel.setMonth(paymentRequestDTO.getMonth());
                paymentModel.setYear(paymentRequestDTO.getYear());
                paymentModel.setId_user(paymentRequestDTO.getId_user());
                paymentModel.save();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<PaymentResponseDTO> getByUser(Long userId) {
        List<PaymentResponseDTO> paymentsResponseDTO = new java.util.ArrayList<>();
        try {
            paymentModel = new PaymentModel();
            List<PaymentModel> results = paymentModel.list("id_user", userId.toString(), true);
            if (!results.isEmpty()) {
                results.forEach(payment -> {
                    paymentsResponseDTO.add(PaymentResponseDTO.modelToDto(payment));
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return paymentsResponseDTO;
    }

    public PaymentResponseDTO get(Long id) {
        PaymentResponseDTO productResponseDTO = new PaymentResponseDTO();

        try {
            paymentModel = new PaymentModel();
            PaymentModel result = paymentModel.find(id);

            if (result != null) {
                productResponseDTO = PaymentResponseDTO.modelToDto(result);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return productResponseDTO;
    }
}
