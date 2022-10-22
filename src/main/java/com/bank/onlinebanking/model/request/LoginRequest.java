package com.bank.onlinebanking.model.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RequestParam;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginRequest {
    String userNumber;
    String password;

}
