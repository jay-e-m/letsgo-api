package app.Service.SeatGeek.Models;

import java.util.List;

public class SeatGeekEvent {
    private String title;
    private String datetime_local;
    private Venue venue;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDatetime_local() {
        return datetime_local;
    }

    public void setDatetime_local(String datetime_local) {
        this.datetime_local = datetime_local;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public static class Venue {
        private String name;
        private String city;
        private String state;
        private String postal_code;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getPostal_code() {
            return postal_code;
        }

        public void setPostal_code(String postal_code) {
            this.postal_code = postal_code;
        }
    }
}
