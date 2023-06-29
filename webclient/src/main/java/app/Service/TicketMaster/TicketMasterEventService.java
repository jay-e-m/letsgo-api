package app.Service.TicketMaster;

import app.Service.TicketMaster.Models.TicketMasterEvent;
import app.Service.TicketMaster.Models.TicketMasterEventResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class TicketMasterEventService {

    private final RestTemplate restTemplate;

    public TicketMasterEventService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<TicketMasterEvent> getEvents() {
        String url = "https://app.ticketmaster.com/discovery/v2/events.json?apikey=ihrEJGVbWZWb4UeA6lbZ6Ax3ELRkkyGV&size=100";
        TicketMasterEventResponse eventResponse = restTemplate.getForObject(url, TicketMasterEventResponse.class);
        if (eventResponse != null && eventResponse.get_embedded() != null) {
            return eventResponse.get_embedded().getEvents();
        } else {
            return Collections.emptyList();
        }
    }

}
