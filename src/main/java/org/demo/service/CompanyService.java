package org.demo.service;

import javax.enterprise.context.ApplicationScoped;

import org.demo.model.Company;

@ApplicationScoped
public class CompanyService {

	public Company getCompany(String id) {
    	Company company = new Company();
    	company.setName("Acme " + id);
    	company.setIndustry("Medicine");
        return company;
	}
	
}
