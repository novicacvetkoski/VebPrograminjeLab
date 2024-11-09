package mk.finki.ukim.mk.demo.service;

import mk.finki.ukim.mk.demo.model.Event;
import mk.finki.ukim.mk.demo.model.EventBooking;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> listAll();
    List<Event> searchEvents(String text);
    List<Event> specialSearch(String text,double rating);
    Optional<Event> save(Event e);
    Optional<Event> find_by_ID(long id);
    void delete(long id);
}