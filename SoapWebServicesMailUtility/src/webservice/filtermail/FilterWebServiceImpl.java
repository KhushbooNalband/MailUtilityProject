package webservice.filtermail;

import javax.jws.WebMethod;
import javax.jws.WebService;

import endpoints.Endpoint;
import filters.Filter;

@WebService
public class FilterWebServiceImpl implements FilterWebService {

	Filter filter = new Filter();
	
	@WebMethod
	public void enableFilter(boolean value) {
		if(value ==  true)
		{
			filter.setFilters(true);
		}
		
	}

	@WebMethod
	public void enableDomainFilter(boolean value) throws Exception {
		if(value ==  true)
		{
			filter.setDomainFilter(true);
		}
	}

	@WebMethod
	public void enableSubjectFilter(boolean value) throws Exception {
		if(value ==  true)
		{
			filter.setSubjectFilter(true);
		}
	}

	@WebMethod
	public void enableMonthFilter(boolean value) throws Exception {
		if(value ==  true)
		{
			filter.setMonthFilter(true);
		}
	}

}
