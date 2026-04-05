import java.util.*;

public abstract class User {

   static Scanner sc = new Scanner(System.in);

    private String userName;
    private String userAvailableDays;
    private int userFitnessGoals;
    private int userRoutine;
    private int userEquipments;

    //Handles Name
    public String setName() {
        this.userName = sc.nextLine();
        if (userName.isEmpty() || userName.isBlank()) {
            userName = "NoName";
        }
        return null;
    }

    public String getName() {
        return userName;
    }

    //Handles Available Days
    public void setAvailability(){
        while(true) {
            this.userAvailableDays = sc.nextLine().trim();

            if (isValidDays(userAvailableDays)) {
                break;
            } else {
                System.out.println("Invalid input! Please enter days separated by commas (e.g., Monday,Wednesday,Friday)");
                System.out.println("Or Mon, Fri, Sat");
            }
        }
    }

    public String getAvailability(){
        return userAvailableDays;
    }

    //Handles available days validation
    public boolean isValidDays(String input) {
        Set<String> validDays = new HashSet<>(Arrays.asList(
                "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday",
                "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"));

        String[] days = input.split(",");
        Set<String> seenDays = new HashSet<>();
        
        for (String day : days) {
            String trimmedDay = day.trim();
            if (!validDays.contains(trimmedDay)) {
                return false;
            }
            if (!seenDays.add(trimmedDay)) {
                return false; // Duplicate found
            }
        }
        return true;
    }

    //Stores available days
    public String[] getAvailableDaysArray() {
        String[] days = userAvailableDays.split(",");
        String[] trimmedDays = new String[days.length];
        for (int i = 0; i < days.length; i++) {
            trimmedDays[i] = days[i].trim();
        }
        return trimmedDays;
    }

    //Handles FitnessGoals
    public void setUserFitnessGoals() {
        this.userFitnessGoals = sc.nextInt();
    }

    public int getUserFitnessGoals() {
        return userFitnessGoals;
    }

    //Handles Routines
    public void setUserRoutine() {
        this.userRoutine = sc.nextInt();
    }

    public int getUserRoutine() {
        return userRoutine;
    }

    //Handles Equipments
    public int setUserEquipments() {
        this.userEquipments = sc.nextInt();
        return 0;
    }
    public int getUserEquipments() {
        return userEquipments;
    }

}