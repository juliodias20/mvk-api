package br.com.maverick.api.common.repository;

import br.com.maverick.api.common.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<State,Integer> {

    List<State> findByNick(String nick);
}
