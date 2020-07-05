package com.example.webshop.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class User {
    private Long id;
    private String account;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String user_name;
    private String tel;
    private String phone;
    private String zip_code;
    private String address;
    private String email;
    private LocalDateTime created;
    private LocalDateTime modified;
}