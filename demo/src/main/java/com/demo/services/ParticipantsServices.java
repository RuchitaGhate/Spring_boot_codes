package com.demo.services;

import java.util.ArrayList;
import java.util.List;

import com.demo.model.Participants;

public class ParticipantsServices {
	
	private List<Participants> participantList = new ArrayList<>();
	
	public List<Participants> getAllParticipants(){
		return participantList;
	}
	
	public Participants getAllParticipantsById(int id) {
		return participantList.stream().filter(e -> e.getId()==id).findFirst().orElse(null);
	}
	
	public String updateParticipants(int id, Participants updateParticipant) {
		for(int i = 0; i< participantList.size();i++) {
			if(participantList.get(i).getId()==id) {
				updateParticipant.setId(id);
				participantList.set(i, updateParticipant);
				
				return "participants are updated";
			}
		}
		return "participant not found";
	}
	
	public String addparticipants(Participants participant) {
		participantList.add(participant);
		return "participant is added";
	}
	
	public String deleteParticipants(int id) {
		boolean remove = participantList.removeIf(e ->e.getId()==id);
		return remove? "participant deleted":"participant not found";
	}

}
