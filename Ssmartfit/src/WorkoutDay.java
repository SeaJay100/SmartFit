import java.util.List;

public class WorkoutDay {

    private final String dayName;
    private final String sessionLabel;
    private final List<String> movements;

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

    public boolean isRest() {
        return sessionLabel.equalsIgnoreCase("REST");
    }
}
