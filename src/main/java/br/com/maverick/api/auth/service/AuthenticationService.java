package br.com.maverick.api.auth.service;

import br.com.maverick.api.auth.dto.CurrentUserDto;
import br.com.maverick.api.auth.dto.UserCredentialsDto;
import br.com.maverick.api.security.CurrentUser;
import br.com.maverick.api.security.JwtTokenUtil;
import br.com.maverick.api.user.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AuthenticationService {
    @Autowired
    UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private ModelMapper modelMapper;

    public CurrentUserDto authenticate(UserCredentialsDto userCredentialsDto) {
        Authentication authentication = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userCredentialsDto.getUsername(),
                        userCredentialsDto.getPassword(),
                        Collections.emptyList()
                )
        );

        CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
        String token = this.jwtTokenUtil.generateToken(currentUser);

        CurrentUserDto currentUserDto = this.modelMapper.map(currentUser, CurrentUserDto.class);
        currentUserDto.setAccessToken(token);

        return currentUserDto;
    }

}
