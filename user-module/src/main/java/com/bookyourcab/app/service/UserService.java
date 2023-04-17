package com.bookyourcab.app.service;

import com.bookyourcab.app.dto.UserRequestDTO;
import com.bookyourcab.app.dto.UserResponseDTO;
import com.bookyourcab.app.mapper.UserMapper;
import com.bookyourcab.app.model.User;
import com.bookyourcab.app.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserResponseDTO getUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return UserMapper.INSTANCE.fromUserModelToUserResponseDTO(user);
        }
        return null;
    }

    @Transactional
    public List<UserResponseDTO> getAllUsers(){
        return userRepository
                .findAll()
                .stream()
                .map(UserMapper.INSTANCE::fromUserModelToUserResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public UserResponseDTO registerNewUser(UserRequestDTO userRequestDTO){
        User user = UserMapper.INSTANCE.fromUserRequestDtoToUserModel(userRequestDTO);
        user.setUserCreationDate(LocalDate.now());
        return UserMapper.INSTANCE.fromUserModelToUserResponseDTO(userRepository.saveAndFlush(user));
    }

    public UserResponseDTO getUserByEmailOrMobile(String userEmailOrMobile){
        Optional<User> userOptional = userRepository.findByUserEmail(userEmailOrMobile);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return UserMapper.INSTANCE.fromUserModelToUserResponseDTO(user);
        }
        return null;
    }

}
