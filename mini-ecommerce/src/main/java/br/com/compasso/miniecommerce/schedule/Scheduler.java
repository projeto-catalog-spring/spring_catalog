package br.com.compasso.miniecommerce.schedule;

import org.json.simple.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import br.com.compasso.miniecommerce.models.dto.ERPDto;

@Component
public class Scheduler {

	@Scheduled(cron = "0/5 * * * * *")
	public void jobSchedule() {
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/ERP", String.class);
		
//		JSONObject jsonObj = new Gson().fromJson(response.getBody(), JSONObject.class);
//		
//		ModelMapper model = new ModelMapper();
//		ERPDto erp = model.map(jsonObj, ERPDto.class);
		
		System.out.println("funcionou..." + response.getBody());
	}

}
