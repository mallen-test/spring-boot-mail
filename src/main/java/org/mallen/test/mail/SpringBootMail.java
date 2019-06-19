package org.mallen.test.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * @author mallen
 * @date 6/19/19
 */
@SpringBootApplication
public class SpringBootMail {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMail.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void sendEmail(ApplicationReadyEvent event) {
        JavaMailSender mailSender = event.getApplicationContext().getBean(JavaMailSender.class);
        MailSender.sendSimpleMail(mailSender);
    }
}
