package br.com.maverick.api.common.service;

import br.com.maverick.api.common.model.City;
import br.com.maverick.api.common.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> getAllByStateId(Integer stateId) {
        List<City> cities = this.cityRepository.findAllByStateId(stateId);

        if(cities.size() == 0){
            throw new RuntimeException("Nenhuma cidade encontrada.");
        }

        return cities;
    }

}
