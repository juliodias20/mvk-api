package br.com.maverick.api.common.model;

import br.com.maverick.api.common.id.CityId;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tco_city")
public class City {

    @EmbeddedId
    private CityId id;

    private String name;

    public City() {
    }

    public City(CityId id, String name) {
        this.id = id;
        this.name = name;
    }

    public CityId getId() {
        return id;
    }

    public void setId(CityId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


