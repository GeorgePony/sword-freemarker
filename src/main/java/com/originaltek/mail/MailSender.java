package com.originaltek.mail;


import com.originaltek.freemarker.MailFreeEntity;
import com.originaltek.intf.MailSenderIntf;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.internet.MimeMessage;
import java.io.IOException;

//@Component
@Slf4j
public class MailSender implements MailSenderIntf {

    @Value("${spring.mail.username}")
    private String sender;

    @Value("${spring.mail.receivers}")
    private String receivers;

    @Autowired
    private JavaMailSender mailSender;


    @Autowired
    private FreeMarkerConfigurer configurer;

    @Override
    public String sendEmail(){
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, false, "utf8");
            messageHelper.setFrom(sender);
            messageHelper.setTo(receivers.split(";"));
            messageHelper.setSubject("告警：交通事件消息推送失败，请尽快安排线下处理！");

            MailFreeEntity mailFreeEntity = new MailFreeEntity("陈" , "袁" , "Flower" , "买错了");

            messageHelper.setText(this.getMailText(mailFreeEntity), true);
            mailSender.send(message);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }



    private String getMailText(MailFreeEntity mailFreeEntity) throws IOException, TemplateException {
        Template template = configurer.getConfiguration().getTemplate("event_post_failed_mail.ftl");
        return FreeMarkerTemplateUtils.processTemplateIntoString(template, mailFreeEntity);
    }

}
