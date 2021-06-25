package org.demo.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.demo.model.Company;
import org.demo.service.ICompanyService;
import org.jboss.logging.Logger;

@Path("/company") 
public class CompanyResource {

	private static final Logger LOG = Logger.getLogger(CompanyResource.class);
	
    @Inject
	private ICompanyService companyService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Company> list(
    		@QueryParam("page") @DefaultValue("0") int pageIndex,
    		@QueryParam("size") @DefaultValue("20") int pageSize) {
    	LOG.info(String.format("Page=%s Size=%s", pageIndex, pageSize));
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
    
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Company register(Company company) {
    	return companyService.registerCompany(company);
    	//return Response.status(201).entity(account).build(); 
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Company delete(@PathParam("id") String id) {
    	return companyService.deleteCompany(id);
    }

}
