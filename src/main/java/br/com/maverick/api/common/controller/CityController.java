package br.com.maverick.api.common.controller;

import br.com.maverick.api.common.model.CepAddress;
import br.com.maverick.api.common.model.City;
import br.com.maverick.api.common.service.CepService;
import br.com.maverick.api.common.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private CepService cepService;

    @GetMapping("/cities/states/{stateId}")
    public List<City> getCityByNameAndStateId(@PathVariable Integer stateId){
        return this.cityService.getAllByStateId(stateId);
    }

    @GetMapping("/cep/{cep}")
    public CepAddress getCep(@PathVariable String cep){
        return this.cepService.searchCep(cep);
    }
}
