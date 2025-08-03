package com.hibernate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hibernate.model.Participant;
import com.hibernate.model.Event;
import com.hibernate.repository.EventRepository;
import com.hibernate.repository.ParticipantRepository;

@Service
public class ParticipantService {
	private ParticipantRepository participantRepo;
	private final EventRepository eventRepo;

    public ParticipantService(ParticipantRepository participantRepo, EventRepository eventRepo) {
        this.participantRepo = participantRepo;
        this.eventRepo = eventRepo;
    }
	
	public List<Participant> getAllParticipants(){
		return participantRepo.findAll();
		
	}
	
	public Participant getParticipantById(int id) {
		return participantRepo.findById(id).orElse(null);
		
	}
	
	public Participant addParticipantToEvent(int eventId, Participant participant) {
		Event event = eventRepo.findById(eventId).orElse(null);
		if(event !=null) {
			participant.setEvent(event);		
			return participantRepo.save(participant);
			}
		return null;	
	}
	public Participant updateParticipant(int id, Participant updatedParticipant) {
        Participant existing = getParticipantById(id);
        if (existing != null) {
            existing.setName(updatedParticipant.getName());
            existing.setEmail(updatedParticipant.getEmail());
            return participantRepo.save(existing);
        }
        return null;
    }
	
	public String deleteParticipant(int id) {
		if(participantRepo.existsById(id)) {
			participantRepo.deleteById(id);
			return "participant deleted";
		}
		return null;
	} 
	

}
