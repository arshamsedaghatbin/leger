package com.kian.accounting.domain;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A AccountGroup.
 */
@Entity
@Table(name = "account_group")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class AccountGroup implements Serializable {

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

    @Column(name = "version")
    private Long version;

    @OneToMany(mappedBy = "accountGroup")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<AccountCategory> accountCategories = new HashSet<>();
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

    public AccountGroup name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public AccountGroup code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public AccountGroup desc(String desc) {
        this.desc = desc;
        return this;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getVersion() {
        return version;
    }

    public AccountGroup version(Long version) {
        this.version = version;
        return this;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Set<AccountCategory> getAccountCategories() {
        return accountCategories;
    }

    public AccountGroup accountCategories(Set<AccountCategory> accountCategories) {
        this.accountCategories = accountCategories;
        return this;
    }

    public AccountGroup addAccountCategory(AccountCategory accountCategory) {
        this.accountCategories.add(accountCategory);
        accountCategory.setAccountGroup(this);
        return this;
    }

    public AccountGroup removeAccountCategory(AccountCategory accountCategory) {
        this.accountCategories.remove(accountCategory);
        accountCategory.setAccountGroup(null);
        return this;
    }

    public void setAccountCategories(Set<AccountCategory> accountCategories) {
        this.accountCategories = accountCategories;
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
        AccountGroup accountGroup = (AccountGroup) o;
        if (accountGroup.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), accountGroup.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AccountGroup{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", code='" + getCode() + "'" +
            ", desc='" + getDesc() + "'" +
            ", version=" + getVersion() +
            "}";
    }
}
