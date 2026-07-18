package demo;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailSender {
	public static void main(String[] args) {
		final String senderEmail = "testddb34@gmail.com";
		final String appPassword = "efjsckodmvqgosnf";
		final String receiverEmail = "zaenalfahmi34@gmail.com";
		
		// SMTP Serve Properties
		Properties properties = new Properties();
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.starttls.enable","true");
		properties.put("mail.smtp.port", "587");
		
		//Create a session with authentication
		Session session = Session.getInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, appPassword);
			}
		});
		session.setDebug(true);
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(senderEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiverEmail));
			message.setSubject("Attack WAR COC");
			message.setText("Hallo\ndon't forget to Attack War Clash Of Clans");
		
			// Send Email
			Transport.send(message);
			System.out.println("Email Sent Successfully ***");
		} catch (Exception e) {
			   e.printStackTrace();
		}
		
		
	}
	
	
	
	
}
