/**
 * 
 */
package fetch;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;

import com.sun.mail.pop3.POP3Store;

/**
 * @author User
 * This class fetches all the mail messages from the INBOX folder using POP3 protocol
 * and java mail api
 *
 */
public class FetchMail {
	
	/**
	 * 
	 * @return Message[]
	 * @throws Exception
	 * This method fetches mail messages and returns the messages
	 */
	public static Message[] fetch() throws Exception {
		
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream in = loader.getResourceAsStream("fetch\\credentials.properties"); 
		
		
		 Properties composeFile = new Properties();
		 composeFile.load(in);
		 
		 //get emailid and password whose mails has to be fetched
	     String username = composeFile.getProperty("username");
	     String password = composeFile.getProperty("password");
		
	     Properties properties = new Properties();
	     properties.put("mail.pop3.host", "pop.gmail.com");
	     properties.put("mail.pop3.port", "995");
	     properties.put("mail.pop3.starttls.enable", "true");
	
	     //get session
	     Session mailSession = Session.getDefaultInstance(properties);
	     POP3Store mailStore = (POP3Store) mailSession.getStore("pop3s"); 
		 mailStore.connect("pop.gmail.com",username, password);
		
		 //get mails from INBOX folder
	    Folder mailFolder = mailStore.getFolder("INBOX");
	    mailFolder.open(Folder.READ_ONLY);
	    
	    //get all messages 
	    Message messages[] = mailFolder.getMessages();
	    
	    return messages;

	}//fetch method

/**
 * 
 * @param Message msg
 * @return nothing
 * @throws MessagingException
 * @throws IOException
 * 
 * This method gets contents of the mail
 */
	public static String getText(Part p) throws MessagingException, IOException {


	    if (p.isMimeType("multipart/alternative")) 
	    {
	        // prefer html text over plain text
	        Multipart mp = (Multipart)p.getContent();
	        String text = null;
	        for (int i = 0; i < mp.getCount(); i++) {
	            Part bp = mp.getBodyPart(i);
	            if (bp.isMimeType("text/plain")) {
	                if (text == null)
	                    text = getText(bp);
	                continue;
	            } //if
	            else if (bp.isMimeType("text/html")) {
	                String s = getText(bp);
	                if (s != null)
	                    return s;
	            }//else if
	            else {
	                return getText(bp);
	            }//else
	        }//for
	        
	        return text;
	    }//if
	    else if (p.isMimeType("multipart/*")) {
	        Multipart mp = (Multipart)p.getContent();
	        for (int i = 0; i < mp.getCount(); i++) 
	        {
	            String s = getText(mp.getBodyPart(i));
	            if (s != null)
	                return s;
	        }//for
	    }//else if
	    else
	    { return p.getContent().toString();} //else 
	    return null; 
	} //getText method ends
	
	

}//class ends
