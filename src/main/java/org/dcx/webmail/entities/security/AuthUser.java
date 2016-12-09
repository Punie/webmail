package org.dcx.webmail.entities.security;

import org.dcx.webmail.entities.Account;

import java.util.Date;

public class AuthUser
{
    private Integer id;
    private String username;
    private String firstname;
    private String lastname;
    private Date dateRegistered;
    private String token;

    public AuthUser (Account account)
    {
        this.id = account.getId ();
        this.username = account.getUsername ();
        this.firstname = account.getFirstname ();
        this.lastname = account.getLastname ();
        this.dateRegistered = account.getDateRegistered ();
        this.token = account.getUsername () + account.getPassword ();
    }

    public Integer getId ()
    {
        return id;
    }
    public void setId (Integer id)
    {
        this.id = id;
    }

    public String getUsername ()
    {
        return username;
    }
    public void setUsername (String username)
    {
        this.username = username;
    }

    public String getFirstname ()
    {
        return firstname;
    }
    public void setFirstname (String firstname)
    {
        this.firstname = firstname;
    }

    public String getLastname ()
    {
        return lastname;
    }
    public void setLastname (String lastname)
    {
        this.lastname = lastname;
    }

    public Date getDateRegistered ()
    {
        return dateRegistered;
    }
    public void setDateRegistered (Date dateRegistered)
    {
        this.dateRegistered = dateRegistered;
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
