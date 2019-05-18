package br.com.maverick.api.user.service;

import br.com.maverick.api.common.exception.ResourceNotFoundException;
import br.com.maverick.api.security.JwtTokenUtil;
import br.com.maverick.api.security.encoding.Md5PasswordEncoder;
import br.com.maverick.api.user.id.UserId;
import br.com.maverick.api.user.dto.UserDto;
import br.com.maverick.api.user.model.User;
import br.com.maverick.api.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private ModelMapper modelMapper;

    public User getUserByIdAndCompanyId(Integer userId, Integer companyId) {
        return this.userRepository.findByIdAndCompanyId(userId, companyId).orElseThrow(() -> new ResourceNotFoundException(String.format("Não existe usuário ID:%d.", userId)));
    }

    public Integer getNextUserId(Integer companyId){
        return this.userRepository.findNextUserId(companyId);
    }

    public User insertUserByCompanyId(Integer companyId, UserDto userDto){
        Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
        UserId userId = new UserId(this.getNextUserId(companyId), companyId);

        if(this.userRepository.findByCpf(userDto.getCpf()).isPresent()){
            throw new RuntimeException("Já existe um usuário cadastrado com o CPF: "+userDto.getCpf());
        }

        if(this.userRepository.findByEmail(userDto.getEmail()).isPresent()){
            throw new RuntimeException("Já existe um usuário cadastrado com o email: "+userDto.getEmail());
        }

        User user = new User();
        user.setId(userId);
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setCpf(userDto.getCpf());
        user.setTelephone(userDto.getTelephone());
        user.setPassword(md5PasswordEncoder.encode(userDto.getPassword()));
        user.setDateAdded(new Date());
        user.setDateModified(new Date());

        return this.userRepository.save(user);
    }

    public User getUserByCpf(String cpf) {
        return this.userRepository.findByCpf(cpf).orElse(null);
    }

    public User getUserByEmail(String email) {
        return this.userRepository.findByEmail(email).orElse(null);
    }

}
