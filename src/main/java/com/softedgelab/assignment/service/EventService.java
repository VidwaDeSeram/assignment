package com.softedgelab.assignment.service;

import com.softedgelab.assignment.dto.AttendeeDTO;
import com.softedgelab.assignment.dto.EventDTO;
import com.softedgelab.assignment.entity.Event;
import com.softedgelab.assignment.entity.Attendee;
import com.softedgelab.assignment.exception.ResourceNotFoundException;
import com.softedgelab.assignment.repository.EventRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EventRepository eventRepository;

    public List<EventDTO> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream()
                .map(event -> modelMapper.map(event, EventDTO.class))
                .collect(Collectors.toList());
    }

    public EventDTO addEvent(EventDTO eventDTO) {
        Event event = modelMapper.map(eventDTO, Event.class);
        event = eventRepository.save(event);
        return modelMapper.map(event, EventDTO.class);
    }

    public EventDTO updateEvent(Long id, EventDTO eventDetails) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));

        // Manually update the fields
        if (eventDetails.getName() != null) {
            event.setName(eventDetails.getName());
        }
        if (eventDetails.getDescription() != null) {
            event.setDescription(eventDetails.getDescription());
        }
        if (eventDetails.getDate() != null) {
            event.setDate(eventDetails.getDate());
        }
        if (eventDetails.getLocation() != null) {
            event.setLocation(eventDetails.getLocation());
        }

        event = eventRepository.save(event);
        return modelMapper.map(event, EventDTO.class);
    }

    public void deleteEvent(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
        eventRepository.delete(event);
    }

    public EventDTO registerAttendee(AttendeeDTO attendeeDTO) {
        Event event = eventRepository.findById(attendeeDTO.getEventId())
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
        Attendee attendee = modelMapper.map(attendeeDTO, Attendee.class);
        attendee.setEvent(event);

        event.getAttendees().add(attendee);
        eventRepository.save(event);

        return modelMapper.map(event, EventDTO.class);
    }
}