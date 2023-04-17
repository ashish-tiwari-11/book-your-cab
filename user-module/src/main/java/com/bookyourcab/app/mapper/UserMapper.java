package com.bookyourcab.app.mapper;

import com.bookyourcab.app.dto.UserRequestDTO;
import com.bookyourcab.app.dto.UserResponseDTO;
import com.bookyourcab.app.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponseDTO fromUserModelToUserResponseDTO(User user);

    User fromUserRequestDtoToUserModel(UserRequestDTO userRequestDTO);

}
