package org.demo.model;

public class Company {

	private String name;
	
	private String industry = "Finance";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	@Override
	public String toString() {
		return "Company [name=" + name + "]";
	}

}
