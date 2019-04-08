package com.kian.accounting.service.dto;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the AccountDetails entity.
 */
public class AccountDetailsDTO implements Serializable {

    private Long id;

    @NotNull
    private String code;

    private String desc;

    private Long version;


    private Long baseAccountId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getBaseAccountId() {
        return baseAccountId;
    }

    public void setBaseAccountId(Long baseAccountId) {
        this.baseAccountId = baseAccountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AccountDetailsDTO accountDetailsDTO = (AccountDetailsDTO) o;
        if (accountDetailsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), accountDetailsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AccountDetailsDTO{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", desc='" + getDesc() + "'" +
            ", version=" + getVersion() +
            ", baseAccount=" + getBaseAccountId() +
            "}";
    }
}
