package dev.tiagosilva.dto;

import dev.tiagosilva.model.AddressModel;
import dev.tiagosilva.model.PaymentModel;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@Setter
@Getter
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private int role;
    AddressDTO address;
    PaymentDTO payment;

    public UserDTO(Long id, String username, String password, int role) throws IOException {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.getAddressLinked();
        this.getPaymentLinked();
    }

    private void getAddressLinked() throws IOException {
        AddressModel add = new AddressModel();
        add = (AddressModel) add.find(this.id);

        AddressDTO addDTO = new AddressDTO();
        addDTO.setId(add.getId());
        addDTO.setStreet(add.getStreet());
        addDTO.setNumber(add.getNumber());
        addDTO.setComp(add.getComp());
        addDTO.setNeighborhood(add.getNeighborhood());
        this.address = addDTO;
    }

    private void getPaymentLinked() throws IOException {
         PaymentModel pay = new PaymentModel();
        pay = (PaymentModel) pay.find(this.id);

         PaymentDTO payDTO = new PaymentDTO();
         payDTO.setId(pay.getId());
         payDTO.setName(pay.getName());
         payDTO.setNumber(pay.getNumber());
         payDTO.setMonth(pay.getMonth());
         payDTO.setYear(pay.getYear());
         this.payment = payDTO;
    }
}
