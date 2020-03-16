package com.danno.demo.controller;

import com.danno.demo.controller.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    EventJpaRepository eventJpaRepository;

    // 
//    @Produces({"application/json"})

    @GetMapping("/all")
    public List<Event> getAll() {
        List<Event> events = eventJpaRepository.findAll();
        return events;
    }

    @GetMapping(value = "/{name}")
    public List<Event> findByName(@PathVariable final String name) {
        return eventJpaRepository.findByName(name);
    }

    @Transactional
    @PostMapping("/load")
    public List<Event> load(@RequestBody Event event) {
        eventJpaRepository.save(event);
        eventJpaRepository.flush();

        return eventJpaRepository.findByName(event.getName());
    }

    @Transactional
    @PostMapping("/interested")
    public List<Event> userInterested(@RequestBody Event event) {
        System.out.println("Processing interested id="+event.getEventid());
        eventJpaRepository.save(event);
        eventJpaRepository.flush();

        return eventJpaRepository.findByName(event.getName());
    }
}
