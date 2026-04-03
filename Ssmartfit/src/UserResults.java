public class UserResults extends UserSetup {

    public void results() {
        System.out.println("-------RESULTS-------");
        System.out.println("Name: " + getName());
        System.out.println("Available Days: " + getAvailability());
        System.out.println("Fitness Goals: " + fitnessGoalLabel(getUserFitnessGoals()));
        System.out.println("Equipment Level: " + equipmentLabel(getUserEquipments()));
        System.out.println("Selected Routine: " + routineLabel());
        System.out.println("---------------------");
    }

    private String fitnessGoalLabel(int choice) {
        switch (choice) {
            case 1:
                return "Weight Loss";
            case 2:
                return "Muscle Gain";
            case 3:
                return "Maintain Overall Fitness";
            default:
                return "Not Selected";
        }
    }

    private String equipmentLabel(int choice) {
        switch (choice) {
            case 1:
                return "No Equipments";
            case 2:
                return "Free Weights";
            case 3:
                return "Machine Only";
            case 4:
                return "Complete Equipments";
            default:
                return "Unknown";
        }
    }


    private String routineLabel() {
        int days = getAvailableDaysArray().length;
        if (days < 3) {
            return "Full Body Routine (matched to your schedule)";
        }
        switch (getUserRoutine()) {
            case 1:
                return "The PPL Split (Push, Pull, Legs)";
            case 2:
                return "Full Body Routine";
            case 3:
                return "Upper / Lower Split";
            case 4:
                return "The Bro Split (Body Part Split)";
            case 5:
                return "Hybrid Splits";
            default:
                return "Not Selected";
        }
    }
}
