package com.database.restDatabase.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue
    private Integer userId;
    @NotNull(message = "Invalid user name")
    private String name;
    @Min(18)
    @Max(60)
    private Integer age;
    @Email(message = "Invalid user email")
    private String email;
    @NotBlank(message = "Invalid user nationality")
    private String nationality;

    public User() {
    }

    public User(Integer userId, String name, Integer age, String email, String nationality) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.email = email;
        this.nationality = nationality;
    }
    public Integer getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getNationality() {
        return nationality;
    }

}
