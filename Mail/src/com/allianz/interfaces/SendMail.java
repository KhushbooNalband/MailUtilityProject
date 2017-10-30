/**
 * 
 */
package com.allianz.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author User
 *
 */
public interface SendMail {
	
	public void sendbyDatabase() throws FileNotFoundException, IOException;
	public void sendbyFile(String recipientFilePath,String contentFilePath) throws FileNotFoundException, IOException;

}
