package br.com.maverick.api.user.service;

import br.com.maverick.api.common.exception.ResourceNotFoundException;
import br.com.maverick.api.security.JwtTokenUtil;
import br.com.maverick.api.user.model.User;
import br.com.maverick.api.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private ModelMapper modelMapper;

    public User getUserById(Integer id) {
        return this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("User not found with identifier %d", id)));
    }

    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    public User getUserByCpf(String cpf) {
        return this.userRepository.findByCpf(cpf).orElse(null);
    }

    public User getUserByEmail(String email) {
        return this.userRepository.findByEmail(email).orElse(null);
    }

}
