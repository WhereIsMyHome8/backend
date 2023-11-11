package com.mvc.service;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class MailServiceImpl implements MailService
{
   @Autowired
    private JavaMailSender mailSender;

    @Override
    public String makeCode(int size) {
        Random ran = new Random();
        StringBuffer sb = new StringBuffer();
        int num = 0;
        do {
            num = ran.nextInt(75) + 48;
            if ((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)) {
                sb.append((char) num);
            } else {
                continue;
            }
        } while (sb.length() < size);
        return sb.toString();
    }

    @Override
    public String makeHtml(String type, String code) {
        String html = null;
        switch (type) {
            case "register":
                html = "생략";
                break;
            case "findPw":
                html = "비밀번호 찾기 서비스입니다";
                html+="임시 비밀번호: ";
                html+=code;
                break;
        }
        return html;
    }

    @Override
    public String sendMail(String type, String email) {
        //타입에 따라
        //1. 인증코드 만들기
        //2. html string만들기
        String code = null, html = null, subject = null;
        switch (type) {
            case "register":
                code = makeCode(6);
                html = makeHtml(type, code);
                subject = "제목입력";
                break;
            case "findPw":
                code = makeCode(10);
                html = makeHtml(type, code);
                subject = "비밀번호 찾기 서비스 입니다!";
                break;
        }
        System.out.println("메일 보내기 서비스");
        //공통 - 메일보내기
        MimeMessage mail = mailSender.createMimeMessage();
        try {
            mail.setSubject(subject, "utf-8");
            mail.setText(html, "utf-8", "html");
            mail.addRecipient(RecipientType.TO, new InternetAddress(email));
            mailSender.send(mail);
        } catch (MessagingException e) {
            e.printStackTrace();
            return "error";
        }

        return code;
    }
}