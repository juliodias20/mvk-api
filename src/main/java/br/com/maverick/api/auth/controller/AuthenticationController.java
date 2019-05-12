package br.com.maverick.api.auth.controller;

import br.com.maverick.api.auth.dto.CurrentUserDto;
import br.com.maverick.api.auth.dto.UserCredentialsDto;
import br.com.maverick.api.auth.service.AuthenticationService;
import br.com.maverick.api.security.CurrentUser;
import br.com.maverick.api.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/auth")
    public CurrentUserDto authenticate(@Valid @RequestBody UserCredentialsDto userCredentialsDto) {
        return this.authenticationService.authenticate(userCredentialsDto);
    }

    @GetMapping("/auth")
    public void teste(){
        CurrentUser currentUser = CommonUtils.getCurrentUser();
        System.out.println(currentUser.toString());
    }
}
