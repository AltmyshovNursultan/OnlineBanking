package com.bank.onlinebanking.dao;

import com.bank.onlinebanking.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findUserByPhoneNumber(String phoneNumber);
}
