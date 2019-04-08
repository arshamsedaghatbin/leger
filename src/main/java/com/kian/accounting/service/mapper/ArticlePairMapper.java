package com.kian.accounting.service.mapper;

import com.kian.accounting.domain.ArticlePair;
import com.kian.accounting.service.dto.ArticlePairDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity ArticlePair and its DTO ArticlePairDTO.
 */
@Mapper(componentModel = "spring", uses = {ArticleMapper.class})
public interface ArticlePairMapper extends EntityMapper<ArticlePairDTO, ArticlePair> {

    @Mapping(source = "fromArticle.id", target = "fromArticleId")
    @Mapping(source = "toAccount.id", target = "toAccountId")
    ArticlePairDTO toDto(ArticlePair articlePair);

    @Mapping(source = "fromArticleId", target = "fromArticle")
    @Mapping(source = "toAccountId", target = "toAccount")
    ArticlePair toEntity(ArticlePairDTO articlePairDTO);

    default ArticlePair fromId(Long id) {
        if (id == null) {
            return null;
        }
        ArticlePair articlePair = new ArticlePair();
        articlePair.setId(id);
        return articlePair;
    }
}
