package tn.esprit.spring.Utility;

import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class Mail {

	public static void sendMail(String recepient, String filePdf) throws Exception{
		System.out.println("Preparing to send email");
		
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		String myAccountEmail = "sediridhia@gmail.com";
		String password = "dhia;789321456";
		
		Session session = Session.getInstance(properties, new Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {			
				return new PasswordAuthentication(myAccountEmail, password);
			}
		});
		 
		Message message = prepareMessage(session, myAccountEmail, recepient, filePdf);			
		Transport.send(message);
		System.out.println("Message sent successfully");	
	}

	
	private static Message prepareMessage(Session session, String myAccountEmail, String recepient, String filePdf) {
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("My first Email from JAVA APP");
			//message.setText("Hey there, \n Look my email !");
			
			Multipart emailContent = new MimeMultipart();
			
			//Text Body Part
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText("My multipart text");
			
			//Attachement Body Part
			MimeBodyPart pdfAttachement = new MimeBodyPart();
			pdfAttachement.attachFile(filePdf); 
			
			//Attach Body Parts
			emailContent.addBodyPart(textBodyPart);
			emailContent.addBodyPart(pdfAttachement);
			
			//Attach multipart to message
			message.setContent(emailContent);
			
			return message;
			
		} catch (Exception e) {
			Logger.getLogger(Mail.class.getName()).log(java.util.logging.Level.SEVERE, null, e);;
		}
		return null;
	}
}
