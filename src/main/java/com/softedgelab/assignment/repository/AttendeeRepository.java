package com.softedgelab.assignment.repository;

import com.softedgelab.assignment.entity.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendeeRepository extends JpaRepository<Attendee, Long> {}