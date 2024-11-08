package mk.finki.ukim.mk.demo.service;

import mk.finki.ukim.mk.demo.model.Event;
import mk.finki.ukim.mk.demo.model.EventBooking;

import java.util.List;

public interface EventService {
    List<Event> listAll();
    List<Event> searchEvents(String text);
    List<Event> specialSearch(String text,double rating);
}