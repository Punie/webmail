package org.dcx.webmail.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "account")
public class Account
{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Column (name = "username")
    private String username;

    @NotNull
    @Column (name = "firstname")
    private String firstname;

    @NotNull
    @Column (name = "lastname")
    private String lastname;

    @NotNull
    @Column (name = "date_registered")
    private Date dateRegistered = new Date ();

    @OneToMany
    @JsonIgnore
    private List<Mail> sentMails;

    @OneToMany
    @JsonIgnore
    private List<Mail> receivedMails;

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

    public List<Mail> getSentMails ()
    {
        return sentMails;
    }
    public void setSentMails (List<Mail> sentMails)
    {
        this.sentMails = sentMails;
    }

    public List<Mail> getReceivedMails ()
    {
        return receivedMails;
    }
    public void setReceivedMails (List<Mail> receivedMails)
    {
        this.receivedMails = receivedMails;
    }
}
