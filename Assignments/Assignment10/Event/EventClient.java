package Assignments.Assignment10.Event;

public class EventClient {
    public static void main(String[] args) {

        EventRegister reg = new EventRegister();

        reg.add(new Event(1, "Concert", "Oslo", "Music", 202503181800L));
        reg.add(new Event(2, "Noe", "Trondheim", "Lecture", 202503171200L));

        System.out.println(reg.findByLocation("Oslo"));
        System.out.println(reg.findByDate(20250318));
        System.out.println(reg.findInInterval(202503160000L, 202503200000L));
    }
}
