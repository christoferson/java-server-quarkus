package org.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.demo.ApplicationException;
import org.demo.model.Company;
import org.demo.repository.KeyGenerator;

@ApplicationScoped
public class CompanyService implements ICompanyService {
	
	@Inject
	private KeyGenerator keyGenerator;
	
	private Map<String, Company> entries = new ConcurrentHashMap<>();
	
	@PostConstruct
	void init() {
		
		for (int i = 1; i < 10; i++) {
			String id = String.valueOf(keyGenerator.generateCompanyKey());
			Company company = new Company();
			company.setId(id);
	    	company.setName("Acme " + id);
	    	company.setIndustry("Medicine");
	    	entries.put(id, company);
		}	
		
	}

	@Override
	public List<Company> listCompany() {
		return new ArrayList<>(entries.values());
	}
	
	@Override
	public Company getCompany(String id) {
		if (!entries.containsKey(id)) {
			throw new ApplicationException();
		}
		return entries.get(id);
	}
	
	@Override
	public Company editCompany(String id, Company data) {
		if (!entries.containsKey(id)) {
			throw new ApplicationException();
		}
		Company company = entries.get(id);
		company.setName(data.getName());
		company.setIndustry(data.getIndustry());
		return company;
	}
	
	@Override
	public Company registerCompany(Company data) {
		if (data.getId() != null) {
			throw new ApplicationException();
		}
		String id = keyGenerator.generateCompanyKey();
		Company company = new Company();
		company.setId(id);
		company.setName(data.getName());
		company.setIndustry(data.getIndustry());
		entries.put(id, company);
		return company;
	}
	
	@Override
	public Company deleteCompany(String id) {
		if (!entries.containsKey(id)) {
			throw new ApplicationException();
		}
		Company company = entries.remove(id);
		if (company == null) {
			throw new ApplicationException();
		}
		return company;
	}

}
