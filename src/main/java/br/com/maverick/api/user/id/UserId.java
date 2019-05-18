package br.com.maverick.api.user.id;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class UserId implements Serializable {

    private Integer userId;
    private Integer companyId;

    public UserId() {
    }

    public UserId(Integer userId, Integer companyId) {
        this.userId = userId;
        this.companyId = companyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}
