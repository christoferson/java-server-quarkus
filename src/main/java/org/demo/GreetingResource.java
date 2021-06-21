package org.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello";
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String helloHtml() {
        return "<html><body><font style='color:blue;font-size:24;'>Hello HTML</font></body></html>";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String helloXml() {
      return String.format("<?xml version=\"1.0\"?><hello>Hello XML</hello>");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String helloJson() {
      return String.format("{message:'Hello JSON'}");
    }

}