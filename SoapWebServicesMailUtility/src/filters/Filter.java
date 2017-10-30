/**
 * 
 */
package filters;

import javax.mail.Message;
import fetch.FetchMail;
import Implementations.DomainFilter;
import Implementations.MonthFilter;
import Implementations.SubjectFilter;

/**
 * @author User
 * This class sets a filter
 *
 */
public class Filter {
	
	private boolean filters; //enable or disable a filter
	
	DomainFilter domain = new DomainFilter();
	SubjectFilter subject = new SubjectFilter();
	MonthFilter month = new MonthFilter();

	public boolean isFilters() {
		return filters;
	}

	public void setFilters(boolean filters) {
		this.filters = filters;
		
		if(filters == false)
		{
			domain = null;
			subject = null;
			month = null;
		}
		
	}
	
	public void setDomainFilter(boolean domainFilter) throws Exception
	{
	
		if(domainFilter == true && isFilters() == true)
		{
			Message messages[] = FetchMail.fetch();
			domain.applyFilter(messages);
		}
		
		else
			domain = null;			
	}//setDomainFilter method
	
	public void setSubjectFilter(boolean subjectFilter) throws Exception
	{
		
		if(subjectFilter == true && isFilters() == true)
		{
			Message messages[] = FetchMail.fetch();
			subject.applyFilter(messages);
		}
		
		else
			subject = null;			
	}//setSubjectFilter method
	
	public void setMonthFilter(boolean monthFilter) throws Exception
	{
		
		if(monthFilter == true && isFilters() == true)
		{
			Message messages[] = FetchMail.fetch();
			month.applyFilter(messages);
		}
		
		else
			month = null;			
	}//setMonthFilter method
	

}//class
