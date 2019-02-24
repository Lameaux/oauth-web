package com.euromoby.oauth.dto;

import com.euromoby.oauth.dto.annotations.FieldsValueMatch;

import javax.validation.constraints.*;

@FieldsValueMatch(
        field = "password",
        fieldMatch = "verifyPassword",
        message = "Passwords do not match!"
)
public class RegisterForm {
    @NotNull
    @NotBlank
    @Size(min=2, max=255)
    private String firstName;

    @NotNull
    @NotBlank
    @Size(min=2, max=255)
    private String lastName;

    @NotNull
    @NotBlank
    @Email
    private String email;

    @NotNull
    @NotBlank
    @Size(min=6)
    private String password;

    @NotNull
    @NotBlank
    @Size(min=6)
    private String verifyPassword;

    @NotNull
    @AssertTrue
    private Boolean agree;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    public Boolean getAgree() {
        return agree;
    }

    public void setAgree(Boolean agree) {
        this.agree = agree;
    }
}
