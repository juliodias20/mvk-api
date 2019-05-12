package br.com.maverick.api.company.service;

import br.com.maverick.api.company.model.Company;
import br.com.maverick.api.company.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public Company findById(Integer id) {
        Optional<Company> c = this.companyRepository.findById(id);

        if (c.isPresent()) {
            return c.get();
        } else {
            throw new RuntimeException("Não há registro de Companhia com o Id informado");
        }
    }
}
