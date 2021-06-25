package org.demo;

import javax.validation.constraints.NotBlank;

import io.quarkus.arc.config.ConfigProperties;

@ConfigProperties
public class ApplicationConfig {

	@NotBlank
	private String version;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "ApplicationConfig [version=" + version + "]";
	}

}
