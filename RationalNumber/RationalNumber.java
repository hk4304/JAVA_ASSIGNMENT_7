public class RationalNumber {
    private int numerator;
    private int denominator;

    public RationalNumber(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        // Reduce the rational number
        int gcd = gcd(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    // Calculates the greatest common divisor (Euclidean algorithm)
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // Method to add two rational numbers
    public RationalNumber add(RationalNumber other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new RationalNumber(newNumerator, newDenominator);
    }

    // Method to subtract two rational numbers
    public RationalNumber subtract(RationalNumber other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new RationalNumber(newNumerator, newDenominator);
    }

    // Method to multiply two rational numbers
    public RationalNumber multiply(RationalNumber other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new RationalNumber(newNumerator, newDenominator);
    }

    // Method to divide two rational numbers
    public RationalNumber divide(RationalNumber other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new RationalNumber(newNumerator, newDenominator);
    }

    // Method to convert a rational number to a floating point
    public double toFloatingPoint() {
        return (double) numerator / denominator;
    }

    // Method to find the absolute value of a rational number
    public RationalNumber absolute() {
        return new RationalNumber(Math.abs(numerator), Math.abs(denominator));
    }

    // Overridden toString method for display
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Entry point to test the RationalNumber class
    public static void main(String[] args) {
        try {
            if (args.length != 4) {
                throw new IllegalArgumentException("Four command line arguments are required.");
            }

            int num1 = Integer.parseInt(args[0]);
            int den1 = Integer.parseInt(args[1]);
            int num2 = Integer.parseInt(args[2]);
            int den2 = Integer.parseInt(args[3]);

            RationalNumber r1 = new RationalNumber(num1, den1);
            RationalNumber r2 = new RationalNumber(num2, den2);

            System.out.println("First rational number: " + r1);
            System.out.println("Second rational number: " + r2);
            System.out.println("Sum: " + r1.add(r2));
            System.out.println("Difference: " + r1.subtract(r2));
            System.out.println("Product: " + r1.multiply(r2));
            System.out.println("Quotient: " + r1.divide(r2));
            System.out.println("First number in floating point: " + r1.toFloatingPoint());
            System.out.println("Second number in floating point: " + r2.toFloatingPoint());
            System.out.println("Absolute value of first number: " + r1.absolute());
            System.out.println("Absolute value of second number: " + r2.absolute());
        } catch (NumberFormatException e) {
            System.err.println("Command line arguments must be integers.");
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.err.println(e.getMessage());
        }
    }
}
