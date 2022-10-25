package com.bank.onlinebanking.model.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdatedUserResponse {
    String phoneNumber;
    String firstName;
    String lastName;
    String oldPassword;
    String newPassword;
}
