package com.springbootfirstproject.conferencedemo.controllers;

import com.springbootfirstproject.conferencedemo.models.Session;
import com.springbootfirstproject.conferencedemo.models.Speaker;
import com.springbootfirstproject.conferencedemo.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/speakers")
public class SpeakerController {


    private SpeakerRepository speakerRepository;

    @Autowired
    public void setSpeakerRepository(SpeakerRepository speakerRepository) {
        this.speakerRepository = speakerRepository;
    }

    @GetMapping
    public List<Speaker> getAllSpeakers() {
        return speakerRepository.findAll();
    }

    @GetMapping(value = "{id}")
    public Speaker getSpeaker(@PathVariable Long id) {
        return speakerRepository.findById(id).get();
    }
    @PostMapping
    public Speaker CreateSpeaker(@RequestBody final Speaker speaker) {
        return speakerRepository.saveAndFlush(speaker);
    }

    @DeleteMapping(value = "{id}")
    //@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteSpeaker(@PathVariable Long id){
        speakerRepository.deleteById(id);
    }
    @PutMapping(value = "{id}")
    //@RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker updateSpeaker(@PathVariable Long id, @RequestBody Session newSession){
        Speaker existingSession = speakerRepository.findById(id).get();
        BeanUtils.copyProperties(newSession, existingSession, "id");
        return speakerRepository.saveAndFlush(existingSession);
    }


}
