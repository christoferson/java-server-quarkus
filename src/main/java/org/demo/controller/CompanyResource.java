package org.demo.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.demo.model.Company;

@Path("/company")
public class CompanyResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Company company() {
    	Company company = new Company();
    	company.setName("Acme");
    	company.setIndustry("Finance");
        return company;
    }
  
}
