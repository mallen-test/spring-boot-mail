package org.mallen.test.mail;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author mallen
 * @date 6/19/19
 */
public class MailSender {
    public static void sendMimeMail(JavaMailSender mailSender) {
        try {
            MimeMessage msg = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(msg, true);

            helper.setTo("mallen.huang@xxx.com");
            helper.setSubject("plain java sender test");
            helper.setText("<h1>测试纯java方式带附件的邮件发送</h1>");
            helper.setFrom("mallen.huang@xxx.com");

            Path path = Paths.get("/home/mallen/Desktop/settings.xml");
            helper.addAttachment(path.getFileName().toString(), path.toFile());

            mailSender.send(helper.getMimeMessage());
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    public static void sendSimpleMail(JavaMailSender mailSender) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("mallen.huang@xxx.com");
        msg.setSubject("plain java sender test");
        msg.setText("测试纯java方式的邮件发送");
        msg.setFrom("mallen.huang@xxx.com");

        mailSender.send(msg);
    }
}
