package com.kian.accounting.repository;

import com.kian.accounting.domain.ArticlePair;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the ArticlePair entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ArticlePairRepository extends JpaRepository<ArticlePair, Long> {

}
