package com.springbootfirstproject.conferencedemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity(name = "sessions")
public class Session {

    @Id
    @GeneratedValue
    @Column(name = "session_id")
    private Long id;
    @Column(name = "session_name")
    private String name;
    @Column(name = "session_description")
    private String description;
    @Column(name = "session_length")
    private Integer length;


   // @JsonManagedReference //To sove recursive json output the managed will have speakers list but the back reference will not have sessions list
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "session_speakers", joinColumns = @JoinColumn(name = "session_id"), inverseJoinColumns = @JoinColumn(name = "speaker_id"))
    private List<Speaker> speakers;



    public Session() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLength() {
        return length;
    }
    public void setLength(Integer length) {
        this.length = length;
    }

    public List<Speaker> getSpeakers() {
        return speakers;
    }
    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }
    public void addSpeaker(Speaker speaker) {
        speakers.add(speaker);
    }
    public void removeSpeaker(Speaker speaker) {
         speakers.remove(speaker);
    }
}
