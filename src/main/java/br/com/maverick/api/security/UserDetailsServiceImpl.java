package br.com.maverick.api.security;

import br.com.maverick.api.user.model.User;
import br.com.maverick.api.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findFirstByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return new CurrentUser(
                user.getId().getUserId(),
                user.getId().getCompanyId(),
                user.getName(),
                user.getCpf(),
                user.getEmail(),
                user.getPassword()
        );
    }
}
