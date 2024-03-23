// Main class for the demo program
public class NoMatchDemo {
    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw new IllegalArgumentException("Exactly one command line argument is required.");
            }

            String input = args[0];
            checkInput(input);
            System.out.println("Input matches 'India'.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (NOMATCHEXCP e) {
            System.err.println("NOMATCHEXCP: " + e.getMessage());
        }
    }

    // Method to check if the input matches "India"
    public static void checkInput(String input) throws NOMATCHEXCP {
        if (!"India".equals(input)) {
            // Note: In a real program, you might want to log or pass along the line number where this was thrown.
            // For the purpose of this assignment, we'll just include a placeholder for the line number in the message.
            throw new NOMATCHEXCP("Line number: [LineNumber] - Input '" + input + "' does not match 'India'.");
        }
    }
}
