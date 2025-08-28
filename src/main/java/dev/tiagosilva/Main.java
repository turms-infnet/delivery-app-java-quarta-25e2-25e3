package dev.tiagosilva;

import dev.tiagosilva.model.AddressModel;
import dev.tiagosilva.model.PaymentModel;
import dev.tiagosilva.model.ProductModel;

import dev.tiagosilva.model.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
//        ProductModel product = new ProductModel("Laptop", 1200.00F);
//        UserModel user = new UserModel("tiagoluizrs", "123456", 1, null, null);
//        AddressModel address = new AddressModel("123 Main St", 123, "aaa", "Bnnn", 1L);
//        PaymentModel payment = new PaymentModel("Tiago Silva", "0000 0000 0000 0000", 12, 2030, 1234, 1L);
        ProductModel product = new ProductModel();
        try{
            UserModel user = new UserModel();
            user.find(1L);
//            product.save();
//            user.save();
//            address.save();
//            payment.save();
        } catch (Exception e){
            logger.error("Error saving product: " + e.getMessage());
        }
    }
}