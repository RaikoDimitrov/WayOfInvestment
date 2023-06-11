package com.company;
import java.util.Scanner;

public class Main {

    //probability
    static double p1;
    static double p2;
    static double p3;
    static double p4;

    //input data
    static double w1c1p1;
    static double w1c2p2;
    static double w1c3p3;
    static double w1c4p4;

    static double w2c1p1;
    static double w2c2p2;
    static double w2c3p3;
    static double w2c4p4;

    static double w3c1p1;
    static double w3c2p2;
    static double w3c3p3;
    static double w3c4p4;

    //alternative investments
    static String sunInvestment = "Sun";
    static String windInvestment = "Wind";
    static String waterInvestment = "Water";
    static String invest = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //conditions and probability

        System.out.println("The input data are of the next 3-6 months.");
        System.out.println("C1 = Condition is retained");
        System.out.print("Probability: ");
        p1 = Double.parseDouble(scanner.nextLine());
        System.out.println("C2 = Condition worsens");
        System.out.print("Probability: ");
        p2 = Double.parseDouble(scanner.nextLine());
        System.out.println("C3 = Condition is improving");
        System.out.print("Probability: ");
        p3 = Double.parseDouble(scanner.nextLine());
        System.out.println("C4 = Condition is slightly improving");
        System.out.print("Probability: ");
        p4 = Double.parseDouble(scanner.nextLine());

        int count = 3;
        for (int i = 0; i < count; i++) {
            //alternative investments
            System.out.print("Way of investment in production of energy from: ");
            invest = scanner.nextLine();

            if (invest.equals(sunInvestment)) {
                System.out.println("Insert planned profit in million € based on market condition: ");
                System.out.print("W1C1P1 = ");
                w1c1p1 = Double.parseDouble(scanner.nextLine());
                System.out.print("W1C2P2 = ");
                w1c2p2 = Double.parseDouble(scanner.nextLine());
                System.out.print("W1C3P3 = ");
                w1c3p3 = Double.parseDouble(scanner.nextLine());
                System.out.print("W1C4P4 = ");
                w1c4p4 = Double.parseDouble(scanner.nextLine());
            }
            else if (invest.equals(windInvestment)) {
                System.out.println("Insert planned profit in million € based on market condition: ");
                System.out.print("W2C1P1 = ");
                w2c1p1 = Double.parseDouble(scanner.nextLine());
                System.out.print("W2C2P2 = ");
                w2c2p2 = Double.parseDouble(scanner.nextLine());
                System.out.print("W2C3P3 = ");
                w2c3p3 = Double.parseDouble(scanner.nextLine());
                System.out.print("W2C4P4 = ");
                w2c4p4 = Double.parseDouble(scanner.nextLine());
            }
            else if (invest.equals(waterInvestment)) {
                System.out.println("Insert planned profit in million € based on market condition: ");
                System.out.print("W3C1P1 = ");
                w3c1p1 = Double.parseDouble(scanner.nextLine());
                System.out.print("W3C2P2 = ");
                w3c2p2 = Double.parseDouble(scanner.nextLine());
                System.out.print("W3C3P3 = ");
                w3c3p3 = Double.parseDouble(scanner.nextLine());
                System.out.print("W3C4P4 = ");
                w3c4p4 = Double.parseDouble(scanner.nextLine());
            }

            else {
                System.out.println("Type valid alternative");
                System.exit(0);
            }
        }

        System.out.printf("%.1f%n", MaxExpectedProfit());
        System.out.printf("%.1f%n", MinExpectedMissedBenefit());
        System.out.printf("%.1f%n", MaxProfitInExpectedCondition());
        System.out.printf("%.1f%n", MaxGuaranteedProfit());

    }


    public static double MaxExpectedProfit() {
        //expected profit for each alternative
        double e1 = (w1c1p1 * p1) + (w1c2p2 * p2) + (w1c3p3 * p3) + (w1c4p4 * p4);
        double e2 = (w2c1p1 * p1) + (w2c2p2 * p2) + (w2c3p3 * p3) + (w2c4p4 * p4);
        double e3 = (w3c1p1 * p1) + (w3c2p2 * p2) + (w3c3p3 * p3) + (w3c4p4 * p4);
        double maxProfit = Math.max(e1, Math.max(e2, e3));
        if (maxProfit == e1) {
            System.out.printf("Optimal alternative for maximum expected profit is %s => ", sunInvestment);
        } else if (maxProfit == e2) {
            System.out.printf("Optimal alternative for maximum expected profit is %s => ", windInvestment);
        } else if (maxProfit == e3) {
            System.out.printf("Optimal alternative for maximum expected profit is %s => ", waterInvestment);
        }
        return maxProfit;
    }

    public  static double  MinExpectedMissedBenefit() {
        //max benefit for each condition
        double c1 = Math.max(w1c1p1, Math.max(w2c1p1, w3c1p1));
        double c2 = Math.max(w1c2p2, Math.max(w2c2p2, w3c2p2));
        double c3 = Math.max(w1c3p3, Math.max(w2c3p3, w3c3p3));
        double c4 = Math.max(w1c4p4, Math.max(w2c4p4, w3c4p4));

        //missed benefit new values
        double missedW1c1p1 = c1 - w1c1p1;
        double missedW1c2p2 = c2 - w1c2p2;
        double missedW1c3p3 = c3 - w1c3p3;
        double missedW1c4p4 = c4 - w1c4p4;

        double missedW2c1p1 = c1 - w2c1p1;
        double missedW2c2p2 = c2 - w2c2p2;
        double missedW2c3p3 = c3 - w2c3p3;
        double missedW2c4p4 = c4 - w2c4p4;

        double missedW3c1p1 = c1 - w3c1p1;
        double missedW3c2p2 = c2 - w3c2p2;
        double missedW3c3p3 = c3 - w3c3p3;
        double missedW3c4p4 = c4 - w3c4p4;

        //expected missed benefit for each alternative
        double e1 = (missedW1c1p1 * p1) + (missedW1c2p2 * p2) + (missedW1c3p3 * p3) + (missedW1c4p4 * p4);
        double e2 = (missedW2c1p1 * p1) + (missedW2c2p2 * p2) + (missedW2c3p3 * p3) + (missedW2c4p4 * p4);
        double e3 = (missedW3c1p1 * p1) + (missedW3c2p2 * p2) + (missedW3c3p3 * p3) + (missedW3c4p4 * p4);
        double minBenefit = Math.min(e1, Math.min(e2, e3));
        if (minBenefit == e1) {
            System.out.printf("Optimal alternative for minimum expected missed benefit is %s => ", sunInvestment);
        } else if (minBenefit == e2) {
            System.out.printf("Optimal alternative for minimum expected missed benefit is %s => ", windInvestment);
        } else if (minBenefit == e3) {
            System.out.printf("Optimal alternative for minimum expected missed benefit is %s => ", waterInvestment);
        }
        return minBenefit;
    }

    public static double MaxProfitInExpectedCondition() {
        //most expected condition
        double expectedCon = Math.max(Math.max(p1,p2), Math.max(p3,p4));

        //max profit
        double maxProfit = 0;
        if(expectedCon == p1) {
            maxProfit = Math.max(w1c1p1, Math.max(w2c1p1, w3c1p1));
        } else if (expectedCon == p2) {
            maxProfit = Math.max(w1c2p2, Math.max(w2c2p2, w3c2p2));

        } else if (expectedCon == p3) {
            maxProfit = Math.max(w1c3p3, Math.max(w2c3p3, w3c3p3));
        } else if (expectedCon == p4) {
            maxProfit = Math.max(w1c4p4, Math.max(w2c4p4, w3c4p4));
        }
        if (maxProfit == w1c1p1 || maxProfit == w1c2p2 || maxProfit == w1c3p3 || maxProfit == w1c4p4) {
            System.out.printf("Optimal alternative for maximum profit in the most probable condition is %s => ", sunInvestment);
        } else if (maxProfit == w2c1p1 || maxProfit == w2c2p2 || maxProfit == w2c3p3 || maxProfit == w2c4p4) {
            System.out.printf("Optimal alternative for maximum profit in the most probable condition is %s => ", windInvestment);
        } else if (maxProfit == w3c1p1 || maxProfit == w3c2p2 || maxProfit == w3c3p3 || maxProfit == w3c4p4) {
            System.out.printf("Optimal alternative for maximum profit in the most probable condition is %s => ", waterInvestment);
        }
        return maxProfit;
    }

    public static double MaxGuaranteedProfit() {
        //minimum profit for each alternative
        double e1 = Math.min(Math.min(w1c1p1, w1c2p2), Math.min(w1c3p3, w1c4p4));
        double e2 = Math.min(Math.min(w2c1p1, w2c2p2), Math.min(w2c3p3, w2c4p4));
        double e3 = Math.min(Math.min(w3c1p1, w3c2p2), Math.min(w3c3p3, w3c4p4));

        //max guaranteed profit
        double maxProfit = Math.max(e1, Math.max(e2, e3));
        if (maxProfit == e1) {
            System.out.printf("Optimal alternative for maximum guaranteed profit is %s => ", sunInvestment);
        } else if (maxProfit == e2) {
            System.out.printf("Optimal alternative for maximum guaranteed profit is %s => ", windInvestment);
        } else if (maxProfit == e3) {
            System.out.printf("Optimal alternative for maximum guaranteed profit is %s => ", waterInvestment);
        }
        return maxProfit;
    }
}
