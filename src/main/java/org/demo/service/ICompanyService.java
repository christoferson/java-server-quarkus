package org.demo.service;

import java.util.List;

import org.demo.model.Company;

public interface ICompanyService {

	List<Company> listCompany();
	
	Company getCompany(String id);
	
	Company editCompany(String id, Company data);
	
	Company deleteCompany(String id);
	
}
