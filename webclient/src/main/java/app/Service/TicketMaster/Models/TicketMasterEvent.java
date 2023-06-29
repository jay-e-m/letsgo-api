package app.Service.TicketMaster.Models;

import java.util.List;

public class TicketMasterEvent {
    private String name;
    private Dates dates;
    private Embedded _embedded;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public Embedded get_embedded() {
        return _embedded;
    }

    public void set_embedded(Embedded _embedded) {
        this._embedded = _embedded;
    }

    public static class Dates {
        private Start start;
        private End end;

        public Start getStart() {
            return start;
        }

        public void setStart(Start start) {
            this.start = start;
        }

        public End getEnd() {
            return end;
        }

        public void setEnd(End end) {
            this.end = end;
        }

        public static class Start {
            private String dateTime;

            public String getDateTime() {
                return dateTime;
            }

            public void setDateTime(String dateTime) {
                this.dateTime = dateTime;
            }
        }

        public static class End {
            private String dateTime;

            public String getDateTime() {
                return dateTime;
            }

            public void setDateTime(String dateTime) {
                this.dateTime = dateTime;
            }
        }
    }

    public static class Embedded {
        private List<Venue> venues;

        public List<Venue> getVenues() {
            return venues;
        }

        public void setVenues(List<Venue> venues) {
            this.venues = venues;
        }

        public static class Venue {
            private String name;
            private String postalCode;
            private City city;
            private State state;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPostalCode() {
                return postalCode;
            }

            public void setPostalCode(String postalCode) {
                this.postalCode = postalCode;
            }

            public City getCity() {
                return city;
            }

            public void setCity(City city) {
                this.city = city;
            }

            public State getState() {
                return state;
            }

            public void setState(State state) {
                this.state = state;
            }

            public static class City {
                private String name;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }

            public static class State {
                private String name;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }
    }

}
