public class GoalConfig {

    private final int goal;

    public GoalConfig(int goal) {
        this.goal = goal;
    }

    public String getRepRange() {
        switch (goal) {
            case 1: return "12–15";
            case 2: return "8–10";
            case 3: return "3–6";
            case 4: return "8–12";
            default: return "8–12";
        }
    }

    public int getSets() {
        return 2; // Fixed for all goals per spec
    }

    public boolean includesCardio() {
        return goal == 1 || goal == 4;
    }

    public String getGoalNote() {
        switch (goal) {
            case 1: return "Include cardio and focus on higher repetitions to improve calorie burn and endurance.";
            case 2: return "Focus on controlled movements and moderate repetitions to support muscle growth.";
            case 3: return "Use heavier loads with lower repetitions to build maximum strength.";
            case 4: return "Maintain a balanced routine with moderate repetitions and include some cardio for endurance.";
            default: return "";
        }
    }

    public String getGoalLabel() {
        switch (goal) {
            case 1: return "Weight Loss";
            case 2: return "Muscle Gain";
            case 3: return "Strength";
            case 4: return "Overall Fitness";
            default: return "Unknown";
        }
    }
    public String getScheduleNote(int trainingDays) {
        if (trainingDays == 1) {
            return "Training once a week is a great starting point, especially if you have a busy schedule. " +
                "However, progress may be slower compared to training multiple times per week. " +
                "If your goal is to build muscle, lose weight, or gain strength faster, consider increasing " +
                "your workout days when possible. Consistency matters most, start with what you can handle " +
                "and improve over time.";
        } else if (trainingDays == 2) {
            return "Training twice a week is a solid and effective routine. It allows enough recovery while " +
                "still helping you build strength and improve fitness. For faster progress, you may consider " +
                "increasing your training days in the future, but this is already a strong and sustainable setup.";
        }
        return null; // no schedule note for 3+ days
    }
}

