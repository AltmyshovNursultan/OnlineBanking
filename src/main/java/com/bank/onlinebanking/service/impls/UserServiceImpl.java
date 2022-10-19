package com.bank.onlinebanking.service.impls;

import com.bank.onlinebanking.dao.UserRepo;
import com.bank.onlinebanking.mapper.UserMapper;
import com.bank.onlinebanking.model.dto.UserDto;
import com.bank.onlinebanking.model.entity.User;
import com.bank.onlinebanking.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
        this.userMapper = UserMapper.INSTANCE;
    }

        public UserDto createUser(String firstName, String lastName, String password, String phoneNumber){
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPhoneNumber(phoneNumber);
        user.setPassword(password);
        return userMapper.toDto(user);
    }
}
