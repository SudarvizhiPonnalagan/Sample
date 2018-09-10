package com.user.rights.service;

import com.user.rights.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUser();

    UserDTO getUser(Long userId);

    UserDTO create(UserDTO userDTO);

    UserDTO update(UserDTO userDTO);

    Boolean delete(Long userId);
}
