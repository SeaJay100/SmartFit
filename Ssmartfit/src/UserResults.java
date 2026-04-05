public class UserResults extends UserSetup {

    public void results() {
        GoalConfig goalConfig = new GoalConfig(getUserFitnessGoals());
        ExerciseSelector selector = new ExerciseSelector(getUserEquipments());
        RoutineSelector routineSelector = new RoutineSelector(getAvailableDaysArray(), getUserFitnessGoals());

        java.util.List<WorkoutDay> schedule = routineSelector.buildSchedule();
        String routineName = routineSelector.getAssignedRoutineName();

        ReportPrinter printer = new ReportPrinter(
            getName(),
            getAvailability(),
            goalConfig,
            selector,
            schedule,
            routineName
        );

        printer.print();
    }
}
