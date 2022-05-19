package com.springbootfirstproject.conferencedemo.controllers;

import com.springbootfirstproject.conferencedemo.models.Session;
import com.springbootfirstproject.conferencedemo.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/sessions")
public class SessionsController {
    private SessionRepository sessionRepository;

    @Autowired
    public void setSessionRepository(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }


    @GetMapping
    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    @GetMapping(value = "{id}")
    //@RequestMapping("{id}")
    public Session getSession(@PathVariable Long id) {
        return sessionRepository.findById(id).get();
    }
    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED) to send created status which is 201 when the object is created
    public Session createSession(@RequestBody final Session session) {
        return sessionRepository.saveAndFlush(session);
    }

    @DeleteMapping(value = "{id}")
    //@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteSession(@PathVariable Long id){
        sessionRepository.deleteById(id);
    }
    @PutMapping(value = "{id}")
    //@RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session updateSession(@PathVariable Long id, @RequestBody Session newSession){
        Session existingSession = sessionRepository.findById(id).get();
        BeanUtils.copyProperties(newSession, existingSession, "id");
        return sessionRepository.saveAndFlush(existingSession);
    }

}
