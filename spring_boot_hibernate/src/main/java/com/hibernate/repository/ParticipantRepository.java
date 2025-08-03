package com.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hibernate.model.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Integer>{

}
