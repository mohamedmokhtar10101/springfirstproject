package com.springbootfirstproject.conferencedemo.repositories;

import com.springbootfirstproject.conferencedemo.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {

}
