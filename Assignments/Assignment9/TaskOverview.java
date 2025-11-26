package Assignments.Assignment9;

public class TaskOverview {

    private Student[] students;
    private int studentCount = 0;

    public TaskOverview(int maxStudents) {
        students = new Student[maxStudents];
    }

    /**
     * Returns number of registered students
     */
    public int getStudentCount() {
        return studentCount;
    }

    /**
     * Returns the number of tasks a specific student has completed
     */
    public int getTasksForStudent(String name) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getName().equals(name)) {
                return students[i].getTasksApproved();
            }
        }
        return -1; // not found
    }

    /**
     * Registers a new student
     */
    public void registerStudent(String name) {
        if (studentCount < students.length) {
            students[studentCount] = new Student(name);
            studentCount++;
        }
    }

    /**
     * Increases tasks for a specific student
     */
    public void increaseTasksForStudent(String name, int amount) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getName().equals(name)) {
                students[i].increaseTasksApproved(amount);
                return;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Students:\n");

        for (int i = 0; i < studentCount; i++) {
            sb.append(students[i]).append("\n");
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        TaskOverview overview = new TaskOverview(10);

        overview.registerStudent("Viktor");
        overview.registerStudent("Ramtin");
        overview.registerStudent("Olav");

        overview.increaseTasksForStudent("Viktor", 5);
        overview.increaseTasksForStudent("Olav", 2);

        System.out.println(overview);
    }
}
