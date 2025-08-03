package com.hibernate.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.model.Event;
import com.hibernate.service.EventService;

@RestController
@RequestMapping("/events")
public class EventController {
	
	private EventService eventService;

	public EventController(EventService eventService) {
		super();
		this.eventService = eventService;
	}
	
	@GetMapping("id")
	public List<Event> getAllEvent(){
		return eventService.getAllEvents();
		
	}
	
	@GetMapping("/id")
	public Event getById(@PathVariable int id) {
		return eventService.getEventById(id);
		
	}
	
	@PostMapping
	public Event addEvents(@RequestBody Event event) {
		return eventService.addEvent(event);
		
	}
	
	@PutMapping("/{id}")
	public Event updateEvent(@RequestBody Event event, @PathVariable int id) {
		return eventService.updateEvent(id, event);
	}
	
	@DeleteMapping("//id")
	public String deleteEvent(@PathVariable int id) {
		return eventService.deleteEvent(id);
	}

}
