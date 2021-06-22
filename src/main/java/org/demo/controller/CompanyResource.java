package org.demo.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.demo.model.Company;
import org.demo.service.ICompanyService;

@Path("/company")
public class CompanyResource {

	@Inject
	private ICompanyService companyService;
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Company> list() {
    	return companyService.listCompany();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Company get(@PathParam("id") String id) {
    	return companyService.getCompany(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Company edit(@PathParam("id") String id, Company company) {
    	return companyService.editCompany(id, company);
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Company delete(@PathParam("id") String id) {
    	return companyService.deleteCompany(id);
    }

}
