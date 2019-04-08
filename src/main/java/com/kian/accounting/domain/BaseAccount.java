package com.kian.accounting.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * not an ignored comment
 */
@Entity
@Table(name = "base_account")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BaseAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "jhi_desc")
    private String desc;

    @NotNull
    @Column(name = "complete_code", nullable = false)
    private String completeCode;

    @Column(name = "version")
    private Long version;

    @ManyToOne
    @JsonIgnoreProperties("accounts")
    private AccountCategory accountCategory;

    @OneToMany(mappedBy = "baseAccount")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<AccountDetails> accountDetails = new HashSet<>();
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public BaseAccount name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public BaseAccount code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public BaseAccount desc(String desc) {
        this.desc = desc;
        return this;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCompleteCode() {
        return completeCode;
    }

    public BaseAccount completeCode(String completeCode) {
        this.completeCode = completeCode;
        return this;
    }

    public void setCompleteCode(String completeCode) {
        this.completeCode = completeCode;
    }

    public Long getVersion() {
        return version;
    }

    public BaseAccount version(Long version) {
        this.version = version;
        return this;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public AccountCategory getAccountCategory() {
        return accountCategory;
    }

    public BaseAccount accountCategory(AccountCategory accountCategory) {
        this.accountCategory = accountCategory;
        return this;
    }

    public void setAccountCategory(AccountCategory accountCategory) {
        this.accountCategory = accountCategory;
    }

    public Set<AccountDetails> getAccountDetails() {
        return accountDetails;
    }

    public BaseAccount accountDetails(Set<AccountDetails> accountDetails) {
        this.accountDetails = accountDetails;
        return this;
    }

    public BaseAccount addAccountDetail(AccountDetails accountDetails) {
        this.accountDetails.add(accountDetails);
        accountDetails.setBaseAccount(this);
        return this;
    }

    public BaseAccount removeAccountDetail(AccountDetails accountDetails) {
        this.accountDetails.remove(accountDetails);
        accountDetails.setBaseAccount(null);
        return this;
    }

    public void setAccountDetails(Set<AccountDetails> accountDetails) {
        this.accountDetails = accountDetails;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseAccount baseAccount = (BaseAccount) o;
        if (baseAccount.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), baseAccount.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "BaseAccount{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", code='" + getCode() + "'" +
            ", desc='" + getDesc() + "'" +
            ", completeCode='" + getCompleteCode() + "'" +
            ", version=" + getVersion() +
            "}";
    }
}
