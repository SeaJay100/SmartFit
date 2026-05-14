import java.util.List;

// Represents a single day in the workout schedule
public class WorkoutDay {

    private final String dayName;          // e.g., "Monday"
    private final String sessionLabel;     // e.g., "Push", "Pull", "REST"
    private final List<String> movements;  // Movements to perform

    public WorkoutDay(String dayName, String sessionLabel, List<String> movements) {
        this.dayName = dayName;
        this.sessionLabel = sessionLabel;
        this.movements = movements;
    }

    public String getDayName() {
        return dayName;
    }

    public String getSessionLabel() {
        return sessionLabel;
    }

    public List<String> getMovements() {
        return movements;
    }

    // Check if this day is a rest day
    public boolean isRest() {
        return sessionLabel.equalsIgnoreCase("REST");
    }
}
