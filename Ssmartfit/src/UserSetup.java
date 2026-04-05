import java.util.InputMismatchException;

public class UserSetup extends User {

    public void userSetup() {
        System.out.println("═".repeat(60));
        System.out.println("  WELCOME TO YOUR PERSONALIZED WORKOUT GENERATOR");
        System.out.println("═".repeat(60));

        System.out.println("How should we address you? (Enter your name)");
        setName();

        System.out.println("\nEnter the days you are available (comma-separated)");
        System.out.println("  Example: Monday, Wednesday, Friday");
        System.out.println("  Or short: Mon, Wed, Fri");
        setAvailability();

        fitnessGoals();
        equipmentLevel();
    }

    public void fitnessGoals() {
        System.out.println("\nSelect your fitness goal:");
        System.out.println("  1. Weight Loss");
        System.out.println("  2. Muscle Gain");
        System.out.println("  3. Improve Strength");
        System.out.println("  4. Overall Fitness");
        while (true) {
            try {
                setUserFitnessGoals();
                int choice = getUserFitnessGoals();
                if (choice >= 1 && choice <= 4) {
                    break;
                }
                System.out.println("Please enter a number from 1 to 4.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number (1-4).");
                sc.nextLine();
            }
        }
    }

    public void equipmentLevel() {
        System.out.println("\nSelect your available equipment:");
        System.out.println("  1. No Equipment (bodyweight / pull-up bar / resistance bands)");
        System.out.println("  2. Free Weights (dumbbells / barbell / weight bench)");
        System.out.println("  3. Machine Only (chest press / lat pull-down / treadmill");
        System.out.println("  4. Complete Equipment (access to all types)");
        while (true) {
            try {
                setUserEquipments();
                int choice = getUserEquipments();
                if (choice >= 1 && choice <= 4) {
                    break;
                }
                System.out.println("Please enter a number from 1 to 4.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number (1-4).");
                sc.nextLine();
            }
        }
    }
}