package br.com.maverick.api.auth.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class UserCredentialsDto {
    @Email
    @NotEmpty
    private String username;

    @NotEmpty
    private String password;
}
