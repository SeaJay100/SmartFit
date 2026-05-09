public class StrengthGoal extends GoalProfile {

    @Override
    public String getLabel() {
        return "Improve Strength";
    }

    @Override
    public int getSets() {
        return 5;
    }

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
