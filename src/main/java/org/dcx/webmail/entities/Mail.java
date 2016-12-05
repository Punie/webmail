package org.dcx.webmail.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

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
    private Account sender;

    @ManyToOne
    private Account receiver;

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

    public Account getReceiver ()
    {
        return receiver;
    }
    public void setReceiver (Account receiver)
    {
        this.receiver = receiver;
    }
}
