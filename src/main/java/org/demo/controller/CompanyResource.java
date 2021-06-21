package org.demo.controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.demo.model.Company;
import org.demo.service.CompanyService;

@Path("/company")
public class CompanyResource {

	@Inject
	private CompanyService companyService;
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Company company() {
    	Company company = new Company();
    	company.setName("Acme");
    	company.setIndustry("Finance");
        return company;
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Company get(@PathParam("id") String id) {
    	return companyService.getCompany(id);
    }
  
}
