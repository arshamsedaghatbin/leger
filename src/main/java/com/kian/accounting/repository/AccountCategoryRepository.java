package com.kian.accounting.repository;

import com.kian.accounting.domain.AccountCategory;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the AccountCategory entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AccountCategoryRepository extends JpaRepository<AccountCategory, Long> {

}
