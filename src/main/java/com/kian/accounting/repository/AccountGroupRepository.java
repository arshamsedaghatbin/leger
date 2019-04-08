package com.kian.accounting.repository;

import com.kian.accounting.domain.AccountGroup;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the AccountGroup entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AccountGroupRepository extends JpaRepository<AccountGroup, Long> {

}
