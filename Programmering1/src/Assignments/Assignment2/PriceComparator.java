package Assignments.Assignment2;

public class PriceComparator {
    public static void main(String[] args) {

        double priceA = 35.90;
        double gramsA = 450;

        double priceB = 39.50;
        double gramsB = 500;

        double pricePerGramA = priceA / gramsA;
        double pricePerGramB = priceB / gramsB;

        if (pricePerGramA < pricePerGramB) {
            System.out.println("Brand A is cheaper.");
        } else if (pricePerGramA > pricePerGramB) {
            System.out.println("Brand B is cheaper.");
        } else {
            System.out.println("Both products have the same price per gram.");
        }
    }
}
