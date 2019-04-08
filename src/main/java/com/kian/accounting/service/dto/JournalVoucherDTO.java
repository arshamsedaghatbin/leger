package com.kian.accounting.service.dto;
import com.kian.accounting.domain.enumeration.JournalType;
import io.swagger.annotations.ApiModel;
import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the JournalVoucher entity.
 */
@ApiModel(description = "Task entity. @author The JHipster team.")
public class JournalVoucherDTO implements Serializable {

    private Long id;

    @NotNull
    private JournalType type;

    private String desc;

    private Instant generationDate;

    @NotNull
    private String number;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JournalType getType() {
        return type;
    }

    public void setType(JournalType type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Instant getGenerationDate() {
        return generationDate;
    }

    public void setGenerationDate(Instant generationDate) {
        this.generationDate = generationDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        JournalVoucherDTO journalVoucherDTO = (JournalVoucherDTO) o;
        if (journalVoucherDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), journalVoucherDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "JournalVoucherDTO{" +
            "id=" + getId() +
            ", type='" + getType() + "'" +
            ", desc='" + getDesc() + "'" +
            ", generationDate='" + getGenerationDate() + "'" +
            ", number='" + getNumber() + "'" +
            "}";
    }
}
