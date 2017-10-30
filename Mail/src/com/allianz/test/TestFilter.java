package com.allianz.test;

import com.allianz.filters.Filter;

public class TestFilter {

	public static void main(String[] args) throws Exception {
		
		Filter f = new Filter();
		f.setFilters(true);
		
		//f.setDomainFilter(true);
		
		//f.setMonthFilter(true);
		f.setSubjectFilter(true);

	}

}
