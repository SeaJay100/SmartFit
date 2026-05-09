public class MuscleGainGoal extends GoalProfile {

    @Override
    public String getLabel() {
        return "Muscle Gain";
    }

    @Override
    public int getSets() {
        return 4;
    }

    @Override
    public String getRepRange() {
        return "8-12";
    }

    @Override
    public boolean hasCardio() {
        return false;
    }

    @Override
    public String getGoalNote() {
        return "Focus on good form and slowly increase the weight when exercises feel easy.";
    }
}
