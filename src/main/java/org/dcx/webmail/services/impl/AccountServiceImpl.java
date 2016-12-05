package org.dcx.webmail.services.impl;

import org.dcx.webmail.entities.Account;
import org.dcx.webmail.repositories.AccountRepository;
import org.dcx.webmail.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService
{
    @Autowired
    private AccountRepository accountRepository;


    @Override
    public List<Account> listAll ()
    {
        List<Account> accounts = new ArrayList<> ();
        accountRepository.findAll ().forEach (accounts::add);
        return accounts;
    }

    @Override
    public Account getById (Integer id)
    {
        return accountRepository.findOne (id);
    }

    @Override
    public Account getByUsername (String username)
    {
        return accountRepository.getByUsername (username);
    }

    @Override
    public Account save (Account account)
    {
        return accountRepository.save (account);
    }

    @Override
    public void delete (Integer id)
    {
        accountRepository.delete (id);
    }
}
