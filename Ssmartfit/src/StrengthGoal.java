// Training for strength: low reps, high weight, long rest, no cardio
public class StrengthGoal extends GoalProfile {

    @Override
    public String getLabel() {
        return "Improve Strength";
    }

    // 5 sets with heavy weight and full recovery
    @Override
    public int getSets() {
        return 5;
    }

    // Low reps allows for heavy loads
    @Override
    public String getRepRange() {
        return "4-6";
    }

    @Override
    public boolean hasCardio() {
        return false;
    }

    @Override
    public String getGoalNote() {
        return "Use longer rest times and focus on controlled heavy sets.";
    }
}
