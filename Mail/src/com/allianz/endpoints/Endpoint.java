/**
 * 
 */
package com.allianz.endpoints;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.allianz.Implementations.SendMailImpl;

/**
 * @author User
 * This class enables and disables an endpoint 
 *
 */
public class Endpoint {
	
	private boolean endpoint; //enable or disable a endpoint
	SendMailImpl impl; //object of class SendMailimpl

	public boolean isEndpoint() {
		return endpoint;
	}

	/**
	 * 
	 * @param endpoint
	 * sets an end point
	 */
	public void setEndpoint(boolean endpoint) {
		
		this.endpoint = endpoint;
		if(endpoint == true)
		{
			impl = new SendMailImpl();
		}
		else
		{
			impl = null;
		}
	}//setEndpoint method
	
	/**
	 * 
	 * @param dbendpoint
	 * @throws FileNotFoundException
	 * @throws IOException
	 * This method sets database as an end point
	 */
	public void creatDbEndpoint(boolean dbendpoint) throws FileNotFoundException, IOException
	{
		if(isEndpoint() == true && dbendpoint == true)
			impl.sendbyDatabase();
	}//createDbEndpoint method
	
	/**
	 * 
	 * @param fileEndpoint 
	 * @param recipientFilePath
	 * @param contentFilePath
	 * @throws IOException
	 * This method sets file as an end point
	 */
	public void createFileEndpoint(boolean fileEndpoint, String recipientFilePath, String contentFilePath ) throws IOException
	{
		SendMailImpl impl = new SendMailImpl();
		
		if(isEndpoint() == true && fileEndpoint == true)
			impl.sendbyFile(recipientFilePath, contentFilePath);
	}//createFileEndpoint method
		

}//class
