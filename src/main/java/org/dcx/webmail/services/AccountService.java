package org.dcx.webmail.services;

import org.dcx.webmail.entities.Account;

public interface AccountService extends CRUDService<Account>
{
    Account getByUsername (String username);
}
