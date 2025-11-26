package Assignments.Assignment5;

/**
 * Class that allows mathematical operations with fractions
 */
public class Fraction {

    private int numerator;
    private int denominator;

    /**
     * Creates a fraction with a numerator and denominator.
     * Throws IllegalArgumentException if denominator = 0.
     * @param numerator the numerator
     * @param denominator the denominator
     */
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Creates a whole number represented as a fraction.
     * @param numerator the whole number
     */
    public Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    /** @return numerator */
    public int getNumerator() {
        return numerator;
    }

    /** @return denominator */
    public int getDenominator() {
        return denominator;
    }


    /**
     * Adds another fraction to this one.
     * @param other fraction to add
     */
    public void add(Fraction other) {
        this.numerator = this.numerator * other.denominator + other.numerator * this.denominator;
        this.denominator = this.denominator * other.denominator;
    }

    /**
     * Subtracts another fraction from this one.
     * @param other fraction to subtract
     */
    public void subtract(Fraction other) {
        this.numerator = this.numerator * other.denominator - other.numerator * this.denominator;
        this.denominator = this.denominator * other.denominator;
    }

    /**
     * Multiplies this fraction with another.
     * @param other fraction to multiply
     */
    public void multiply(Fraction other) {
        this.numerator = this.numerator * other.numerator;
        this.denominator = this.denominator * other.denominator;
    }

    /**
     * Divides this fraction by another.
     * @param other fraction to divide by
     */
    public void divide(Fraction other) {
        this.numerator = this.numerator * other.denominator;
        this.denominator = this.denominator * other.numerator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    /**
     * Simple test client for the Fraction class.
     */
    public static void main(String[] args) {
        Fraction a = new Fraction(1, 2);
        Fraction b = new Fraction(3, 4);

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        a.add(b);
        System.out.println("a + b = " + a);

        Fraction c = new Fraction(5, 6);
        c.subtract(new Fraction(1, 3));
        System.out.println("5/6 - 1/3 = " + c);

        Fraction d = new Fraction(2, 3);
        d.multiply(new Fraction(3, 7));
        System.out.println("2/3 * 3/7 = " + d);

        Fraction e = new Fraction(4, 5);
        e.divide(new Fraction(2, 3));
        System.out.println("4/5 ÷ 2/3 = " + e);
    }
}
