package app.Service.SeatGeek;

import app.Service.SeatGeek.Models.SeatGeekEvent;
import app.Service.SeatGeek.Models.SeatGeekEventResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class SeatGeekEventService {

    private final RestTemplate restTemplate;

    public SeatGeekEventService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<SeatGeekEvent> getEvents(String postalCode) {
        String url = "https://api.seatgeek.com/2/events?client_id=MzQ1MzMwMTh8MTY4Nzc4OTY3Mi43MjYzODg1";

        if (postalCode != null && !postalCode.isEmpty()) {
            url += "&postal_code=" + postalCode;
        }

        SeatGeekEventResponse eventResponse = restTemplate.getForObject(url, SeatGeekEventResponse.class);
        if (eventResponse != null && eventResponse.getEvents() != null) {
            return eventResponse.getEvents();
        } else {
            return Collections.emptyList();
        }
    }
}

