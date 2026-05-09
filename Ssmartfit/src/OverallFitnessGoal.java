public class OverallFitnessGoal extends GoalProfile {

    @Override
    public String getLabel() {
        return "Overall Fitness";
    }

    @Override
    public int getSets() {
        return 3;
    }

    @Override
    public String getRepRange() {
        return "10-12";
    }

    @Override
    public boolean hasCardio() {
        return true;
    }

    @Override
    public String getGoalNote() {
        return "Balance strength exercises with simple cardio for general fitness.";
    }

    @Override
    public String getScheduleNote() {
        return "For overall fitness, keep at least one full rest day each week.";
    }
}
