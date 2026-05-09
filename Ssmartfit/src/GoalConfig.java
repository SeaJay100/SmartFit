public class GoalConfig {

    public static GoalProfile createGoal(int goal) {
        if (goal == 1) {
            return new WeightLossGoal();
        }

        if (goal == 2) {
            return new MuscleGainGoal();
        }

        if (goal == 3) {
            return new StrengthGoal();
        }

        return new OverallFitnessGoal();
    }
}
