package org.dcx.webmail.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table (name = "mail")
public class Mail
{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;

    @Column (name = "subject")
    private String subject;

    @Column (name = "body")
    private String body;

    @Column (name = "date_sent")
    private Date dateSent = new Date ();

    @ManyToOne
    @JoinColumn (name = "sender_id")
    private Account sender;

    @ManyToMany
    @JoinTable (name = "mail_receivers",
                joinColumns = @JoinColumn (name = "mail_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn (name = "receiver_id", referencedColumnName = "id"))
    private Set<Account> receivers;

    public Integer getId ()
    {
        return id;
    }
    public void setId (Integer id)
    {
        this.id = id;
    }

    public String getSubject ()
    {
        return subject;
    }
    public void setSubject (String subject)
    {
        this.subject = subject;
    }

    public String getBody ()
    {
        return body;
    }
    public void setBody (String body)
    {
        this.body = body;
    }

    public Date getDateSent ()
    {
        return dateSent;
    }
    public void setDateSent (Date dateSent)
    {
        this.dateSent = dateSent;
    }

    public Account getSender ()
    {
        return sender;
    }
    public void setSender (Account sender)
    {
        this.sender = sender;
    }

    public Set<Account> getReceivers ()
    {
        return receivers;
    }
    public void setReceivers (Set<Account> receivers)
    {
        this.receivers = receivers;
    }
}
