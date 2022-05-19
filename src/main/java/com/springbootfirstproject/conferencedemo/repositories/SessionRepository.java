package com.springbootfirstproject.conferencedemo.repositories;

import com.springbootfirstproject.conferencedemo.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
