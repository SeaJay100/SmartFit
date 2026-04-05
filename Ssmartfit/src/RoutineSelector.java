import java.util.*;

public class RoutineSelector {

    // Canonical day order for the weekly schedule output
    private static final String[] WEEK = {
        "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
    };

    // Normalize short forms ("Mon" → "Monday", etc.)
    private static final Map<String, String> SHORT_TO_FULL = new HashMap<>();
    static {
        SHORT_TO_FULL.put("Sun", "Sunday");
        SHORT_TO_FULL.put("Mon", "Monday");
        SHORT_TO_FULL.put("Tue", "Tuesday");
        SHORT_TO_FULL.put("Wed", "Wednesday");
        SHORT_TO_FULL.put("Thu", "Thursday");
        SHORT_TO_FULL.put("Fri", "Friday");
        SHORT_TO_FULL.put("Sat", "Saturday");
    }

    private final Set<String> availableDays;
    private final int goal;
    private String assignedRoutineName;

    public RoutineSelector(String[] rawDays, int goal) {
        this.goal = goal;
        this.availableDays = normalize(rawDays);
    }

    // Expand short names to full names
    private Set<String> normalize(String[] raw) {
        Set<String> result = new LinkedHashSet<>();
        for (String d : raw) {
            String trimmed = d.trim();
            result.add(SHORT_TO_FULL.getOrDefault(trimmed, trimmed));
        }
        return result;
    }

    public String getAssignedRoutineName() {
        return assignedRoutineName;
    }

    // ── Movement templates ──────────────────────────────────────────────────

    private static final List<String> FULL_BODY = Arrays.asList(
        "Horizontal Push", "Vertical Push", "Horizontal Pull", "Vertical Pull",
        "Leg Pressing", "Hip Hinge", "Biceps", "Triceps",
        "Side Delts", "Calves", "Core (Upper Abs)", "Core (Lower Abs)"
    );

    // Weight-loss / overall fitness strip isolation movements
    private static final List<String> FULL_BODY_LEAN = Arrays.asList(
        "Horizontal Push", "Vertical Push", "Horizontal Pull", "Vertical Pull",
        "Leg Pressing", "Hip Hinge", "Calves", "Core (Upper Abs)", "Core (Lower Abs)"
    );

    private static final List<String> FB_A = Arrays.asList(
        "Horizontal Push", "Vertical Pull", "Leg Pressing", "Hip Hinge",
        "Triceps", "Side Delts", "Core (Upper Abs)"
    );

    private static final List<String> FB_B = Arrays.asList(
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

    // Lean versions (Weight Loss / Overall Fitness) drop isolation
    private List<String> leanVersion(List<String> base) {
        if (goal == 1 || goal == 4) {
            List<String> lean = new ArrayList<>(base);
            lean.removeAll(Arrays.asList("Biceps", "Triceps", "Side Delts", "Rear Delts"));
            return lean;
        }
        return base;
    }

    // ── Main entry point ─────────────────────────────────────────────────

    public List<WorkoutDay> buildSchedule() {
        int count = availableDays.size();

        if (count >= 6) return try6Day();
        if (count == 5) return try5Day();
        if (count == 4) return try4Day();
        if (count == 3) return try3Day();
        if (count == 2) return try2Day();
        return try1Day();
    }

    // ── 6-Day: PPL × 2  (Push-Pull-Legs-REST-Push-Pull-Legs) ────────────
    private List<WorkoutDay> try6Day() {
        // Strict schedule needs Mon–Sat (6 consecutive) or similar
        // Pattern: slot0=Push slot1=Pull slot2=Legs slot3=Rest slot4=Push slot5=Pull slot6=Legs
        String[] pattern = {"Push", "Pull", "Legs", "REST", "Push", "Pull", "Legs"};
        List<String>[] templates = new List[]{
            leanVersion(PUSH), leanVersion(PULL), LEGS, null,
            leanVersion(PUSH), leanVersion(PULL), LEGS
        };
        assignedRoutineName = "6-Day Push / Pull / Legs × 2";
        return mapPatternToWeek(pattern, templates);
    }

    // ── 5-Day: PPL + Upper/Lower  (P-P-L-Rest-U-L-Rest) ─────────────────
    private List<WorkoutDay> try5Day() {
        String[] pattern = {"Push", "Pull", "Legs", "REST", "Upper", "Lower", "REST"};
        List<String>[] templates = new List[]{
            leanVersion(PUSH), leanVersion(PULL), LEGS, null,
            leanVersion(UPPER), LOWER, null
        };
        assignedRoutineName = "5-Day Push / Pull / Legs + Upper / Lower";
        return mapPatternToWeek(pattern, templates);
    }

    // ── 4-Day: Upper / Lower  (Upper-Lower-REST-Upper-Lower-REST-REST) ───
    private List<WorkoutDay> try4Day() {
        String[] pattern = {"Upper", "Lower", "REST", "Upper", "Lower", "REST", "REST"};
        List<String>[] templates = new List[]{
            leanVersion(UPPER), LOWER, null,
            leanVersion(UPPER), LOWER, null, null
        };
        assignedRoutineName = "4-Day Upper / Lower Split";
        return mapPatternToWeek(pattern, templates);
    }

    // ── 3-Day: Full Body  (FB-REST-FB-REST-FB-REST-REST) ─────────────────
    private List<WorkoutDay> try3Day() {
        String[] pattern = {"Full Body", "REST", "Full Body", "REST", "Full Body", "REST", "REST"};
        List<String> fbMoves = (goal == 1 || goal == 4) ? FULL_BODY_LEAN : FULL_BODY;
        List<String>[] templates = new List[]{
            fbMoves, null, fbMoves, null, fbMoves, null, null
        };
        assignedRoutineName = "3-Day Full Body Split";
        return mapPatternToWeek(pattern, templates);
    }

    // ── 2-Day: Full Body A / B  (flexible placement) ─────────────────────
    private List<WorkoutDay> try2Day() {
        assignedRoutineName = "2-Day Full Body A / B";
        // Place A and B on the two available days; rest on all others
        List<WorkoutDay> week = new ArrayList<>();
        List<String> avList = new ArrayList<>(availableDays);

        // Sort available days into week order
        avList.sort(Comparator.comparingInt(d -> Arrays.asList(WEEK).indexOf(d)));

        String dayA = avList.size() > 0 ? avList.get(0) : null;
        String dayB = avList.size() > 1 ? avList.get(1) : null;

        for (String day : WEEK) {
            if (day.equals(dayA)) {
                week.add(new WorkoutDay(day, "Full Body A", leanVersion(FB_A)));
            } else if (day.equals(dayB)) {
                week.add(new WorkoutDay(day, "Full Body B", leanVersion(FB_B)));
            } else {
                week.add(new WorkoutDay(day, "REST", Collections.emptyList()));
            }
        }
        return week;
    }

    // ── 1-Day: Full Body  ─────────────────────────────────────────────────
    private List<WorkoutDay> try1Day() {
        assignedRoutineName = "1-Day Full Body";
        List<String> fbMoves = (goal == 1 || goal == 4) ? FULL_BODY_LEAN : FULL_BODY;
        List<WorkoutDay> week = new ArrayList<>();
        String trainingDay = availableDays.isEmpty() ? "Monday" : availableDays.iterator().next();

        for (String day : WEEK) {
            if (day.equals(trainingDay)) {
                week.add(new WorkoutDay(day, "Full Body", fbMoves));
            } else {
                week.add(new WorkoutDay(day, "REST", Collections.emptyList()));
            }
        }
        return week;
    }

    // ── Pattern mapper ────────────────────────────────────────────────────
    // Tries to fit the pattern into the user's available days.
    // If an available day falls on a REST slot → replace that slot with REST and
    // attempt to shift. If the structure is too broken → downgrade automatically.

    @SuppressWarnings("unchecked")
    private List<WorkoutDay> mapPatternToWeek(String[] pattern, List<String>[] templates) {

        // We have 7 pattern slots and 7 week days.
        // Strategy: anchor pattern slot 0 to the first available day (in week order),
        // then assign subsequent slots in order, inserting REST wherever unavailable.

        List<String> avSorted = new ArrayList<>(availableDays);
        avSorted.sort(Comparator.comparingInt(d -> Arrays.asList(WEEK).indexOf(d)));

        // Count required training days in pattern
        int requiredTraining = 0;
        for (String s : pattern) if (!s.equals("REST")) requiredTraining++;

        // If user has fewer available days than required training slots → downgrade
        if (avSorted.size() < requiredTraining) {
            return downgrade();
        }

        // Build week: assign pattern slots in order to available days;
        // fill gaps with REST
        List<WorkoutDay> week = new ArrayList<>();
        int avIdx = 0;
        int patternIdx = 0;

        for (String day : WEEK) {
            if (avIdx < avSorted.size() && day.equals(avSorted.get(avIdx)) && patternIdx < pattern.length) {
                // Skip any REST slots in the pattern (they get auto-filled)
                while (patternIdx < pattern.length && pattern[patternIdx].equals("REST")) {
                    patternIdx++;
                }
                if (patternIdx < pattern.length) {
                    week.add(new WorkoutDay(day, pattern[patternIdx], templates[patternIdx]));
                    patternIdx++;
                    avIdx++;
                } else {
                    week.add(new WorkoutDay(day, "REST", Collections.emptyList()));
                }
            } else {
                week.add(new WorkoutDay(day, "REST", Collections.emptyList()));
            }
        }

        return week;
    }

    // Downgrade to next lower routine
    private List<WorkoutDay> downgrade() {
        int count = availableDays.size();
        if (count >= 5) return try5Day();
        if (count >= 4) return try4Day();
        if (count >= 3) return try3Day();
        if (count >= 2) return try2Day();
        return try1Day();
    }
}
