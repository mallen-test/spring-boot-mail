package org.mallen.test.mail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * @author mallen
 * @date 6/18/19
 */
public class PlainMailSender {
    public static JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.xxx.com");
        mailSender.setPort(587);

        mailSender.setUsername("mallen.huang");
        mailSender.setPassword("xxx");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        mailSender.setDefaultEncoding("UTF-8");

        return mailSender;
    }

    public static void main(String[] args) {

        JavaMailSender mailSender = javaMailSender();
//        MailSender.sendSimpleMail(mailSender);
        MailSender.sendMimeMail(mailSender);
    }



}
