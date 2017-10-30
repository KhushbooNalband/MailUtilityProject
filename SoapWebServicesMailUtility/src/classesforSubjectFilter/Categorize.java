/**
 * 
 */
package classesforSubjectFilter;

import javax.mail.Message;
import javax.mail.MessagingException;
import org.apache.log4j.Logger;

/**
 * @author User
 * This class analyzes the mail message subject and returns 
 * the category of mail message based on the keywords 
 *
 */
public class Categorize {
	
	public static Logger logger = Logger.getLogger(Categorize.class);
	
	private String type; //Type of mail message
	
	private String[] wordsforFinance = {"credit","debit","debt","account","cash","amount","investment","bank","insurance","transaction","funds","interest","payment"}; //finance related words
	private String[] wordsforSocial = {"connection","invitation","friend request","profile","group"}; //social network related words
	private String[] wordsforEmployment = {"job","interview","career","opportunity","vacancy","resume","cv","call letter","recruitement","campus","placement"}; //employment related words
	private String[] wordsforShopping = {"deal","order","delivery","track","shipment","dispatch"}; //shopping related words
	private String[] wordsforTravel = {"ticket","booking","ride","travel","trip","reservation"}; //travel related words
	private String[] wordsforGeneral = {"dear","hello","hey","verfiy"}; //general and personal mail related words

	/**
	 * 
	 * @param message
	 * @return string : the type of mail message
	 * @throws MessagingException
	 * This method categorizes message based on subject and returns the type
	 */
	
	public String getMessageType(Message message) throws MessagingException
	{
		String subject = message.getSubject().toLowerCase();
		
		if(subject!=null)
		{
			for (int i = 0; i < wordsforFinance.length;i++) {
				if(subject.contains(wordsforFinance[i]))
				
				{
					type="Finance";
					return type;
				}//if
			}//for
			
			for (int i = 0; i < wordsforSocial.length; i++) {
				if(subject.contains(wordsforSocial[i]))
				{
					type="Social";
					return type;
				}//if
			}//for
			
			for (int i = 0; i < wordsforEmployment.length; i++) {
				if(subject.contains(wordsforEmployment[i]))
				{
					type="Employment";
					return type;
				}//if
			}//for
			
			for (int i = 0; i < wordsforShopping.length; i++) {
				if(subject.contains(wordsforShopping[i]))
				{
					type="Shopping";
					return type;
				}//if
			}//for
			
			for (int i = 0; i < wordsforTravel.length; i++) {
				if(subject.contains(wordsforTravel[i]))
				{
					type="Travel";
					return type;
				}//if
			}//for
			
			for (int i = 0; i < wordsforGeneral.length; i++) {
				if(subject.contains(wordsforGeneral[i]))
				{
					type="General";
					return type;
				}//if
			}//for
			
		}// outer if 
			
		else
		{
			type="Others";		
			return type;
		}//else
		
		return "Others";			
	}//getMessageType method ends

}//class
