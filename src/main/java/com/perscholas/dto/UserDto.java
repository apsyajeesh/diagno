package com.perscholas.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private long id;
    private String firstName;
    private String lastName;
    public String email;
    private String password;
    private Integer phoneNumber;
    private Integer age;
    private String gender;
}
