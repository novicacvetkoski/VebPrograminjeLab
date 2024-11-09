package mk.finki.ukim.mk.demo.web.controller;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.demo.model.Event;
import mk.finki.ukim.mk.demo.model.Location;
import mk.finki.ukim.mk.demo.service.EventBookingService;
import mk.finki.ukim.mk.demo.service.EventService;
import mk.finki.ukim.mk.demo.service.LocationService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/events")
public class EventController {
    private final EventBookingService Bookings;
    private final mk.finki.ukim.mk.demo.service.EventService EventService;

    private final LocationService locationService;


    private List<Event> found_events;

    public EventController(EventBookingService bookings, mk.finki.ukim.mk.demo.service.EventService eventService, LocationService locationService) {
        Bookings = bookings;
        EventService = eventService;
        this.locationService = locationService;
        found_events = new ArrayList<>();
    }

    @GetMapping
    public String getEventsPage(@RequestParam(required = false) String error, Model model){
        model.addAttribute("events",this.EventService.listAll());
        return "listEvents";
    }
    @PostMapping
    public String Post_Method(HttpServletRequest request, Model model){
        String tmp = request.getParameter("redirect");
        String add_check = request.getParameter("redirect-add-event");
        String text = request.getParameter("searchText");
        double rating = Double.parseDouble(request.getParameter("searchDesc"));
        found_events = EventService.specialSearch(text,rating);
        model.addAttribute("searchEvents",found_events);
        model.addAttribute("events",this.EventService.listAll());
        found_events = new ArrayList<>();
        return "listEvents";
    }
    @PostMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id){
        this.EventService.delete(id);
        return "redirect:/events";
    }

    @GetMapping("/events/add-form")
    public String getAddEventPage(Model model){
        model.addAttribute("location_IDS",locationService.findAll());
        return "AddEvent";
    }
    @GetMapping("/events/edit-form/{id}")
    public String getEditEventForm(@PathVariable Long id, Model model){
        if(this.EventService.find_by_ID(id).isPresent()){
            Event tmp = this.EventService.find_by_ID(id).get();
            model.addAttribute("location_IDS",locationService.findAll());
            model.addAttribute("Event",tmp);
        }
        return "AddEvent";

    }
    @PostMapping("/event/submitBooking")
    public String BookingConfrimation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int numTickets = Integer.parseInt(request.getParameter("numTickets"));
        String event_name = request.getParameter("event_name");
        String client_ip=request.getRemoteAddr();
        String name = request.getHeader("User-Agent");
        Bookings.placeBooking(event_name,name,client_ip,numTickets);
        return "redirect:/event/BookingConfirmation";
    }
    @PostMapping("/add")
    public String saveEvent(@RequestParam String name,
                            @RequestParam String description,
                            @RequestParam double popularity_score,
                            @RequestParam long location_id)
    {
        Event e = new Event(name,description,popularity_score);
        Location tmp = locationService.find_by_ID(location_id).get();
        e.setLocation(tmp);
        this.EventService.save(e);
        return "redirect:/events";
    }

    @GetMapping("/search")
    public String search(HttpServletRequest req, HttpServletResponse resp,Model model){
        String text = req.getParameter("searchText");
        double rating = Double.parseDouble(req.getParameter("searchDesc"));
        List<Event> found_events = EventService.specialSearch(text, rating);
        model.addAttribute("searchEvents", found_events);
        model.addAttribute("events",this.EventService.listAll());
        return "listEvents";
    }

}
