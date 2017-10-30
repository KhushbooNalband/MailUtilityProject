package webservice.sendmail;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.jws.WebService;

public interface SendWebService
{
	public void enableEndpoint(boolean value);
	public void enableDb(boolean value) throws FileNotFoundException, IOException;
	public void enableFile(boolean value,String recipientFilePath,String contentFilePath) throws IOException;
}
