package dev.tiagosilva.business;

import dev.tiagosilva.dto.PaymentResponseDTO;
import dev.tiagosilva.dto.UserRequestDTO;
import dev.tiagosilva.dto.UserResponseDTO;
import dev.tiagosilva.model.PaymentModel;
import dev.tiagosilva.model.UserModel;

public class AuthBusinessHandler{
    public UserModel userModel;

    public UserResponseDTO login(UserRequestDTO userRequestDTO) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();

        try {
            userModel = new UserModel();
            UserModel result = userModel.find("username", userRequestDTO.getUsername());

            if (result.getId() != null && result.getPassword().equals(userRequestDTO.getPassword())) {
                userResponseDTO.setId(result.getId());
                userResponseDTO.setUsername(result.getUsername());
                userResponseDTO.setRole(result.getRole());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return userResponseDTO;
    }

    public boolean register(UserRequestDTO userRequestDTO) {
        try {
            userModel = new UserModel();
            UserModel result = userModel.find("username", userRequestDTO.getUsername());
            if (result != null) {
                return false;
            } else {
                userModel.setUsername(userRequestDTO.getUsername());
                userModel.setPassword(userRequestDTO.getPassword());
                userModel.setRole(userRequestDTO.getRole());
                userModel.save();
                return true;
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar usuário", e);
        }
    }

    public UserResponseDTO get(Long id) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();

        try {
            userModel = new UserModel();
            UserModel result = userModel.find(id);

            if (result != null) {
                userResponseDTO = UserResponseDTO.modelToDto(result);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return userResponseDTO;
    }
}
