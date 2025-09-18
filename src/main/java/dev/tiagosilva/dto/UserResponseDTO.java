package dev.tiagosilva.dto;

import dev.tiagosilva.business.PaymentBusinessHandler;
import dev.tiagosilva.model.PaymentModel;
import dev.tiagosilva.model.UserModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserResponseDTO{
    private Long id;
    private String username;
    private int role;
    private List<PaymentResponseDTO> payments;
    private List<AddressResponseDTO> addresses;

    public static UserResponseDTO modelToDto(UserModel result) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(result.getId());
        userResponseDTO.setUsername(result.getUsername());
        userResponseDTO.setRole(result.getRole());

        PaymentBusinessHandler paymentBusinessHandler = new PaymentBusinessHandler();
        userResponseDTO.setPayments(paymentBusinessHandler.getByUser(result.getId()));

//        AddressBusinessHandler addressBusinessHandler = new PaymentBusinessHandler();
//        userResponseDTO.setAddresses(addressBusinessHandler.getByUser(result.getId()));

        return userResponseDTO;
    }
}
