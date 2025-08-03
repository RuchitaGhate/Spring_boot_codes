package com.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Participants;
import com.demo.services.ParticipantsServices;



@RestController
@RequestMapping("/participants")
public class ParticipantController {
	
	private ParticipantsServices participantService;
	
	@GetMapping("/id")
	public List<Participants> getAllParticipants(){
		return participantService.getAllParticipants();
		
	}
	
	@PostMapping("/{id}")
	public String addParticipants(@RequestBody Participants participant) {
		return participantService.addparticipants(participant);
	}
	
	@PutMapping("id/{id}")
	public String updateParticipants(@RequestBody Participants updateParticipant, @PathVariable int id) {
		return participantService.updateParticipants(id, updateParticipant);
	}
	
	@GetMapping("/id/id")
	public Participants getParticipantById(@PathVariable int id) {
		return participantService.getAllParticipantsById(id);
	}
	
	@DeleteMapping("id")
	public String deletePartipants(@PathVariable int id) {
		return participantService.deleteParticipants(id);
	}

}
