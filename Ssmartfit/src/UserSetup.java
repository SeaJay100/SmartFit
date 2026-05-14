import java.util.Scanner;

// Handles collecting and validating user input
public class UserSetup {

    private final Scanner scanner = new Scanner(System.in);

    // Guides user through setup process
    public User createUser() {
        printLine();
        System.out.println("  WELCOME TO YOUR PERSONALIZED WORKOUT GENERATOR");
        printLine();

        System.out.println("How should we address you? (Enter your name)");
        String name = readName();

        System.out.println("\nEnter the days you are available (comma-separated)");
        System.out.println("  Example: Monday, Wednesday, Friday");
        System.out.println("  Or short: Mon, Wed, Fri");
        String[] availableDays = readAvailableDays();

        int fitnessGoal = readFitnessGoal();
        int equipmentLevel = readEquipmentLevel();

        return new User(name, availableDays, fitnessGoal, equipmentLevel);
    }

    // Returns user's name or "NoName" if empty
    private String readName() {
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            return "NoName";
        }
        return name;
    }

    // Repeatedly prompts until valid days are entered
    private String[] readAvailableDays() {
        while (true) {
            String input = scanner.nextLine().trim();
            String[] days = parseDays(input);

            if (days != null) {
                return days;
            }

            System.out.println("Invalid input! Please enter valid days separated by commas.");
            System.out.println("Example: Monday, Wednesday, Friday or Mon, Wed, Fri");
        }
    }

    // Show fitness goal options
    private int readFitnessGoal() {
        System.out.println("\nSelect your fitness goal:");
        System.out.println("  1. Weight Loss");
        System.out.println("  2. Muscle Gain");
        System.out.println("  3. Improve Strength");
        System.out.println("  4. Overall Fitness");
        return readChoice();
    }

    // Show equipment level options
    private int readEquipmentLevel() {
        System.out.println("\nSelect your available equipment:");
        System.out.println("  1. No Equipment (bodyweight / pull-up bar / resistance bands)");
        System.out.println("  2. Free Weights (dumbbells / barbell / weight bench)");
        System.out.println("  3. Machine Only (chest press / lat pull-down / treadmill)");
        System.out.println("  4. Complete Equipment (access to all types)");
        return readChoice();
    }

    // Validate numeric choice (1-4)
    private int readChoice() {
        while (true) {
            String input = scanner.nextLine().trim();

            if (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4")) {
                return Integer.parseInt(input);
            }

            System.out.println("Invalid input! Please enter a number from 1 to 4.");
        }
    }

    // Parse and validate comma-separated days, return null if invalid
    private String[] parseDays(String input) {
        if (input.isEmpty()) {
            return null;
        }

        String[] rawDays = input.split(",");
        String[] days = new String[rawDays.length];

        for (int i = 0; i < rawDays.length; i++) {
            // Convert "Mon" -> "Monday", etc.
            String day = normalizeDay(rawDays[i].trim());

            // Check for valid day name and duplicates
            if (day == null || alreadyEntered(days, day)) {
                return null;
            }

            days[i] = day;
        }

        return days;
    }

    // Check if day already exists in array
    private boolean alreadyEntered(String[] days, String day) {
        for (String savedDay : days) {
            if (day.equals(savedDay)) {
                return true;
            }
        }
        return false;
    }

    // Normalize day input (handle "Mon", "Monday", etc.)
    private String normalizeDay(String day) {
        if (day.equalsIgnoreCase("Monday") || day.equalsIgnoreCase("Mon")) return "Monday";
        if (day.equalsIgnoreCase("Tuesday") || day.equalsIgnoreCase("Tue")) return "Tuesday";
        if (day.equalsIgnoreCase("Wednesday") || day.equalsIgnoreCase("Wed")) return "Wednesday";
        if (day.equalsIgnoreCase("Thursday") || day.equalsIgnoreCase("Thu")) return "Thursday";
        if (day.equalsIgnoreCase("Friday") || day.equalsIgnoreCase("Fri")) return "Friday";
        if (day.equalsIgnoreCase("Saturday") || day.equalsIgnoreCase("Sat")) return "Saturday";
        if (day.equalsIgnoreCase("Sunday") || day.equalsIgnoreCase("Sun")) return "Sunday";
        return null;
    }

    private void printLine() {
        System.out.println("============================================================");
    }
}
