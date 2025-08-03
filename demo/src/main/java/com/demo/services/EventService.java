package com.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.model.Event;
import com.demo.model.Participants;

@Service
public class EventService {
	
	private final List<Event> eventList = new ArrayList<>();
	
	public List<Event> getAllEvents(){
		return eventList;
		
	}
	
	public Event getEventById(int id) {
		return eventList.stream().filter(e -> e.getId()==id).findFirst().orElse(null);
	}
	
	public String addEvent(Event event) {
		eventList.add(event);
		return "event is added sucessfully.....";
	}
	
	public String updateEvent(int id, Event updatedevent) {
		for(int i =0; i<eventList.size();i++) {
			if(eventList.get(i).getId()==id) {
				updatedevent.setId(id);
				eventList.set(i, updatedevent);
				return "event is updated sucessfully....";
			}
		}
		return "event not found....";
	}
	
	public String DeleteEvent(int id) {
		boolean removed = eventList.removeIf(e ->e.getId()==id);
		return removed ? "event is deleted sucessfully...":"event not found";
	}
	 public List<Participants> getParticipantsByEvent(int eventId) {
	        Event event = getEventById(eventId);
	        return (event != null) ? event.getParticipants() : null;
	    }

}
