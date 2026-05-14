// Abstract base class for fitness goals - defines training parameters
public abstract class GoalProfile {

    public abstract String getLabel();

    // Number of sets per exercise
    public abstract int getSets();

    // Rep range for this goal (e.g., "8-12")
    public abstract String getRepRange();

    // Whether to include cardio
    public abstract boolean hasCardio();

    // Advice for this goal
    public abstract String getGoalNote();

    // Optional schedule advice
    public String getScheduleNote() {
        return null;
    }
}
