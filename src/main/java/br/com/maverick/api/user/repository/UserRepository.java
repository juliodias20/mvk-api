package br.com.maverick.api.user.repository;

import br.com.maverick.api.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findFirstByEmail(String email);

    Optional<User> findByCpf(String cpf);

    Optional<User> findByEmail(String email);

    @Query(value = "SELECT u.* " +
                   "FROM tco_user u " +
                   "WHERE u.user_id = :userId " +
                   "AND u.company_id = :companyId", nativeQuery = true)
    Optional<User> findByIdAndCompanyId(@Param("userId") Integer userId, @Param("companyId") Integer companyId);

    @Query(value = "SELECT COALESCE(max(user_id),0)+1 AS PK " +
                   "FROM tco_user u " +
                   "WHERE u.company_id = :companyId", nativeQuery = true)
    Integer findNextUserId(@Param("companyId") Integer companyId);

}
