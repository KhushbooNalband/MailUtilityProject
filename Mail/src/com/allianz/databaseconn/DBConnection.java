package com.allianz.databaseconn;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.allianz.swt.MainWindow;

/**This class establishes the connection with the Database
 * @author User
 */
public class DBConnection {
	
		private static Connection connection=null;
		public static final Logger logger = Logger.getLogger(DBConnection.class);

	public static Connection getConnection() throws IOException 
	
	{
		try
		{
			if(connection!=null)
			{
				if(!connection.isClosed())
				{
					return connection;
				}
			}
			
			else
				logger.info("Database connected");
		}//try
		
		catch(Exception e)
		{
			e.printStackTrace();
		}//catch
	
		Properties properties = new Properties();
		properties.load(new FileReader("db.properties"));
		
		String dbDriver = properties.getProperty("db.driver");
		String dbPort = properties.getProperty("db.port");
		String dbHost = properties.getProperty("db.host");
		String dbName = properties.getProperty("db.dbname");
		String dbUser = properties.getProperty("db.user");
		String dbPassword = properties.getProperty("db.password");
		String dbProtocol = properties.getProperty("db.protocol");
		
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(dbProtocol+":"+"//"+dbHost+":"+dbPort+"/"+dbName,dbUser,dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
		
	}//getConnection method ends
	
}//class
