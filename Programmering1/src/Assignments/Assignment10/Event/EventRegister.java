package Assignments.Assignment10.Event;

import java.util.ArrayList;

public class EventRegister {

    ArrayList<Event> events = new ArrayList<>();

    public void add(Event e) {
        events.add(e);
    }

    public ArrayList<Event> findByLocation(String location) {
        ArrayList<Event> list = new ArrayList<>();
        for (Event e : events)
            if (e.location.equals(location))
                list.add(e);
        return list;
    }

    public ArrayList<Event> findByDate(long date) {
        ArrayList<Event> list = new ArrayList<>();
        for (Event e : events)
            if (e.time / 10000 == date)
                list.add(e);
        return list;
    }

    public ArrayList<Event> findInInterval(long from, long to) {
        ArrayList<Event> list = new ArrayList<>();
        for (Event e : events)
            if (e.time >= from && e.time <= to)
                list.add(e);
        return list;
    }
}
