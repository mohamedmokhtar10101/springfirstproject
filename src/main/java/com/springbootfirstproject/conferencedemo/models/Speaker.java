package com.springbootfirstproject.conferencedemo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity(name = "speakers")
@JsonIgnoreProperties({"HibernateLazyInitializer", "handler"})
public class Speaker {
    @Id
    @GeneratedValue
    @Column(name = "speaker_id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String title;
    private String company;
    @Column(name = "speaker_bio")
    private String spakerBio;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    @Column(name = "speaker_photo")
    //@Column(name = "speaker_photo", columnDefinition = "blob")
    private byte [] speakerPhoto;


    //@JsonBackReference // this list will be omited from json output or we can igone it from json serialization
    @JsonIgnore
    @ManyToMany(mappedBy = "speakers", cascade = CascadeType.ALL)
    private List<Session> sessions;



    public Speaker() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }

    public String getSpakerBio() {
        return spakerBio;
    }
    public void setSpakerBio(String spakerBio) {
        this.spakerBio = spakerBio;
    }

    public List<Session> getSessions() {
        return sessions;
    }
    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }
    public void addSession(Session session) {
        sessions.add(session);
    }
    public void removeSession(Session session) {
        sessions.remove(session);
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getSpeakerPhoto() {
        return speakerPhoto;
    }
    public void setSpeakerPhoto(byte[] speakerPhoto) {
        this.speakerPhoto = speakerPhoto;
    }

}
