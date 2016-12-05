package org.dcx.webmail.repositories;

import org.dcx.webmail.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer>
{
    Account getByUsername (String username);
}
