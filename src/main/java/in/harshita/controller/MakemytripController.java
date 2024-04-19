package in.harshita.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.harshita.binding.Passenger;
import in.harshita.binding.Ticket;
import in.harshita.service.Service;

@Controller
public class MakemytripController {
	
	@Autowired
	private Service service;
	
	@PostMapping("/ticket")
	public String ticketBooking(@ModelAttribute("p") Passenger p, Model model) {
		service.bookTicket(p);
		model.addAttribute("msg", "Your Ticket has been booked");
		return "bookTicket";
	}
	
	@GetMapping("/book-ticket")
	public String bookTicket(Model model) {
		model.addAttribute("p", new Passenger());
		return "bookTicket";
	}
		
	@GetMapping("/")
	public String index(Model model) {
		List<Ticket> allTickets = service.getAllTickets();
		model.addAttribute("tickets",allTickets);
		return "index";
	}

}
