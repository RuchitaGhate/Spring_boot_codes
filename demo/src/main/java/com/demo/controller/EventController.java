package com.demo.controller;

import com.demo.model.Event;
import com.demo.model.Participants;
import com.demo.services.EventService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable int id) {
        return eventService.getEventById(id);
    }

    @PostMapping
    public String addEvent(@RequestBody Event event) {
        return eventService.addEvent(event);
    }

    @PutMapping("/{id}")
    public String updateEvent(@PathVariable int id, @RequestBody Event updatedEvent) {
        return eventService.updateEvent(id, updatedEvent);
    }

    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable int id) {
        return eventService.DeleteEvent(id);
    }
    
    @GetMapping("/{eventId}/participants")
    public List<Participants> getParticipants(@PathVariable int eventId) {
        return eventService.getParticipantsByEvent(eventId);
    }
}
