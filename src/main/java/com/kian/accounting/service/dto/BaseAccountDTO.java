package com.kian.accounting.service.dto;
import io.swagger.annotations.ApiModel;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the BaseAccount entity.
 */
@ApiModel(description = "not an ignored comment")
public class BaseAccountDTO implements Serializable {

    private Long id;

    private String name;

    @NotNull
    private String code;

    private String desc;

    @NotNull
    private String completeCode;

    private Long version;


    private Long accountCategoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCompleteCode() {
        return completeCode;
    }

    public void setCompleteCode(String completeCode) {
        this.completeCode = completeCode;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getAccountCategoryId() {
        return accountCategoryId;
    }

    public void setAccountCategoryId(Long accountCategoryId) {
        this.accountCategoryId = accountCategoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BaseAccountDTO baseAccountDTO = (BaseAccountDTO) o;
        if (baseAccountDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), baseAccountDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BaseAccountDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", code='" + getCode() + "'" +
            ", desc='" + getDesc() + "'" +
            ", completeCode='" + getCompleteCode() + "'" +
            ", version=" + getVersion() +
            ", accountCategory=" + getAccountCategoryId() +
            "}";
    }
}
