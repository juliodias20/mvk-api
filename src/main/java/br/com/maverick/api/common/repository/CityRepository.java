package br.com.maverick.api.common.repository;

import br.com.maverick.api.common.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    @Query(value = "SELECT * " +
                   "FROM tco_city c " +
                   "WHERE c.state_id = :stateId", nativeQuery = true)
    List<City> findAllByStateId(@Param("stateId") Integer stateId);
}
