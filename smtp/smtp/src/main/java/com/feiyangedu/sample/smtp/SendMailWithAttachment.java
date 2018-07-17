package com.feiyangedu.sample.smtp;

import java.io.IOException;
import java.io.InputStream;

import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

public class SendMailWithAttachment {

	public static void main(String[] args) throws Exception {
		SendMail sender = new SendMail("smtp.qq.com", "ywy0012006@qq.com", "xywocjsofwdvbibc");
		Session session = sender.createSSLSession();
		try (InputStream input = SendMailWithAttachment.class.getResourceAsStream("/javamail.jpg")) {
			Message message = createMessageWithAttachment(session, "ywy0012006@qq.com", "yangwenyuan@mistong.com",
					"Hello Java邮件带附件测试", "<h1>Hello</h1><p>这是一封带附件的<u>javamail</u>测试邮件！</p>", "javamail.jpg", input);
			Transport.send(message);
		}
	}

	static Message createMessageWithAttachment(Session session, String from, String to, String subject, String body,
			String fileName, InputStream input) throws MessagingException, IOException {
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject(subject, "UTF-8");
		Multipart multipart = new MimeMultipart();
		// 添加text:
		BodyPart textpart = new MimeBodyPart();
		textpart.setContent(body, "text/html;charset=utf-8");
		multipart.addBodyPart(textpart);
		// 添加image:
		BodyPart imagepart = new MimeBodyPart();
		imagepart.setFileName(fileName);
		imagepart.setDataHandler(new DataHandler(new ByteArrayDataSource(input, "application/octet-stream")));
		multipart.addBodyPart(imagepart);
		message.setContent(multipart);
		return message;
	}

}
