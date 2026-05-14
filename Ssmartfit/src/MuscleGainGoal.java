// Training for muscle hypertrophy: moderate reps, good volume, no cardio
public class MuscleGainGoal extends GoalProfile {

    @Override
    public String getLabel() {
        return "Muscle Gain";
    }

    // 4 sets provides good hypertrophy volume
    @Override
    public int getSets() {
        return 4;
    }

    // 8-12 reps is the hypertrophy sweet spot
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
