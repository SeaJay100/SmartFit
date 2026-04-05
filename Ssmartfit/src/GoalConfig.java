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
}