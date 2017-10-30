package com.allianz.test;

import javax.mail.Message;

import com.allainz.fetch.FetchMail;
import com.allianz.Implementations.SendMailImpl;
import com.allianz.Implementations.SubjectFilter;
import com.allianz.Implementations.MonthFilter;

public class Test {

	public static void main(String[] args) throws Exception {
		
		Message messages[] = FetchMail.fetch();
		
		//DomainFilter domain = new DomainFilter();
		//domain.applyFilter(messages);
		
		SubjectFilter subject = new SubjectFilter();
		subject.applyFilter(messages);
		
		//MonthFilter filter = new MonthFilter();
		//filter.applyFilter(messages);
		
		//SendMailImpl impl = new SendMailImpl();
		//impl.sendbyDatabase();
		//impl.sendbyFile("C:\\Users\\User\\Desktop\\Recipients.txt", "C:\\Users\\User\\Desktop\\content.txt");
		
	}//main method ends

}//test class ends
