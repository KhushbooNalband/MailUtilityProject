package Implementations;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.mail.Message;
import javax.mail.MessagingException;

import org.apache.log4j.Logger;

import classesforSubjectFilter.Categorize;
import classesforSubjectFilter.Files;
import interfaces.MessageFilter;

/**
 * 
 * @author User
 * This class implements the method applyFilter of interface MessageFilter 
 */
public class SubjectFilter implements MessageFilter {

	public static Logger logger = Logger.getLogger(SubjectFilter.class);
	Set<String> types = new HashSet<>();

	/**
	 * @param msg Mails fetched 
	 * This method filters mails according to the subject
	 * return nothing 
	 */
	
	@Override
	public void applyFilter(Message[] messages) throws MessagingException, IOException {
		
		for (int i = 0; i < messages.length; i++) {
			Message message = messages[i];
			
			//get the type or category of message
			Categorize categorize = new Categorize();		
			String type = categorize.getMessageType(message);
	
			new File("C:\\Filtered_by_Subject").mkdir();
			String filename = "C:\\Filtered_by_Subject"+"\\"+type;
			
			//create file and write to file
			Files.createDirectory(filename,i,message);
		}//for				
	}//applyFilter method ends

}//class
