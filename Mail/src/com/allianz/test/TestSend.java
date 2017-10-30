package com.allianz.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.allianz.endpoints.Endpoint;

public class TestSend {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		Endpoint end = new Endpoint();
		end.setEndpoint(true);
		
		//end.creatDbEndpoint(true);
		
		//end.createFileEndpoint(true,"C:\\Users\\User\\Desktop\\Recipients.txt", "C:\\Users\\User\\Desktop\\content.txt");
		
		//end.setEndpoint(false);
	}

}
