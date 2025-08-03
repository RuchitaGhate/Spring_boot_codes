package com.hibernate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hibernate.model.Event;
import com.hibernate.repository.EventRepository;

@Service
public class EventService {
	
	private EventRepository eventRepo;

	public EventService(EventRepository eventRepo) {
		super();
		this.eventRepo = eventRepo;
	}
	
	public List<Event> getAllEvents(){
		return eventRepo.findAll();
	}
	
	public Event getEventById(int id) {
		return eventRepo.findById(id).orElse(null);
		
	}
	
	public Event updateEvent(int id, Event updatedEvent) {
		Event existing = getEventById(id);
		if(existing != null) {
		 existing.setName(updatedEvent.getName());
		 existing.setEmail(updatedEvent.getEmail());
		 existing.setType(updatedEvent.getType());
		 return eventRepo.save(existing);	
		}
		return null;
		 }
	
	public Event addEvent(Event event) {
		return eventRepo.save(event);
 }
	
	public String deleteEvent(int id) {
		if(eventRepo.existsById(id)) {
			eventRepo.deleteById(id);
		}
		return "id not found";
		
	}
	

}

