import java.util.Scanner;

public class User {

    protected static final Scanner sc = new Scanner(System.in);

    private String userName;
    private String userAvailableDays;
    private int userFitnessGoals;
    private int userEquipments;

    public void setName() {
        userName = sc.nextLine().trim();
        if (userName.isBlank()) {
            userName = "NoName";
        }
    }

    public String getName() {
        return userName;
    }

    public void setAvailability() {
        while (true) {
            userAvailableDays = sc.nextLine().trim();

            if (isValidDays(userAvailableDays)) {
                return;
            }

            System.out.println("Invalid input! Please enter days separated by commas.");
            System.out.println("Example: Monday, Wednesday, Friday or Mon, Wed, Fri");
        }
    }

    public boolean isValidDays(String input) {
        if (input == null || input.isBlank()) {
            return false;
        }

        String[] days = input.split(",");
        String[] savedDays = new String[days.length];

        for (int i = 0; i < days.length; i++) {
            String day = normalizeDay(days[i].trim());
            if (day == null) {
                return false;
            }

            for (String savedDay : savedDays) {
                if (day.equals(savedDay)) {
                    return false;
                }
            }

            savedDays[i] = day;
        }

        return true;
    }

    public String[] getAvailableDaysArray() {
        String[] days = userAvailableDays.split(",");
        String[] availableDays = new String[days.length];

        for (int i = 0; i < days.length; i++) {
            availableDays[i] = normalizeDay(days[i].trim());
        }

        return availableDays;
    }

    public void setUserFitnessGoals(int value) {
        userFitnessGoals = value;
    }

    public int getUserFitnessGoals() {
        return userFitnessGoals;
    }

    public void setUserEquipments(int value) {
        userEquipments = value;
    }

    public int getUserEquipments() {
        return userEquipments;
    }

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
}
