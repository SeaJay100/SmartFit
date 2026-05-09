public class WeightLossGoal extends GoalProfile {

    @Override
    public String getLabel() {
        return "Weight Loss";
    }

    @Override
    public int getSets() {
        return 3;
    }

    @Override
    public String getRepRange() {
        return "12-15";
    }

    @Override
    public boolean hasCardio() {
        return true;
    }

    @Override
    public String getGoalNote() {
        return "Use shorter rest times and keep your workout moving.";
    }

    @Override
    public String getScheduleNote() {
        return "For weight loss, try to stay active on rest days with light walking.";
    }
}
