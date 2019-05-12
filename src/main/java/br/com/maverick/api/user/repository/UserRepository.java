package br.com.maverick.api.user.repository;

import br.com.maverick.api.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findFirstByEmail(String email);

    Optional<User> findByCpf(String cpf);

    Optional<User> findByEmail(String email);

}
