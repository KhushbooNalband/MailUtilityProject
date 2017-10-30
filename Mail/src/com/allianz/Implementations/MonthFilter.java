/**
 * 
 */
package com.allianz.Implementations;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.mail.Message;
import javax.mail.MessagingException;

import com.allianz.classesforSubjectFilter.Files;
import com.allianz.interfaces.MessageFilter;

/**
 * @author User
 * This class implements the method applyFilter of Message Filter Interface
 */
public class MonthFilter implements MessageFilter {

	/**
	 * @param msg
	 * This method filters mails according to the year
	 * @throws MessagingException
	 * @throws IOException
	 * @throws ParseException
	 */
	private String monthNames[] = {"January","February","March","April","May","June","July","August","September","October","November","December"};
	@Override
	public void applyFilter(Message[] messages) throws MessagingException, IOException, ParseException {
		
		for (int i = 0; i < messages.length ; i++) {

			Message message = messages[i];
			Date date = message.getSentDate();
			

			DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			String reportDate = df.format(date);

			final DateFormat d = new SimpleDateFormat("MM/dd/yyyy");
			final Calendar calendar = Calendar.getInstance();

			calendar.setTime(d.parse(reportDate));
		    int monthNumber = calendar.get(Calendar.MONTH);
		    
		    String month = monthNames[monthNumber];
		     
			new File("C:\\Filtered_by_Month").mkdir();
			
			String filename = "C:\\Filtered_by_Month"+"\\"+month;
			
			//create file and write to file
			Files.createDirectory(filename,i,message);
			
		} // for		
	}// applyFilter method ends
	
}//class ends


