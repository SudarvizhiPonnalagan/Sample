package com.user.rights.service.Impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.rights.dto.UserDTO;
import com.user.rights.entity.User;
import com.user.rights.repository.UserRepository;
import com.user.rights.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    protected final ObjectMapper objectMapper;

    private final UserRepository userRepository;

    @Autowired
    UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public List<UserDTO> getAllUser() {
        return objectMapper.convertValue(userRepository.findAll(), new TypeReference<List<UserDTO>>(){});
    }

    @Override
    public UserDTO getUser(Long userId) {
        return objectMapper.convertValue(userRepository.getOne(userId), UserDTO.class);
    }

    @Override
    public UserDTO create(UserDTO userDTO) {
        User user = objectMapper.convertValue(userDTO, User.class);
        if (user.getId() != null) {
            // throw new Exception("Create a new branch should not contain id");
        }
        setUserDefaults(user);
        return objectMapper.convertValue(userRepository.save(user), UserDTO.class);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        User user = objectMapper.convertValue(userDTO, User.class);
        if (user.getId() == null) {
            // TODO: Custom Exception should thrown
            // throw new Exception("Update an existing branch should contain id");
        }
        setUserDefaults(user);
        return objectMapper.convertValue(userRepository.save(user), UserDTO.class);
    }

    @Override
    public Boolean delete(Long userId) {
        userRepository.deleteById(userId);
        return userRepository.findById(userId).isPresent();
    }

    private void setUserDefaults(User user) {
        if (user.getId() == null) {
            //rights.setCreatedDate(new Date());
            // TODO: This default will be removed once admin_user services available
            // branch.setCreatedBy(1L);
            //} else if (branch.getCreatedDate() == null || branch.getCreatedBy() == null) {
            User tempUser = userRepository.getOne(user.getId());
            //rights.setCreatedDate(tempRights.getCreatedDate());
            //rights.setCreatedBy(tempRights.getCreatedBy());
        }
        // rights.setUpdatedDate(new Date());
        // TODO: This default will be removed once admin_user services available
        // rights.setUpdatedBy(1L);
    }
}
