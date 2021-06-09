package com.mateus.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mateus.hrpayroll.entities.Payment;
import com.mateus.hrpayroll.entities.Worker;

@Service
public class PaymentService {
	
	@Value("${hr-worker.host}")
	public String workerHost;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Payment getPayment(long workerId, int days) {
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", "" + workerId);
		
		String url = workerHost + "/workers";
		
		Worker worker = restTemplate.getForObject(url + "/{id}", Worker.class, uriVariables);
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}

}
