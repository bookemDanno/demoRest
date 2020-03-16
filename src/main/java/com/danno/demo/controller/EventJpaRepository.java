package com.danno.demo.controller;

import com.danno.demo.controller.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EventJpaRepository extends JpaRepository<Event, Long> {
    List<Event> findByName(String name);

    Event save(Event event);
}
