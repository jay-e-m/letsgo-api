package app.Controller;

import app.Service.SeatGeek.Models.SeatGeekEvent;
import app.Service.SeatGeek.SeatGeekEventService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SeatGeekEventController {

    private final SeatGeekEventService eventService;

    public SeatGeekEventController(SeatGeekEventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/seatgeek/events")
    public List<SeatGeekEvent> getEvents(@RequestParam(name = "postalCode", required = false) String postalCode) {
        return eventService.getEvents(postalCode);
    }
}
