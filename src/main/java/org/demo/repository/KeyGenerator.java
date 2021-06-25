package org.demo.repository;

import java.util.concurrent.atomic.AtomicInteger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class KeyGenerator {

	private AtomicInteger companyKeySequence = new AtomicInteger(0);
	
	public String generateCompanyKey() {
		return String.valueOf(companyKeySequence.incrementAndGet());
	}
	
}
