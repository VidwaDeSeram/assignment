package com.softedgelab.assignment.repository;

import com.softedgelab.assignment.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {}