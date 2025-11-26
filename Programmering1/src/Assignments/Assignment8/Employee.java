package Assignments.Assignment8;

import java.util.GregorianCalendar;
import java.util.Calendar;

public class Employee {

    private final Person person;
    private int employeeNumber;
    private int yearHired;
    private double monthlySalary;
    private double taxPercent;

    public Employee(Person person, int employeeNumber, int yearHired, double monthlySalary, double taxPercent) {
        this.person = person;
        this.employeeNumber = employeeNumber;
        this.yearHired = yearHired;
        this.monthlySalary = monthlySalary;
        this.taxPercent = taxPercent;
    }

    public Person getPerson() {
        return person;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public int getYearHired() {
        return yearHired;
    }

    public void setYearHired(int yearHired) {
        this.yearHired = yearHired;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public double getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(double taxPercent) {
        this.taxPercent = taxPercent;
    }

    /**
     * monthly tax
     */
    public double getMonthlyTax() {
        return monthlySalary * (taxPercent / 100.0);
    }

    /**
     * yearly gross salary
     */
    public double getYearlySalary() {
        return monthlySalary * 12;
    }

    /**
     * yearly tax:
     * June: no tax
     * December: half tax
     */
    public double getYearlyTax() {
        double normalMonths = 10 * getMonthlyTax(); // Jan–May + July–Nov
        double halfTax = getMonthlyTax() / 2;       // December
        return normalMonths + halfTax;
    }

    /**
     * "Lastname, Firstname" requires cooperation with Person
     */
    public String getFullName() {
        return person.getLastName() + ", " + person.getFirstName();
    }

    /**
     * age → requires Person because birthYear is stored there
     */
    public int getAge() {
        GregorianCalendar calendar = new GregorianCalendar();
        int currentYear = calendar.get(Calendar.YEAR);
        return currentYear - person.getBirthYear();
    }

    /**
     * number of years employed
     */
    public int getYearsEmployed() {
        GregorianCalendar calendar = new GregorianCalendar();
        int currentYear = calendar.get(Calendar.YEAR);
        return currentYear - yearHired;
    }

    /**
     * has been employed longer than given years?
     */
    public boolean hasBeenEmployedLongerThan(int years) {
        return getYearsEmployed() > years;
    }

    @Override
    public String toString() {
        return "Employee: " + getFullName() +
                "\nEmployee Number: " + employeeNumber +
                "\nYear Hired: " + yearHired +
                "\nMonthly Salary: " + monthlySalary +
                "\nTax Percent: " + taxPercent;
    }


    public static void main(String[] args) {

        Person p = new Person("Berit", "Johnsen", 1980);
        Employee e = new Employee(p, 1234, 2010, 45000, 30);

        System.out.println(e);
        System.out.println("\nFull name: " + e.getFullName());
        System.out.println("Age: " + e.getAge());
        System.out.println("Years employed: " + e.getYearsEmployed());
        System.out.println("Monthly tax: " + e.getMonthlyTax());
        System.out.println("Yearly salary: " + e.getYearlySalary());
        System.out.println("Yearly tax: " + e.getYearlyTax());
        System.out.println("Employed more than 5 years? " + e.hasBeenEmployedLongerThan(5));
    }
}
