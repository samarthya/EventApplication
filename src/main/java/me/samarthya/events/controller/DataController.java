package me.samarthya.events.controller;

import me.samarthya.events.model.EventsModel;
import me.samarthya.events.model.SessionModel;
import me.samarthya.events.model.VotersModel;
import me.samarthya.events.jpa.repository.EventRepository;
import me.samarthya.events.jpa.repository.SessionRepository;
import me.samarthya.events.jpa.repository.VotersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;



@RestController
public class DataController {

    private Logger logger = LoggerFactory.getLogger(DataController.class);

    @Autowired
    EventRepository eventRepo;

    @Autowired
    SessionRepository sessionRepo;

    @Autowired
    VotersRepository votersRepo;

    @ResponseBody
    @GetMapping(path = "/ets")
    public Iterable<EventsModel> getEvents() {
        if(eventRepo != null ){
            System.out.println(" GetEvents: called");
            logger.debug(" GetEvents: called");
        }
        return eventRepo.findAll();
    }

    @ResponseBody
    @GetMapping(value="ets/{id}")
    public EventsModel getEvent(@PathVariable("id") long eventId) {
        try {
            return eventRepo.findById(Long.valueOf(eventId)).get();
        }catch(java.util.NoSuchElementException ex) {
            return null;
        }
    }

    @ResponseBody
    @PostMapping(path="/ets")
    public EventsModel saveEvent(@RequestBody EventsModel eventsModel) {
        if(eventsModel != null) {
            return eventRepo.save(eventsModel);
        }
        return null;
    }

    @ResponseBody
    @GetMapping(path = "/sessions")
    public Iterable<SessionModel> searchEvents(@RequestParam("search") String searchTerm) {
        return sessionRepo.findByAbstractValue(searchTerm);
    }

    ///api/vote/${eventId}/sessions/${session.id}/voters/${userName}
    @ResponseBody
    @PostMapping(path="/vote/{eventid}/sessions/{sessionid}/voters/{username}")
    public EventsModel saveVote(@PathVariable("eventid") long eventId,
                                @PathVariable("sessionid") int sessionid,
                                @PathVariable("username") String username) {
        Optional<EventsModel> emo = eventRepo.findById(eventId);
        if(emo.isPresent()) {

            EventsModel em = emo.get();

            for(SessionModel sm: em.getoSessions()) {
                if(sm.getiId() == sessionid) {
                    if(!sm.getVoters().contains(username.trim())){
                        sm.getVoters().add(new VotersModel(username));
                        eventRepo.save(em);
                        return em;
                    }
                }
            }
        }
        return null;
    }

    ///api/vote/${eventId}/sessions/${session.id}/voters/${userName}
    @ResponseBody
    @DeleteMapping(path="/vote/{eventid}/sessions/{sessionid}/voters/{username}")
    public EventsModel deleteVote(@PathVariable("eventid") long eventId,
                                @PathVariable("sessionid") int sessionid,
                                @PathVariable("username") String username) {
        Optional<EventsModel> emo = eventRepo.findById(eventId);
        if(emo.isPresent()) {

            EventsModel em = emo.get();

            for(SessionModel sm: em.getoSessions()) {
                if(sm.getiId() == sessionid) {
                    for(VotersModel cms: sm.getVoters()){
                        if(cms.getsVoterName().contains(username.trim())){
                            sm.getVoters().remove(cms);
                            eventRepo.save(em);
                            return em;
                        }
                    }
                }
            }
        }

        return null;
    }
}
