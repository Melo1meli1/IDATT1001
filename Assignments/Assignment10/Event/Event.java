package Assignments.Assignment10.Event;

public class Event {
    int id;
    String name;
    String location;
    String type;
    long time;

    public Event(int id, String name, String location, String type, long time) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.type = type;
        this.time = time;
    }

    public String toString() {
        return id + " " + name + " " + location + " " + type + " " + time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
