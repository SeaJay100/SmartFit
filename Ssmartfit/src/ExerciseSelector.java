public class ExerciseSelector {

    private final int equipment;

    public ExerciseSelector(int equipment) {
        this.equipment = equipment;
    }

    public String get(String movement) {
        switch (movement) {

            // ── UPPER BODY ──────────────────────────────────────────────────
            case "Horizontal Push":
                switch (equipment) {
                    case 1: return "Push-ups";
                    case 2: return "Barbell Bench Press";
                    case 3: return "Chest Press Machine";
                    case 4: return "Dumbbell Flat Press";
                }

            case "Incline Push":
                switch (equipment) {
                    case 1: return "Decline Push-ups";
                    case 2: return "Incline Dumbbell Press";
                    case 3: return "Incline Chest Press Machine";
                    case 4: return "Incline Dumbbell Press";
                }

            case "Vertical Push":
                switch (equipment) {
                    case 1: return "Pike Push-ups";
                    case 2: return "Dumbbell/Barbell Shoulder Press";
                    case 3: return "Shoulder Press Machine";
                    case 4: return "Arnold Press";
                }

            case "Horizontal Pull":
                switch (equipment) {
                    case 1: return "Inverted Rows";
                    case 2: return "Bent-over Barbell Rows";
                    case 3: return "Seated Cable Row";
                    case 4: return "Single-arm Dumbbell Row";
                }

            case "Vertical Pull":
                switch (equipment) {
                    case 1: return "Pull-ups";
                    case 2: return "Assisted/Weighted Pull-ups";
                    case 3: return "Lat Pulldown";
                    case 4: return "Chin-ups";
                }

            case "Biceps":
                switch (equipment) {
                    case 1: return "Towel/Band Curls";
                    case 2: return "Dumbbell Curls";
                    case 3: return "Cable Curls";
                    case 4: return "Hammer Curls";
                }

            case "Triceps":
                switch (equipment) {
                    case 1: return "Dips";
                    case 2: return "Dumbbell Tricep Extension";
                    case 3: return "Cable Pushdown";
                    case 4: return "Overhead Tricep Extension";
                }

            case "Side Delts":
                switch (equipment) {
                    case 1: return "Pike Push-ups";
                    case 2: return "Dumbbell Lateral Raises";
                    case 3: return "Cable Lateral Raise";
                    case 4: return "Front Raises";
                }

            case "Rear Delts":
                switch (equipment) {
                    case 1: return "Bodyweight Reverse Fly";
                    case 2: return "Dumbbell Rear Delt Fly";
                    case 3: return "Reverse Pec Deck";
                    case 4: return "Face Pulls";
                }

            // ── LOWER BODY ──────────────────────────────────────────────────
            case "Leg Pressing":
                switch (equipment) {
                    case 1: return "Bodyweight Squats";
                    case 2: return "Barbell Squats";
                    case 3: return "Leg Press";
                    case 4: return "Hack Squat / Smith Squat";
                }

            case "Quads":
                switch (equipment) {
                    case 1: return "Sissy Squats / Bulgarian Split Squats";
                    case 2: return "Bulgarian Split Squats (Barbell/Dumbbell)";
                    case 3: return "Leg Extensions";
                    case 4: return "Leg Extensions";
                }

            case "Hip Hinge":
                switch (equipment) {
                    case 1: return "Bodyweight Romanian Deadlift / Good Mornings";
                    case 2: return "Barbell Deadlift";
                    case 3: return "Romanian Deadlift";
                    case 4: return "Romanian Deadlift";
                }

            case "Hamstrings":
                switch (equipment) {
                    case 1: return "Nordic Curl";
                    case 2: return "Romanian Deadlift";
                    case 3: return "Leg Curl Machine";
                    case 4: return "Seated Leg Curl";
                }

            case "Glutes":
                switch (equipment) {
                    case 1: return "Glute Bridge";
                    case 2: return "Barbell Hip Thrust";
                    case 3: return "Glute Machine";
                    case 4: return "Cable Kickbacks";
                }

            case "Calves":
                switch (equipment) {
                    case 1: return "Standing Calf Raises";
                    case 2: return "Weighted Calf Raises";
                    case 3: return "Seated Calf Machine";
                    case 4: return "Seated Calf Machine";
                }

            // ── CORE ────────────────────────────────────────────────────────
            case "Core (Upper Abs)":
                switch (equipment) {
                    case 1: return "Crunches";
                    case 2: return "Weighted Sit-ups";
                    case 3: return "Cable Crunch";
                    case 4: return "Machine Crunch";
                }

            case "Core (Lower Abs)":
                switch (equipment) {
                    case 1: return "Leg Raises";
                    case 2: return "Hanging Leg Raises";
                    case 3: return "Captain's Chair";
                    case 4: return "Reverse Crunch";
                }

            // ── CARDIO ──────────────────────────────────────────────────────
            case "Cardio":
                switch (equipment) {
                    case 1: return "Jumping Jacks / High Knees / Burpees";
                    case 2: return "Dumbbell Thrusters / Swings / Farmer's Walk";
                    case 3: return "Treadmill / Stationary Bike / Elliptical";
                    case 4: return "Rowing Machine / Battle Ropes / Assault Bike";
                }

            default:
                return movement + " (unrecognized)";
        }
    }
}
