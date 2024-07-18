package com.softedgelab.assignment.service;

import com.softedgelab.assignment.dto.AttendeeDTO;
import com.softedgelab.assignment.entity.Event;
import com.softedgelab.assignment.entity.Attendee;
import com.softedgelab.assignment.repository.EventRepository;
import com.softedgelab.assignment.repository.AttendeeRepository;
import com.softedgelab.assignment.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Long id, Event eventDetails) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
        event.setName(eventDetails.getName());
        event.setDescription(eventDetails.getDescription());
        event.setDate(eventDetails.getDate());
        event.setLocation(eventDetails.getLocation());
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
        eventRepository.delete(event);
    }

    public Event registerAttendee(AttendeeDTO attendeeDTO) {
        Event event = eventRepository.findById(attendeeDTO.getEventId())
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));

        Attendee attendee = modelMapper.map(attendeeDTO, Attendee.class);
        attendee.setEvent(event);

        event.getAttendees().add(attendee);
        eventRepository.save(event);

        return event;
    }
}