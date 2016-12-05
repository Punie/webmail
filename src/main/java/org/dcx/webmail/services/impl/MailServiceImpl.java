package org.dcx.webmail.services.impl;

import org.dcx.webmail.entities.Mail;
import org.dcx.webmail.repositories.MailRepository;
import org.dcx.webmail.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailServiceImpl implements MailService
{
    @Autowired
    private MailRepository mailRepository;

    @Override
    public List<?> listAll ()
    {
        List<Mail> mails = new ArrayList<> ();
        mailRepository.findAll ().forEach (mails::add);
        return mails;
    }

    @Override
    public Mail getById (Integer id)
    {
        return mailRepository.findOne (id);
    }

    @Override
    public Mail save (Mail mail)
    {
        return mailRepository.save (mail);
    }

    @Override
    public void delete (Integer id)
    {
        mailRepository.delete (id);
    }
}
