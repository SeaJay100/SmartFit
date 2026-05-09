import java.util.List;

public class ReportPrinter {

    private final String name;
    private final GoalProfile goal;
    private final ExerciseProvider exercises;
    private final List<WorkoutDay> schedule;
    private final String routineName;

    public ReportPrinter(String name,
                         GoalProfile goal, ExerciseProvider exercises,
                         List<WorkoutDay> schedule, String routineName) {
        this.name = name;
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
        System.out.println("Goal       : " + goal.getLabel());
        System.out.println("Routine    : " + routineName);
        System.out.println("Sets       : " + goal.getSets());
        System.out.println("Reps       : " + goal.getRepRange());
        System.out.println("Cardio     : " + (goal.hasCardio() ? "Yes" : "No"));
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

            if (goal.hasCardio()) {
                String cardio = exercises.get("Cardio");
                System.out.println("  " + count + ". " + cardio + " - 10-15 min");
            }

            System.out.println();
        }
    }

    private void printUserNote() {
        System.out.println("------------------------------------------------------------");
        System.out.println("Note: " + goal.getGoalNote());

        String scheduleNote = goal.getScheduleNote();
        if (scheduleNote != null) {
            System.out.println();
            System.out.println(scheduleNote);
        }

        System.out.println("------------------------------------------------------------");
    }
}
