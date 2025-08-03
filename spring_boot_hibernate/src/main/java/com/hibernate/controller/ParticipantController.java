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

import com.hibernate.model.Participant;
import com.hibernate.service.ParticipantService;

@RestController
@RequestMapping("/participants")
public class ParticipantController {
    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping
    public List<Participant> getAllParticipants() {
        return participantService.getAllParticipants();
    }

    @GetMapping("/{id}")
    public Participant getParticipantById(@PathVariable int id) {
        return participantService.getParticipantById(id);
    }

    @PostMapping("/{eventId}")
    public Participant addParticipant(@PathVariable int eventId, @RequestBody Participant participant) {
        return participantService.addParticipantToEvent(eventId, participant);
    }

    @PutMapping("/{id}")
    public Participant updateParticipant(@PathVariable int id, @RequestBody Participant participant) {
        return participantService.updateParticipant(id, participant);
    }

    @DeleteMapping("/{id}")
    public String deleteParticipant(@PathVariable int id) {
        return participantService.deleteParticipant(id);
    }
}