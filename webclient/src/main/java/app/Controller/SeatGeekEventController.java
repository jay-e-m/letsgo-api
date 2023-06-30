package app.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import app.Service.SeatGeek.SeatGeekEventService;
import java.util.List;
import app.Service.SeatGeek.Models.SeatGeekEvent;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SeatGeekEventController {
    private final SeatGeekEventService eventService;

    public SeatGeekEventController(SeatGeekEventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/seatgeek/events")
    public List<SeatGeekEvent> getEvents() {
        List<SeatGeekEvent> events = eventService.getEvents();
        for(SeatGeekEvent event : events){
            System.out.println("Event Name: " + event.getTitle());
            System.out.println("Event URL: " + event.getUrl());
            System.out.println("Event Image: " + event.getPerformers().get(0).getImages().get("huge")); // change this line
            if(event.getDatetime_local() != null) {
                System.out.println("Event Time: " + event.getDatetime_local());
            }
            if(event.getVenue() != null) {
                System.out.println("Venue: " + event.getVenue().getName());
                if(event.getVenue().getCity() != null) {
                    System.out.println("City: " + event.getVenue().getCity());
                }
                if(event.getVenue().getState() != null) {
                    System.out.println("State: " + event.getVenue().getState());
                }
                System.out.println("Postal Code: " + event.getVenue().getPostal_code());
            }
        }

        return events;
    }
}
