package com.kian.accounting.repository;

import com.kian.accounting.domain.BaseAccount;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the BaseAccount entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BaseAccountRepository extends JpaRepository<BaseAccount, Long> {

}
