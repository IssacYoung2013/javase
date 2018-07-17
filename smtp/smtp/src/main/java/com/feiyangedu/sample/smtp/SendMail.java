package com.feiyangedu.sample.smtp;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	final String smtpHost;
	final String username;
	final String password;
	final boolean debug;

	public SendMail(String smtpHost, String username, String password) {
		this.smtpHost = smtpHost;
		this.username = username;
		this.password = password;
		this.debug = true;
	}

	public static void main(String[] args) throws Exception {
		SendMail sender = new SendMail("smtp.qq.com", "ywy0012006@qq.com", "xywocjsofwdvbibc");
		Session session = sender.createSSLSession();
		Message message = createTextMessage(session, "ywy0012006@qq.com", "yangwenyuan@mistong.com", "Java邮件测试",
				"Hello, 这是一封javamail测试邮件！");
		Transport.send(message);
	}

	Session createSSLSession() {
		Properties props = new Properties();
		props.put("mail.smtp.host", this.smtpHost); // SMTP主机名
		props.put("mail.smtp.port", "465"); // 主机端口号
		props.put("mail.smtp.auth", "true"); // 是否需要用户认证
		// 启动SSL:
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.port", "465");
		Session session = Session.getInstance(props, new Authenticator() {
			// 用户名+口令认证:
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(SendMail.this.username, SendMail.this.password);
			}
		});
		session.setDebug(this.debug); // 显示调试信息
		return session;
	}

	Session createTLSSession() {
		Properties props = new Properties();
		props.put("mail.smtp.host", this.smtpHost); // SMTP主机名
		props.put("mail.smtp.port", "587"); // 主机端口号
		props.put("mail.smtp.auth", "true"); // 是否需要用户认证
		props.put("mail.smtp.starttls.enable", "true"); // 启用TLS加密
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(SendMail.this.username, SendMail.this.password);
			}
		});
		session.setDebug(this.debug); // 显示调试信息
		return session;
	}

	Session createInsecureSession(String host, String username, String password) {
		Properties props = new Properties();
		props.put("mail.smtp.host", this.smtpHost); // SMTP主机名
		props.put("mail.smtp.port", "25"); // 主机端口号
		props.put("mail.smtp.auth", "true"); // 是否需要用户认证
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(SendMail.this.username, SendMail.this.password);
			}
		});
		session.setDebug(this.debug); // 显示调试信息
		return session;
	}

	static Message createTextMessage(Session session, String from, String to, String subject, String body)
			throws MessagingException {
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject(subject, "UTF-8");
		message.setText(body, "UTF-8");
		return message;
	}

}
