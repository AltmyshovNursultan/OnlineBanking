package com.bank.onlinebanking.service.impls;

import com.bank.onlinebanking.dao.UserRepo;
import com.bank.onlinebanking.mapper.UserMapper;
import com.bank.onlinebanking.model.dto.UserDto;
import com.bank.onlinebanking.model.entity.User;
import com.bank.onlinebanking.model.response.UpdatedUserResponse;
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

    // Create new user
    public UserDto createUser(String firstName, String lastName, String password, String phoneNumber){
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPhoneNumber(phoneNumber);
        user.setPassword(password);
        return userMapper.toDto(user);
    }
    // Find user by phone number
    @Override
    public User findUserByPhoneNumber(String userNumber) {
        return userRepo.findUserByPhoneNumber(userNumber);
    }

    // Updating user's password
    @Override
    public UpdatedUserResponse updatePassword(String phoneNumber, String password) {
        User user = findUserByPhoneNumber(phoneNumber);
        if (user ==  null){
            throw new NullPointerException("No such a user exists!");
        }
        String oldPassword = user.getPassword();
        user.setPassword(password);
        userRepo.save(user);
        UpdatedUserResponse updatedUserResponse = new UpdatedUserResponse();
        updatedUserResponse.setFirstName(user.getFirstName());
        updatedUserResponse.setLastName(user.getLastName());
        updatedUserResponse.setPhoneNumber(phoneNumber);
        updatedUserResponse.setOldPassword(oldPassword);
        updatedUserResponse.setNewPassword(password);
        return updatedUserResponse;
    }

}
