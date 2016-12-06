package org.dcx.webmail.controllers;

import org.dcx.webmail.entities.Account;
import org.dcx.webmail.entities.Mail;
import org.dcx.webmail.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping ("api/accounts")
public class AccountResource
{
    @Autowired
    AccountService accountService;

    @CrossOrigin
    @GetMapping
    public List<?> getAllAccounts ()
    {
        return accountService.listAll ();
    }

    @CrossOrigin
    @PostMapping
    public Account createAccount (@Valid @RequestBody Account account)
    {
        return accountService.save (account);
    }

    @CrossOrigin
    @GetMapping (value = "{id}")
    public ResponseEntity<Account> getAccountById (@PathVariable ("id") Integer id)
    {
        Account account = accountService.getById (id);
        if (account == null)
            return new ResponseEntity<> (HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<> (account, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping (value = "{id}/received")
    public ResponseEntity<Set<Mail>> getMailsReceived (@PathVariable ("id") Integer id)
    {
        Account account = accountService.getById (id);
        if (account == null)
            return new ResponseEntity<> (HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<> (account.getReceivedMails (), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping (value = "{id}/sent")
    public ResponseEntity<Set<Mail>> getMailsSent (@PathVariable ("id") Integer id)
    {
        Account account = accountService.getById (id);
        if (account == null)
            return new ResponseEntity<> (HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<> (account.getSentMails (), HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping (value = "{id}")
    public ResponseEntity<Account> updateAccount (@Valid @RequestBody Account account,
                                                  @PathVariable ("id") Integer id)
    {
        Account accountData = accountService.getById (id);
        if (accountData == null)
            return new ResponseEntity<> (HttpStatus.NOT_FOUND);

        accountData.setUsername (account.getUsername ());
        accountData.setPassword (account.getPassword ());
        accountData.setFirstname (account.getFirstname ());
        accountData.setLastname (account.getLastname ());

        Account updatedAccount = accountService.save (accountData);

        return new ResponseEntity<> (updatedAccount, HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping (value = "{id}")
    public void deleteAccount (@PathVariable ("id") Integer id)
    {
        accountService.delete (id);
    }
}
