package app.Service.SeatGeek.Models;

import java.util.List;

public class SeatGeekEventResponse {
    private List<SeatGeekEvent> events;

    public List<SeatGeekEvent> getEvents() {
        return events;
    }

    public void setEvents(List<SeatGeekEvent> events) {
        this.events = events;
    }
}
