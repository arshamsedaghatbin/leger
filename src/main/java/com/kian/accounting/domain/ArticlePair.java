package com.kian.accounting.domain;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A ArticlePair.
 */
@Entity
@Table(name = "article_pair")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ArticlePair implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @OneToOne
    @JoinColumn(unique = true)
    private Article fromArticle;

    @OneToOne
    @JoinColumn(unique = true)
    private Article toAccount;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Article getFromArticle() {
        return fromArticle;
    }

    public ArticlePair fromArticle(Article article) {
        this.fromArticle = article;
        return this;
    }

    public void setFromArticle(Article article) {
        this.fromArticle = article;
    }

    public Article getToAccount() {
        return toAccount;
    }

    public ArticlePair toAccount(Article article) {
        this.toAccount = article;
        return this;
    }

    public void setToAccount(Article article) {
        this.toAccount = article;
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
        ArticlePair articlePair = (ArticlePair) o;
        if (articlePair.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), articlePair.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ArticlePair{" +
            "id=" + getId() +
            "}";
    }
}
