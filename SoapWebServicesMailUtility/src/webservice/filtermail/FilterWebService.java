/**
 * 
 */
package webservice.filtermail;

/**
 * @author User
 *
 */
public interface FilterWebService {
	
	public void enableFilter(boolean value);
	public void enableDomainFilter(boolean value) throws Exception;
	public void enableSubjectFilter(boolean value) throws Exception;
	public void enableMonthFilter(boolean value) throws Exception;
}
