package app.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<TicketMasterEvent> getEvents(@RequestParam(name = "postalCode", required = false) String postalCode) {
        return eventService.getEvents(postalCode);
    }
}
