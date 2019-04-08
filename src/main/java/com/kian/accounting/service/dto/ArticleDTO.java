package com.kian.accounting.service.dto;
import com.kian.accounting.domain.enumeration.ArticleType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the Article entity.
 */
@ApiModel(description = "The Employee entity.")
public class ArticleDTO implements Serializable {

    private Long id;

    /**
     * The firstname attribute.
     */
    @NotNull
    @ApiModelProperty(value = "The firstname attribute.", required = true)
    private BigDecimal amount;

    @NotNull
    private ArticleType type;

    @NotNull
    private String desc;


    private Long journalVoucherId;

    private Long accountId;

    private Long accountDetailId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public ArticleType getType() {
        return type;
    }

    public void setType(ArticleType type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getJournalVoucherId() {
        return journalVoucherId;
    }

    public void setJournalVoucherId(Long journalVoucherId) {
        this.journalVoucherId = journalVoucherId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long baseAccountId) {
        this.accountId = baseAccountId;
    }

    public Long getAccountDetailId() {
        return accountDetailId;
    }

    public void setAccountDetailId(Long accountDetailsId) {
        this.accountDetailId = accountDetailsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ArticleDTO articleDTO = (ArticleDTO) o;
        if (articleDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), articleDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ArticleDTO{" +
            "id=" + getId() +
            ", amount=" + getAmount() +
            ", type='" + getType() + "'" +
            ", desc='" + getDesc() + "'" +
            ", journalVoucher=" + getJournalVoucherId() +
            ", account=" + getAccountId() +
            ", accountDetail=" + getAccountDetailId() +
            "}";
    }
}
