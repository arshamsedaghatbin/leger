package com.kian.accounting.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kian.accounting.domain.enumeration.ArticleType;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * The Employee entity.
 */
@Entity
@Table(name = "article")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    /**
     * The firstname attribute.
     */
    @NotNull
    @Column(name = "amount", precision = 10, scale = 2, nullable = false)
    private BigDecimal amount;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "jhi_type", nullable = false)
    private ArticleType type;

    @NotNull
    @Column(name = "jhi_desc", nullable = false)
    private String desc;

    @ManyToOne
    @JsonIgnoreProperties("articles")
    private JournalVoucher journalVoucher;

    @OneToOne
    @JoinColumn(unique = true)
    private BaseAccount account;

    @OneToOne
    @JoinColumn(unique = true)
    private AccountDetails accountDetail;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Article amount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public ArticleType getType() {
        return type;
    }

    public Article type(ArticleType type) {
        this.type = type;
        return this;
    }

    public void setType(ArticleType type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public Article desc(String desc) {
        this.desc = desc;
        return this;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public JournalVoucher getJournalVoucher() {
        return journalVoucher;
    }

    public Article journalVoucher(JournalVoucher journalVoucher) {
        this.journalVoucher = journalVoucher;
        return this;
    }

    public void setJournalVoucher(JournalVoucher journalVoucher) {
        this.journalVoucher = journalVoucher;
    }

    public BaseAccount getAccount() {
        return account;
    }

    public Article account(BaseAccount baseAccount) {
        this.account = baseAccount;
        return this;
    }

    public void setAccount(BaseAccount baseAccount) {
        this.account = baseAccount;
    }

    public AccountDetails getAccountDetail() {
        return accountDetail;
    }

    public Article accountDetail(AccountDetails accountDetails) {
        this.accountDetail = accountDetails;
        return this;
    }

    public void setAccountDetail(AccountDetails accountDetails) {
        this.accountDetail = accountDetails;
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
        Article article = (Article) o;
        if (article.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), article.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Article{" +
            "id=" + getId() +
            ", amount=" + getAmount() +
            ", type='" + getType() + "'" +
            ", desc='" + getDesc() + "'" +
            "}";
    }
}
