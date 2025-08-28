package dev.tiagosilva.model;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.List;

@Getter
@Setter
public class UserModel extends Model {
    private String username;
    private String password;
    private int role;
    private AddressModel address;
    private PaymentModel payment;

    public UserModel() {
        super("users.csv");
    }

    public UserModel(String username, String password, int role) {
        super("users.csv");
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Override
    public UserModel find(Long id) throws IOException {
        UserModel user = (UserModel) super.find(id);
        var user_id = user.getId();

        AddressModel address = new AddressModel();
        AddressModel resultAddress = (AddressModel) address.find("id_user", user_id.toString());
        user.setAddress(resultAddress);

        PaymentModel payment = new PaymentModel();
        PaymentModel resultPayment = (PaymentModel) payment.find("id_user", user_id.toString());
        user.setPayment(resultPayment);

        return user;
    }
}
