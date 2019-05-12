package br.com.maverick.api.company.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tco_company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Integer id;

    private String companyName;

    private String cnpj;

    private String socialName;

    private String state;

    private String city;

    private String neighborhood;

    private String street;

    private Integer streetNumber;

    private String postalCode;
}
