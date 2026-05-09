public class Main {
    public static void main(String[] args) {
        UserSetup setup = new UserSetup();
        User user = setup.createUser();

        GoalProfile goal = GoalConfig.fromChoice(user.getFitnessGoal());
        ExerciseSelector exercises = new ExerciseSelector(user.getEquipmentLevel());
        RoutineSelector routine = new RoutineSelector(user.getAvailableDays(), user.getFitnessGoal());

        ReportPrinter printer = new ReportPrinter(
            user.getName(),
            goal,
            exercises,
            routine.buildSchedule(),
            routine.getAssignedRoutineName()
        );

        printer.print();
    }
}
