package in.harshita.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import in.harshita.binding.Passenger;
import in.harshita.binding.Ticket;

@org.springframework.stereotype.Service
public class Service{
	
	
	public Ticket bookTicket(Passenger p) {
		
		String apiUrl = "http://51.20.73.24:8080/ticket";
		RestTemplate rt = new RestTemplate();
		
		ResponseEntity<Ticket> forEntity = 
				rt.postForEntity(apiUrl, p, Ticket.class);
		Ticket t = forEntity.getBody();
		return t;
	}
	
	public List<Ticket> getAllTickets(){
		String apiUrl = "http://51.20.73.24:8080/tickets";
		RestTemplate rt = new RestTemplate();
		
		ResponseEntity<Ticket[]> forEntity = 
				rt.getForEntity(apiUrl, Ticket[].class);
		Ticket[] t = forEntity.getBody();
		List<Ticket> mylist = Arrays.asList(t);
		return mylist;
		
	}
	
	
	
	

}
