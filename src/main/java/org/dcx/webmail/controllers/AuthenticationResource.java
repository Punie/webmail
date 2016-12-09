package org.dcx.webmail.controllers;

import org.dcx.webmail.entities.Account;
import org.dcx.webmail.entities.security.AuthUser;
import org.dcx.webmail.entities.security.SecUser;
import org.dcx.webmail.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping ("api/auth")
public class AuthenticationResource
{
    @Autowired
    AccountService accountService;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<AuthUser> checkCredentials(@Valid @RequestBody SecUser secUser)
    {
        Account account = accountService.getByUsername (secUser.getUsername());
        if (account == null || !account.getPassword ().equals (secUser.getPassword()))
            return new ResponseEntity<> (HttpStatus.NOT_FOUND);
        return new ResponseEntity<> (new AuthUser (account), HttpStatus.OK);
    }
}
