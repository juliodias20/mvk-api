package br.com.maverick.api.common.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tco_state")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_id")
    private Integer id;

    private String nick;

    private String name;

}
