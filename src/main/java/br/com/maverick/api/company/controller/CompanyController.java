package br.com.maverick.api.company.controller;

import br.com.maverick.api.security.CurrentUser;
import br.com.maverick.api.company.model.Company;
import br.com.maverick.api.company.service.CompanyService;
import br.com.maverick.api.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @ResponseBody
    @GetMapping("/companies/{id}")
    public Company getCompanyById(@PathVariable  Integer id) {
        return this.companyService.findById(id);
    }
}
