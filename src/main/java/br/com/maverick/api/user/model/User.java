package br.com.maverick.api.user.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tco_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    private Integer companyId;

    private String name;

    private String email;

    private String cpf;

    private String telephone;

    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;
}
