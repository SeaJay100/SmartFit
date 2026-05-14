// Factory class - creates the appropriate goal object based on user choice
public class GoalConfig {

    // Map user choice (1-4) to corresponding goal object
    public static GoalProfile fromChoice(int goal) {
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
