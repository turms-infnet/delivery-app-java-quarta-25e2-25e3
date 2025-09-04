package dev.tiagosilva;

import dev.tiagosilva.dto.UserDTO;
import dev.tiagosilva.model.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;


public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try{
            UserModel user = new UserModel();
            user = (UserModel) user.find(1L);

            UserDTO userDTO = new UserDTO(user.getId(), user.getUsername(), user.getPassword(), user.getRole());
            System.out.println(userDTO.getId());
            System.out.println(userDTO.getUsername());
            System.out.println(userDTO.getPassword());
            System.out.println(userDTO.getAddress().getStreet());
            System.out.println(userDTO.getPayment());
        } catch (Exception e){
            logger.error("Error saving product: " + e.getMessage());
        }
    }
}