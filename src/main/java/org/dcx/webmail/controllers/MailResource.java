package org.dcx.webmail.controllers;

import org.dcx.webmail.entities.Mail;
import org.dcx.webmail.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("api/mails")
public class MailResource
{
    @Autowired
    MailService mailService;

    @GetMapping
    public List<?> getAllMails ()
    {
        return mailService.listAll ();
    }

    @PostMapping
    public Mail createMail (@Valid @RequestBody Mail mail)
    {
        return mailService.save (mail);
    }

    @GetMapping (value = "{id}")
    public ResponseEntity<Mail> getMailById (@PathVariable ("id") Integer id)
    {
        Mail mail = mailService.getById (id);
        if (mail == null)
            return new ResponseEntity<> (HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<> (mail, HttpStatus.OK);
    }

    @PutMapping (value = "{id}")
    public ResponseEntity<Mail> updateMail (@Valid @RequestBody Mail mail,
                                                  @PathVariable ("id") Integer id)
    {
        Mail mailData = mailService.getById (id);
        if (mailData == null)
            return new ResponseEntity<> (HttpStatus.NOT_FOUND);

        mailData.setSubject (mail.getSubject ());
        mailData.setBody (mail.getBody ());
        mailData.setSender (mail.getSender ());
        mailData.setReceivers (mail.getReceivers ());

        Mail updatedMail = mailService.save (mailData);

        return new ResponseEntity<> (updatedMail, HttpStatus.OK);
    }

    @DeleteMapping (value = "{id}")
    public void deleteMail (@PathVariable ("id") Integer id)
    {
        mailService.delete (id);
    }
}
