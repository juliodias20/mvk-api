package br.com.maverick.api.common.id;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CityId implements Serializable {

    private Integer cityId;

    private Integer stateId;

    public CityId() {
    }

    public CityId(Integer cityId, Integer stateId) {
        this.cityId = cityId;
        this.stateId = stateId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }
}
