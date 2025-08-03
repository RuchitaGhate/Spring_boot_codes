package com.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hibernate.model.Event;

public interface EventRepository extends JpaRepository<Event, Integer>{

}
