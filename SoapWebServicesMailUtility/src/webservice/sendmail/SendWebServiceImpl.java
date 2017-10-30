package webservice.sendmail;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.jws.WebMethod;
import javax.jws.WebService;

import endpoints.Endpoint;

@WebService
public class SendWebServiceImpl implements SendWebService {

	Endpoint endpoint = new Endpoint();
	
	@WebMethod
	public void enableEndpoint(boolean value) {
		if(value == true)
		{
			endpoint.setEndpoint(true);
		}

	}

	@WebMethod
	public void enableDb(boolean value) throws FileNotFoundException, IOException {
		if(value == true)
		endpoint.creatDbEndpoint(true);

	}

	@WebMethod
	public void enableFile(boolean value,String recipientFilePath,String contentFilePath) throws IOException {
		if(value == true)
			endpoint.createFileEndpoint(true, recipientFilePath, contentFilePath);

	}

}
