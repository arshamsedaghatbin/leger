package com.kian.accounting.service.mapper;

import com.kian.accounting.domain.Article;
import com.kian.accounting.service.dto.ArticleDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Article and its DTO ArticleDTO.
 */
@Mapper(componentModel = "spring", uses = {JournalVoucherMapper.class, BaseAccountMapper.class, AccountDetailsMapper.class})
public interface ArticleMapper extends EntityMapper<ArticleDTO, Article> {

    @Mapping(source = "journalVoucher.id", target = "journalVoucherId")
    @Mapping(source = "account.id", target = "accountId")
    @Mapping(source = "accountDetail.id", target = "accountDetailId")
    ArticleDTO toDto(Article article);

    @Mapping(source = "journalVoucherId", target = "journalVoucher")
    @Mapping(source = "accountId", target = "account")
    @Mapping(source = "accountDetailId", target = "accountDetail")
    Article toEntity(ArticleDTO articleDTO);

    default Article fromId(Long id) {
        if (id == null) {
            return null;
        }
        Article article = new Article();
        article.setId(id);
        return article;
    }
}
