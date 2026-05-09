public class ExerciseSelector implements ExerciseProvider {

    private final int equipment;

    private static final String[][] EXERCISES = {
        {"Horizontal Push", "Push-ups", "Barbell Bench Press", "Chest Press Machine", "Dumbbell Flat Press"},
        {"Incline Push", "Decline Push-ups", "Incline Dumbbell Press", "Incline Chest Press Machine", "Incline Dumbbell Press"},
        {"Vertical Push", "Pike Push-ups", "Dumbbell/Barbell Shoulder Press", "Shoulder Press Machine", "Arnold Press"},
        {"Horizontal Pull", "Inverted Rows", "Bent-over Barbell Rows", "Seated Cable Row", "Single-arm Dumbbell Row"},
        {"Vertical Pull", "Pull-ups", "Assisted/Weighted Pull-ups", "Lat Pulldown", "Chin-ups"},
        {"Biceps", "Towel/Band Curls", "Dumbbell Curls", "Cable Curls", "Hammer Curls"},
        {"Triceps", "Dips", "Dumbbell Tricep Extension", "Cable Pushdown", "Overhead Tricep Extension"},
        {"Side Delts", "Pike Push-ups", "Dumbbell Lateral Raises", "Cable Lateral Raise", "Front Raises"},
        {"Rear Delts", "Bodyweight Reverse Fly", "Dumbbell Rear Delt Fly", "Reverse Pec Deck", "Face Pulls"},
        {"Leg Pressing", "Bodyweight Squats", "Barbell Squats", "Leg Press", "Hack Squat / Smith Squat"},
        {"Quads", "Sissy Squats / Bulgarian Split Squats", "Bulgarian Split Squats", "Leg Extensions", "Leg Extensions"},
        {"Hip Hinge", "Bodyweight Romanian Deadlift", "Barbell Deadlift", "Romanian Deadlift", "Romanian Deadlift"},
        {"Hamstrings", "Nordic Curl", "Romanian Deadlift", "Leg Curl Machine", "Seated Leg Curl"},
        {"Glutes", "Glute Bridge", "Barbell Hip Thrust", "Glute Machine", "Cable Kickbacks"},
        {"Calves", "Standing Calf Raises", "Weighted Calf Raises", "Seated Calf Machine", "Seated Calf Machine"},
        {"Core (Upper Abs)", "Crunches", "Weighted Sit-ups", "Cable Crunch", "Machine Crunch"},
        {"Core (Lower Abs)", "Leg Raises", "Hanging Leg Raises", "Captain's Chair", "Reverse Crunch"},
        {"Cardio", "Jumping Jacks / High Knees / Burpees", "Dumbbell Thrusters / Swings", "Treadmill / Stationary Bike", "Rowing Machine / Battle Ropes"}
    };

    public ExerciseSelector(int equipment) {
        this.equipment = equipment;
    }

    @Override
    public String get(String movement) {
        int column = equipment;

        for (String[] exerciseRow : EXERCISES) {
            if (exerciseRow[0].equals(movement)) {
                return exerciseRow[column];
            }
        }

        return movement + " (exercise not found)";
    }
}
