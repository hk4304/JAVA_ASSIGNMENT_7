// Custom exception class
public class FactorialException extends IllegalArgumentException {
    private int number;

    public FactorialException(String message, int number) {
        super(message + " Number: " + number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}

// Main class to calculate the factorial
class FactorialCalculator {
    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw new IllegalArgumentException("Exactly one command line argument is required.");
            }

            int number = Integer.parseInt(args[0]);
            if (number <= 0 || number > 15) {
                throw new FactorialException("Number must be between 1 and 15.", number);
            }

            int result = factorial(number);
            System.out.println("The factorial of " + number + " is " + result);
        } catch (NumberFormatException e) {
            System.err.println("Command line argument must be an integer.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    // Recursive method to calculate factorial
    public static int factorial(int n) {
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }
}
