package org.dcx.webmail.repositories;

import org.dcx.webmail.entities.Mail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailRepository extends JpaRepository<Mail, Integer>
{
}
