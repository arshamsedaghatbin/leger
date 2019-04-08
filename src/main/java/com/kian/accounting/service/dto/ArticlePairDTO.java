package com.kian.accounting.service.dto;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the ArticlePair entity.
 */
public class ArticlePairDTO implements Serializable {

    private Long id;


    private Long fromArticleId;

    private Long toAccountId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFromArticleId() {
        return fromArticleId;
    }

    public void setFromArticleId(Long articleId) {
        this.fromArticleId = articleId;
    }

    public Long getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Long articleId) {
        this.toAccountId = articleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ArticlePairDTO articlePairDTO = (ArticlePairDTO) o;
        if (articlePairDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), articlePairDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ArticlePairDTO{" +
            "id=" + getId() +
            ", fromArticle=" + getFromArticleId() +
            ", toAccount=" + getToAccountId() +
            "}";
    }
}
