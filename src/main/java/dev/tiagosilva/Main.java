package dev.tiagosilva;

import dev.tiagosilva.model.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;


public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try{
            AddressModel address = new AddressModel();
            PaymentModel payment = new PaymentModel();
            UserModel user = new UserModel();
            user = (UserModel) user.find(1L);
            user.setAddress((AddressModel) address.find("id_user", user.getId().toString()));
            user.setPayment((PaymentModel) payment.find("id_user", user.getId().toString()));

            OrderModel order = new OrderModel();
            order.setId_user(user.getId());
            order.setComments("Produto excelente");
            order.setTotal(150.0f);
            order.setStatus(1);
            order.setRating(5);
            order.setDate(LocalDateTime.now());
            order.setProducts("1-2-3");
            order.save();
        } catch (Exception e){
            logger.error("Error saving product: " + e.getMessage());
        }
    }
}