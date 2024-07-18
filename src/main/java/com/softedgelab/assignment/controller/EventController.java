package com.softedgelab.assignment.controller;

import com.softedgelab.assignment.dto.AttendeeDTO;
import com.softedgelab.assignment.dto.EventDTO;
import com.softedgelab.assignment.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public List<EventDTO> getAllEvents() {
        return eventService.getAllEvents();
    }

    @PostMapping
    public EventDTO addEvent(@RequestBody EventDTO eventDTO) {
        return eventService.addEvent(eventDTO);
    }

    @PutMapping("/{id}")
    public EventDTO updateEvent(@PathVariable Long id, @RequestBody EventDTO eventDetails) {
        return eventService.updateEvent(id, eventDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{eventId}/attendees")
    public EventDTO registerAttendee(@PathVariable Long eventId, @RequestBody AttendeeDTO attendeeDTO) {
        attendeeDTO.setEventId(eventId);
        return eventService.registerAttendee(attendeeDTO);
    }
}