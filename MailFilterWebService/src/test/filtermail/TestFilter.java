package test.filtermail;

import webservice.filtermail.Exception_Exception;
import webservice.filtermail.FilterWebServiceImpl;
import webservice.filtermail.FilterWebServiceImplService;

public class TestFilter {

	public static void main(String[] args) throws Exception_Exception {
		
		FilterWebServiceImplService impl = new FilterWebServiceImplService();
		FilterWebServiceImpl service = impl.getFilterWebServiceImplPort();
		
		service.enableFilter(true);
		service.enableDomainFilter(true);
	}

}
