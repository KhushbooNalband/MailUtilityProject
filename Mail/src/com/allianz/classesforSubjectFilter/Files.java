/**
 * 
 */
package com.allianz.classesforSubjectFilter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.mail.Message;
import javax.mail.MessagingException;

import com.allainz.fetch.FetchMail;

/**
 * @author User
 * This class creates directories, text files and writes mail message to the file
 *
 */
public class Files {
	
	/**
	 * 
	 * @param filename
	 * @param messageNumber
	 * @param msg
	 * @throws MessagingException
	 * @throws IOException
	 * This method create a directory(if directory does not exists) and then create a text file in it.
	 *  Then writes message to the new created file 
	 */

	public static void createDirectory(String filename,int messageNumber, Message msg) throws MessagingException, IOException
	{
		File f = new File(filename);
		
		//if directory exists write mail message to it
		if(f.exists())
		{ 
			String path = filename+"//";
			String textFileName = Integer.toString(messageNumber);	
			String newFile = textFileName+".txt";	
			String totalpath = path+newFile;
			
			//creating file
			Files.createFile(totalpath);
			
			//writing to file
			Files.writetoFile(totalpath, msg); 
		}//if
		
		//if directory does not exists create a new directory
		else
		{
			new File(filename).mkdir();	
		}//else	

	}
	
	
	/**
	 * 
	 * @param path
	 * @throws IOException
	 * This method creates a new file with the path specified
	 */
	
	public static void createFile(String path) throws IOException
	{
		File file = new File(path);
		file.createNewFile();
	}//create File method
	
	/**
	 * 
	 * @param path
	 * @param message
	 * @throws MessagingException
	 * @throws IOException
	 * This method write a message to file with the path specified
	 */
	public static void writetoFile(String path,Message message) throws MessagingException, IOException
	
	{
		FileWriter fw = new FileWriter(new File(path));
		BufferedWriter bw = new BufferedWriter(fw);
		
		//get subject , content , from 		
		String subject = message.getSubject();
		String from = message.getFrom()[0].toString();
		String content = FetchMail.getText(message);
		
		//writing to the file
		bw.write(subject);
		bw.write("\n");		
		bw.write(from);
		bw.write("\n");		
		bw.write(content);
		bw.write("\n");		
		bw.close();
		fw.close();
		
	}//write to file
	
}//class
