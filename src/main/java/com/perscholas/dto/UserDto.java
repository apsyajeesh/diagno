package com.perscholas.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int phoneNumber;
    private int age;
    private String gender;

}
