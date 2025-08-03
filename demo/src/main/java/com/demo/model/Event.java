package com.demo.model;

import java.util.ArrayList;
import java.util.List;


public class Event {
	private int id;
	private String name;
	private String type;
	private String date;
	private List<Participants> participants = new ArrayList<>();

    public Event() {}
	
	public Event(int id, String name, String type, String date) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public List<Participants> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participants> participants) {
		this.participants = participants;
	}
	
	

}
