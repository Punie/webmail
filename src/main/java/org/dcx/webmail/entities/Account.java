package org.dcx.webmail.entities;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

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

    @OneToMany (mappedBy = "sender", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Mail> sentMails;

    @ManyToMany (mappedBy = "receivers", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Mail> receivedMails;

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

    public Set<Mail> getSentMails ()
    {
        return sentMails;
    }
    public void setSentMails (Set<Mail> sentMails)
    {
        this.sentMails = sentMails;
    }

    public Set<Mail> getReceivedMails ()
    {
        return receivedMails;
    }
    public void setReceivedMails (Set<Mail> receivedMails)
    {
        this.receivedMails = receivedMails;
    }
}
