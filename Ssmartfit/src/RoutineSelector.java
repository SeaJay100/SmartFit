import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RoutineSelector {

    private static final String[] WEEK = {
        "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
    };

    private static final List<String> FULL_BODY = Arrays.asList(
        "Horizontal Push", "Vertical Push", "Horizontal Pull", "Vertical Pull",
        "Leg Pressing", "Hip Hinge", "Biceps", "Triceps",
        "Side Delts", "Calves", "Core (Upper Abs)", "Core (Lower Abs)"
    );

    private static final List<String> FULL_BODY_LEAN = Arrays.asList(
        "Horizontal Push", "Vertical Push", "Horizontal Pull", "Vertical Pull",
        "Leg Pressing", "Hip Hinge", "Calves", "Core (Upper Abs)", "Core (Lower Abs)"
    );

    private static final List<String> FULL_BODY_A = Arrays.asList(
        "Horizontal Push", "Vertical Pull", "Leg Pressing", "Hip Hinge",
        "Triceps", "Side Delts", "Core (Upper Abs)"
    );

    private static final List<String> FULL_BODY_B = Arrays.asList(
        "Incline Push", "Horizontal Pull", "Glutes", "Hamstrings",
        "Biceps", "Rear Delts", "Core (Lower Abs)"
    );

    private static final List<String> UPPER = Arrays.asList(
        "Horizontal Push", "Incline Push", "Vertical Push",
        "Horizontal Pull", "Vertical Pull",
        "Biceps", "Triceps", "Side Delts", "Rear Delts"
    );

    private static final List<String> LOWER = Arrays.asList(
        "Leg Pressing", "Quads", "Hip Hinge", "Hamstrings",
        "Calves", "Core (Upper Abs)", "Core (Lower Abs)"
    );

    private static final List<String> PUSH = Arrays.asList(
        "Horizontal Push", "Incline Push", "Vertical Push", "Triceps", "Side Delts"
    );

    private static final List<String> PULL = Arrays.asList(
        "Horizontal Pull", "Vertical Pull", "Rear Delts", "Biceps"
    );

    private static final List<String> LEGS = Arrays.asList(
        "Leg Pressing", "Quads", "Hip Hinge", "Hamstrings",
        "Calves", "Core (Upper Abs)", "Core (Lower Abs)"
    );

    private final String[] availableDays;
    private final int goal;
    private String assignedRoutineName;

    public RoutineSelector(String[] availableDays, int goal) {
        this.availableDays = sortDays(availableDays);
        this.goal = goal;
    }

    public String getAssignedRoutineName() {
        return assignedRoutineName;
    }

    public List<WorkoutDay> buildSchedule() {
        String[] routineLabels = chooseRoutine();
        List<WorkoutDay> week = new ArrayList<>();
        int routineIndex = 0;

        for (String day : WEEK) {
            if (isAvailable(day) && routineIndex < routineLabels.length) {
                String label = routineLabels[routineIndex];
                week.add(new WorkoutDay(day, label, getMovements(label)));
                routineIndex++;
            } else {
                week.add(new WorkoutDay(day, "REST", Collections.emptyList()));
            }
        }

        return week;
    }

    private String[] chooseRoutine() {
        int days = availableDays.length;

        if (days >= 6) {
            assignedRoutineName = "6-Day Push / Pull / Legs";
            return new String[] {"Push", "Pull", "Legs", "Push", "Pull", "Legs"};
        }

        if (days == 5) {
            assignedRoutineName = "5-Day Push / Pull / Legs + Upper / Lower";
            return new String[] {"Push", "Pull", "Legs", "Upper", "Lower"};
        }

        if (days == 4) {
            assignedRoutineName = "4-Day Upper / Lower Split";
            return new String[] {"Upper", "Lower", "Upper", "Lower"};
        }

        if (days == 3) {
            assignedRoutineName = "3-Day Full Body Split";
            return new String[] {"Full Body", "Full Body", "Full Body"};
        }

        if (days == 2) {
            assignedRoutineName = "2-Day Full Body A / B";
            return new String[] {"Full Body A", "Full Body B"};
        }

        assignedRoutineName = "1-Day Full Body";
        return new String[] {"Full Body"};
    }

    private List<String> getMovements(String label) {
        if (label.equals("Push")) return leanVersion(PUSH);
        if (label.equals("Pull")) return leanVersion(PULL);
        if (label.equals("Legs")) return LEGS;
        if (label.equals("Upper")) return leanVersion(UPPER);
        if (label.equals("Lower")) return LOWER;
        if (label.equals("Full Body A")) return leanVersion(FULL_BODY_A);
        if (label.equals("Full Body B")) return leanVersion(FULL_BODY_B);
        if (goal == 1 || goal == 4) return FULL_BODY_LEAN;
        return FULL_BODY;
    }

    private List<String> leanVersion(List<String> movements) {
        if (goal != 1 && goal != 4) {
            return movements;
        }

        List<String> result = new ArrayList<>();
        for (String movement : movements) {
            if (!movement.equals("Biceps")
                && !movement.equals("Triceps")
                && !movement.equals("Side Delts")
                && !movement.equals("Rear Delts")) {
                result.add(movement);
            }
        }
        return result;
    }

    private boolean isAvailable(String day) {
        for (String availableDay : availableDays) {
            if (day.equals(availableDay)) {
                return true;
            }
        }
        return false;
    }

    private String[] sortDays(String[] days) {
        String[] sorted = days.clone();

        for (int i = 0; i < sorted.length - 1; i++) {
            for (int j = i + 1; j < sorted.length; j++) {
                if (dayNumber(sorted[i]) > dayNumber(sorted[j])) {
                    String temp = sorted[i];
                    sorted[i] = sorted[j];
                    sorted[j] = temp;
                }
            }
        }

        return sorted;
    }

    private int dayNumber(String day) {
        for (int i = 0; i < WEEK.length; i++) {
            if (WEEK[i].equals(day)) {
                return i;
            }
        }
        return WEEK.length;
    }
}
