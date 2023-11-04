package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.entity.User;
import lk.ijse.spring.repo.UserRepo;
import lk.ijse.spring.service.UserService;
import lk.ijse.spring.util.UserUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper mapper;


    @Override
    public UserDTO getUser(String username, String password) throws RuntimeException {

        User user = userRepo.findById(username).get();
        if (!user.getPassword().equals(password))
            throw new RuntimeException("Wrong Login Details. Please Try Again..!");

        UserDTO userDTO = mapper.map(user, UserDTO.class);
        UserUtil.currentUser = userDTO;
        return userDTO;

    }
}
