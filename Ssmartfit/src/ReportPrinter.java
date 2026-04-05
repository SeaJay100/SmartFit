import java.util.List;

public class ReportPrinter {

    private final String name;
    private final String availabilityRaw;
    private final GoalConfig goal;
    private final ExerciseSelector exercises;
    private final List<WorkoutDay> schedule;
    private final String routineName;

    public ReportPrinter(String name, String availabilityRaw,
                         GoalConfig goal, ExerciseSelector exercises,
                         List<WorkoutDay> schedule, String routineName) {
        this.name = name;
        this.availabilityRaw = availabilityRaw;
        this.goal = goal;
        this.exercises = exercises;
        this.schedule = schedule;
        this.routineName = routineName;
    }

    public void print() {
        printHeader();
        printSchedule();
        printUserNote();
    }

    private void printHeader() {
        System.out.println("------------------------------------------------------------");
        System.out.println("Name       : " + name);
        System.out.println("Goal       : " + goal.getGoalLabel());
        System.out.println("Routine    : " + routineName);
        System.out.println("Sets       : " + goal.getSets());
        System.out.println("Reps       : " + goal.getRepRange());
        System.out.println("Cardio     : " + (goal.includesCardio() ? "Yes" : "No"));
        System.out.println("------------------------------------------------------------");
    }

    private void printSchedule() {
        System.out.println();

        for (WorkoutDay day : schedule) {
            if (day.isRest()) {
                System.out.println(day.getDayName() + " - Rest");
                System.out.println();
                continue;
            }

            System.out.println(day.getDayName() + " - " + day.getSessionLabel());

            int count = 1;
            for (String movement : day.getMovements()) {
                String exercise = exercises.get(movement);
                System.out.println("  " + count + ". " + exercise
                        + " - " + goal.getSets() + " sets x " + goal.getRepRange() + " reps");
                count++;
            }

            if (goal.includesCardio()) {
                String cardio = exercises.get("Cardio");
                System.out.println("  " + count + ". " + cardio + " - 10-15 min");
            }

            System.out.println();
        }
    }

    private void printUserNote() {
        System.out.println("------------------------------------------------------------");
        System.out.println("Note: " + goal.getGoalNote());
        System.out.println("------------------------------------------------------------");
    }
}
