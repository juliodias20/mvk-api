package br.com.maverick.api.user.controller;

import br.com.maverick.api.security.CurrentUser;
import br.com.maverick.api.user.dto.UserDto;
import br.com.maverick.api.user.model.User;
import br.com.maverick.api.user.service.UserService;
import br.com.maverick.api.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{userId}/companies/current")
    public User getUserByIdAndCompanyId(@PathVariable Integer userId) {
        CurrentUser currentUser = CommonUtils.getCurrentUser();
        return this.userService.getUserByIdAndCompanyId(userId, currentUser.getCompanyId());
    }

    @PostMapping("users/companies/current")
    public User insertUserByCompanyId(@RequestBody @Valid UserDto userDto) {
        CurrentUser currentUser = CommonUtils.getCurrentUser();

        return this.userService.insertUserByCompanyId(currentUser.getCompanyId(), userDto);
    }
}
