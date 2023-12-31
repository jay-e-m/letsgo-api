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


    public List<TicketMasterEvent> getEvents(String postalCode) {
        String url = "https://app.ticketmaster.com/discovery/v2/events.json?apikey=ihrEJGVbWZWb4UeA6lbZ6Ax3ELRkkyGV&size=100";

        if (postalCode != null && !postalCode.isEmpty()) {
            url += "&postalCode=" + postalCode;
        }

        TicketMasterEventResponse eventResponse = restTemplate.getForObject(url, TicketMasterEventResponse.class);
        if (eventResponse != null && eventResponse.get_embedded() != null) {
            List<TicketMasterEvent> events = eventResponse.get_embedded().getEvents();
            for (TicketMasterEvent event : events) {
                List<TicketMasterEvent.Image> images = event.getImages();
                images.removeIf(image ->
                        !"16_9".equals(image.getRatio()) ||
                                image.getWidth() != 1024 ||
                                image.getHeight() != 576);
            }
            return events;
        } else {
            return Collections.emptyList();
        }
    }


}
