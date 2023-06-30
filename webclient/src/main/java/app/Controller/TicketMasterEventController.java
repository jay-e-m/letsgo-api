package app.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import app.Service.TicketMaster.TicketMasterEventService;
import java.util.List;
import app.Service.TicketMaster.Models.TicketMasterEvent;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TicketMasterEventController {
    private final TicketMasterEventService eventService;

    public TicketMasterEventController(TicketMasterEventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/ticketmaster/events")
    public List<TicketMasterEvent> getEvents() {
        List<TicketMasterEvent> events = eventService.getEvents();
        for(TicketMasterEvent event : events){
            System.out.println("Event Name: " + event.getName());
            System.out.println("Event URL: " + event.getUrl());
            System.out.println("Image URL: " + event.getImages().get(0).getUrl());
            if(event.getDates() != null) {
                if(event.getDates().getStart() != null) {
                    System.out.println("Start Date: " + event.getDates().getStart().getDateTime());
                }
                if(event.getDates().getEnd() != null) {
                    System.out.println("End Date: " + event.getDates().getEnd().getDateTime());
                }
            }
            if(event.get_embedded() != null && event.get_embedded().getVenues() != null && !event.get_embedded().getVenues().isEmpty()) {
                TicketMasterEvent.Embedded.Venue venue = event.get_embedded().getVenues().get(0);
                System.out.println("Venue: " + venue.getName());
                if(venue.getCity() != null) {
                    System.out.println("City: " + venue.getCity().getName());
                }
                if(venue.getState() != null) {
                    System.out.println("State: " + venue.getState().getName());
                }
                System.out.println("Postal Code: " + venue.getPostalCode());
            }
        }

        return events;
    }
}
