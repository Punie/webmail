package org.dcx.webmail.entities.security;

import org.dcx.webmail.entities.Account;

public class AuthUser
{
    private Integer id;
    private String token;

    public AuthUser (Account account)
    {
        this.id = account.getId ();
        this.token = account.getUsername () + account.getPassword ();
    }

    public String getToken ()
    {
        return token;
    }
    public void setToken (String token)
    {
        this.token = token;
    }
}
