package org.demo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.demo.model.Company;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
public class CompanyResourceTest {

    @Test
    public void testRegisterCompany() {
    	
    	Company request = new Company();
    	request.setName("Acme Inc.");
    	request.setIndustry("Finance");
    	
    	Company company =
        given()
          .contentType(ContentType.JSON)
          .body(request)
          .when().accept(ContentType.JSON).post("/company")
          .then()
             .statusCode(200)
             .extract()
             .as(Company.class);
    	
    	assertThat(company, notNullValue()); 
    	assertThat(company.getId(), notNullValue()); 
    	assertThat(company.getName(), equalTo(request.getName()));
    	assertThat(company.getIndustry(), equalTo(request.getIndustry()));
    	 
    }

 
}