package mk.finki.ukim.mk.demo.service.impl;

import mk.finki.ukim.mk.demo.model.Event;
import mk.finki.ukim.mk.demo.model.EventBooking;
import mk.finki.ukim.mk.demo.repository.EventRepository;
import mk.finki.ukim.mk.demo.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> searchEvents(String text) {
        return eventRepository.searchEvents(text);
    }

    @Override
    public List<Event> specialSearch(String text, double rating) {
        return eventRepository.specialSearch(text,rating);
    }

    @Override
    public Optional<Event> save(Event e) {
        return eventRepository.save(e);
    }

    @Override
    public Optional<Event> find_by_ID(long id) {
        return eventRepository.find_by_ID(id);
    }

    @Override
    public void delete(long id) {
        eventRepository.delete(id);
    }
}
