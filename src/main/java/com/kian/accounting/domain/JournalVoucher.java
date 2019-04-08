package com.kian.accounting.domain;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import com.kian.accounting.domain.enumeration.JournalType;

/**
 * Task entity.
 * @author The JHipster team.
 */
@Entity
@Table(name = "journal_voucher")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class JournalVoucher implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "jhi_type", nullable = false)
    private JournalType type;

    @Column(name = "jhi_desc")
    private String desc;

    @NotNull
    @Column(name = "generation_date", nullable = false)
    private Instant generationDate;

    @NotNull
    @Column(name = "jhi_number", nullable = false)
    private String number;

    @OneToMany(mappedBy = "journalVoucher")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Article> articles = new HashSet<>();
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JournalType getType() {
        return type;
    }

    public JournalVoucher type(JournalType type) {
        this.type = type;
        return this;
    }

    public void setType(JournalType type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public JournalVoucher desc(String desc) {
        this.desc = desc;
        return this;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Instant getGenerationDate() {
        return generationDate;
    }

    public JournalVoucher generationDate(Instant generationDate) {
        this.generationDate = generationDate;
        return this;
    }

    public void setGenerationDate(Instant generationDate) {
        this.generationDate = generationDate;
    }

    public String getNumber() {
        return number;
    }

    public JournalVoucher number(String number) {
        this.number = number;
        return this;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public JournalVoucher articles(Set<Article> articles) {
        this.articles = articles;
        return this;
    }

    public JournalVoucher addArticle(Article article) {
        this.articles.add(article);
        article.setJournalVoucher(this);
        return this;
    }

    public JournalVoucher removeArticle(Article article) {
        this.articles.remove(article);
        article.setJournalVoucher(null);
        return this;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
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
        JournalVoucher journalVoucher = (JournalVoucher) o;
        if (journalVoucher.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), journalVoucher.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "JournalVoucher{" +
            "id=" + getId() +
            ", type='" + getType() + "'" +
            ", desc='" + getDesc() + "'" +
            ", generationDate='" + getGenerationDate() + "'" +
            ", number='" + getNumber() + "'" +
            "}";
    }
}
