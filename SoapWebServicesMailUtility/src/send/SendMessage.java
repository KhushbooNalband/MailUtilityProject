/**
 * 
 */
package send;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author User
 *
 */
public class SendMessage
{
	public static void send(String to ,String from ,String subject,String message) throws IOException
	{
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream in = loader.getResourceAsStream("send\\credentials.properties"); 
		
		
		 Properties properties = new Properties();
		 properties.load(in);

		 try {
			properties.load(in);
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		 
	     String username = properties.getProperty("username");
	     String password = properties.getProperty("password");
	     String host = properties.getProperty("host");
	     String port = properties.getProperty("port");
	      
		
	      Properties props = System.getProperties(); 
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", port);
	      

	      // Get the Session object.
	      
	      Session mailSession = Session.getDefaultInstance(props, null);
	      mailSession.setDebug(true);

	      //set the message
	      Message mailMessage = new MimeMessage(mailSession);
	      try {
			mailMessage.setFrom(new InternetAddress(from));
		} catch (AddressException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      try {
			mailMessage.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
		} catch (AddressException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      try {
			mailMessage.setContent(message,"text/html");
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      try {
			mailMessage.setSubject(subject);
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      
	      // Send message
	      Transport transport = null;
	      try {
			transport = mailSession.getTransport("smtp");
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      try {
			transport.connect(host, username, password);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      try {
			transport.sendMessage(mailMessage,mailMessage.getAllRecipients());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
