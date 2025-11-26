package Assignments.Assignment9;

public class Student {

    private final String name;
    private int tasksApproved;

    public Student(String name) {
        this.name = name;
        this.tasksApproved = 0;
    }

    public String getName() {
        return name;
    }

    public int getTasksApproved() {
        return tasksApproved;
    }

    public void increaseTasksApproved(int amount) {
        if (amount > 0) {
            tasksApproved += amount;
        }
    }

    @Override
    public String toString() {
        return name + " has " + tasksApproved + " approved tasks.";
    }
}
