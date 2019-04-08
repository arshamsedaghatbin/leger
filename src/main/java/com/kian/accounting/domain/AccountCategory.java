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
 * A AccountCategory.
 */
@Entity
@Table(name = "account_category")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class AccountCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name="sequenceGenerator", sequenceName = "sequenceGenerator", allocationSize = 1)
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
    @JsonIgnoreProperties("accountCategories")
    private AccountGroup accountGroup;

    @OneToMany(mappedBy = "accountCategory")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<BaseAccount> accounts = new HashSet<>();
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

    public AccountCategory name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public AccountCategory code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public AccountCategory desc(String desc) {
        this.desc = desc;
        return this;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCompleteCode() {
        return completeCode;
    }

    public AccountCategory completeCode(String completeCode) {
        this.completeCode = completeCode;
        return this;
    }

    public void setCompleteCode(String completeCode) {
        this.completeCode = completeCode;
    }

    public Long getVersion() {
        return version;
    }

    public AccountCategory version(Long version) {
        this.version = version;
        return this;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public AccountGroup getAccountGroup() {
        return accountGroup;
    }

    public AccountCategory accountGroup(AccountGroup accountGroup) {
        this.accountGroup = accountGroup;
        return this;
    }

    public void setAccountGroup(AccountGroup accountGroup) {
        this.accountGroup = accountGroup;
    }

    public Set<BaseAccount> getAccounts() {
        return accounts;
    }

    public AccountCategory accounts(Set<BaseAccount> baseAccounts) {
        this.accounts = baseAccounts;
        return this;
    }

    public AccountCategory addAccount(BaseAccount baseAccount) {
        this.accounts.add(baseAccount);
        baseAccount.setAccountCategory(this);
        return this;
    }

    public AccountCategory removeAccount(BaseAccount baseAccount) {
        this.accounts.remove(baseAccount);
        baseAccount.setAccountCategory(null);
        return this;
    }

    public void setAccounts(Set<BaseAccount> baseAccounts) {
        this.accounts = baseAccounts;
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
        AccountCategory accountCategory = (AccountCategory) o;
        if (accountCategory.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), accountCategory.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AccountCategory{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", code='" + getCode() + "'" +
            ", desc='" + getDesc() + "'" +
            ", completeCode='" + getCompleteCode() + "'" +
            ", version=" + getVersion() +
            "}";
    }
}
