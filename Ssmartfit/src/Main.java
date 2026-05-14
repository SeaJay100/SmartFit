// Main entry point - orchestrates the workout generation process
public class Main {
    public static void main(String[] args) {
        // Collect user preferences
        UserSetup setup = new UserSetup();
        User user = setup.createUser();

        // Get training parameters based on fitness goal
        GoalProfile goal = GoalConfig.fromChoice(user.getFitnessGoal());
        
        // Map movements to exercises based on equipment level
        ExerciseSelector exercises = new ExerciseSelector(user.getEquipmentLevel());
        
        // Generate personalized weekly schedule
        RoutineSelector routine = new RoutineSelector(user.getAvailableDays(), user.getFitnessGoal());

        // Format and print the workout plan
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
