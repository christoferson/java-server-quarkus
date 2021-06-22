package org.demo.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import org.demo.ApplicationException;
import org.demo.model.Company;

@ApplicationScoped
public class CompanyService implements ICompanyService {

	private Map<String, Company> entries = new HashMap<>();
	
	@PostConstruct
	private void init() {
		
		for (int i = 1; i < 10; i++) {
			String id = String.valueOf(i);
			Company company = new Company();
			company.setId(id);
	    	company.setName("Acme " + id);
	    	company.setIndustry("Medicine");
	    	entries.put(id, company);
		}	
		
	}
	
	@Override
	public Company getCompany(String id) {
		if (!entries.containsKey(id)) {
			throw new ApplicationException();
		}
		return entries.get(id);
	}
	
}
