package com.allianz.interfaces;

import java.io.IOException;
import java.text.ParseException;

import javax.mail.Message;
import javax.mail.MessagingException;

/**
 * 
 * @author User
 * 
 * 
 *
 */
public interface MessageFilter {
	
	/**
	 * 
	 * @param msg Mails fetched 
	 * This method applies filter to the mail message 
	 * return nothing
	 * @throws MessagingException 
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public void applyFilter(Message msg[]) throws MessagingException, IOException, ParseException;

}
