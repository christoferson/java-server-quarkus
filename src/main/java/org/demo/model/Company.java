package org.demo.model;

public class Company {
	
	private String id;

	private String name;
	
	private String industry = "Finance";
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
		return "Company [id=" + id + ", name=" + name + ", industry=" + industry + "]";
	}

}
