/**
 * 
 */
package com.allianz.Implementations;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import org.apache.log4j.Logger;

import com.allianz.databaseconn.DBConnection;
import com.allianz.interfaces.SendMail;
import com.allianz.send.SendMessage;

/**
 * @author User
 * This class implements the methods of SendMail interface
 *
 */
public class SendMailImpl implements SendMail{
	
	public static Logger logger = Logger.getLogger(SendMailImpl.class);

	@Override
	public void sendbyDatabase() throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileReader("db.properties"));	
		String dbTableName = properties.getProperty("db.tablename");
		
		Connection connection = null;
		String getQuery = "select * from "+dbTableName;
		
		try {
			connection = DBConnection.getConnection();
		}//try
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//catch
		Statement statement = null;
		try {
			statement = connection.createStatement();
		}//try
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//catch
		
		ResultSet resultSet = null;
		try {
			resultSet = statement.executeQuery(getQuery);
		}//try
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//catch
		 
		try {
			while (resultSet.next()) {
			
				//get from database
				
				String from = resultSet.getString(1);
				String to = resultSet.getString(2);
				String subject = resultSet.getString(3);
				String message = resultSet.getString(4);
				
				 //send mails	
				 SendMessage.send(to, from, subject, message);

			}//while ends
			
		}//try
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//catch		
	}//sendbyDatabase method ends

	@Override
	public void sendbyFile(String recipientFilePath, String contentFilePath) throws IOException {
		
		Properties composeFile = new Properties();
		composeFile.load( new FileReader("credentials.properties"));
		String from = composeFile.getProperty("username");
		 
		BufferedReader readRecipients = new BufferedReader(new FileReader(recipientFilePath));
		
		String recipient;
		String content;
		String to = null;
		String subject = null;
		String message = null;
		
		//read recipients
		while((recipient=readRecipients.readLine())!=null)
		{
						
			to = recipient;
			//logger.info(to);
			
			BufferedReader readContents = new BufferedReader(new FileReader(contentFilePath));
					
			//read subject and content from file
			if((content=readContents.readLine())!=null)
			{
									 
				if(content.equalsIgnoreCase("subject"))
				{
					subject=readContents.readLine();
					//logger.info(subject);
					
				}//if

				content=readContents.readLine();
				logger.info(content);
				
				if (content.equalsIgnoreCase("message"))
				{
						message = readContents.readLine();
						//logger.info(message);			
		
				}//if
				
				content=readContents.readLine();
				
			}//inner while
			
			SendMessage.send(to, from, subject, message);
			
		}//outer while
			
	}//sendbyFile method ends

}//class
