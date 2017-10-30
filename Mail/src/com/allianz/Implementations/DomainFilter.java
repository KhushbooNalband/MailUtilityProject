/**
 * 
 */
package com.allianz.Implementations;

import java.io.File;
import java.io.IOException;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;

import org.apache.log4j.Logger;

import com.allianz.classesforSubjectFilter.Files;
import com.allianz.interfaces.MessageFilter;

/**
 * @author User
 * This class implements the method applyFilter of Message Filter Interface
 */
public class DomainFilter implements MessageFilter {
	
	public static Logger logger = Logger.getLogger(DomainFilter.class);
	/**
	 * @param msg Mails fetched 
	 * This method filters mails according to the subject
	 * return nothing 
	 * @throws MessagingException 
	 * @throws IOException 
	 */
	
	@Override
	public void applyFilter(Message messages[]) throws MessagingException, IOException {
		
		for (int i = 0; i < messages.length; i++) 
		{
			Message message = messages[i];	
			Address[] froms = message.getFrom();
			String email = froms == null?null:((InternetAddress)froms[0]).getAddress();	
			int  temp = email.indexOf("@")+1;
			String domain = email.substring(temp);
			
			new File("C:\\Filtered_by_Domain").mkdir();
			
			String filename = "C:\\Filtered_by_Domain"+"\\"+domain;

			//create file and write to file
			Files.createDirectory(filename,i,message);
		}//for
	
	}//applyFilter method ends

}//class ends

