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
        setUserFitnessGoals();
    }

    public void equipmentLevel() {
        System.out.println("\nSelect your available equipment:");
        System.out.println("  1. No Equipment (bodyweight / pull-up bar / resistance bands)");
        System.out.println("  2. Free Weights (dumbbells / barbell / weight bench)");
        System.out.println("  3. Machine Only (chest press / lat pulldown / treadmill");
        System.out.println("  4. Complete Equipment (access to all types)");
        setUserEquipments();
    }
}