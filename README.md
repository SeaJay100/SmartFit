# SmartFit

SmartFit is a simple Java console system that creates a weekly workout plan based on:

- User name
- Available workout days
- Fitness goal
- Available equipment

## Main Modules

- `Main` - starts the program
- `User` - stores the user's information
- `UserSetup` - asks questions and validates user input
- `GoalConfig` - selects the correct goal object
- `GoalProfile` - abstract class for all fitness goals
- `WeightLossGoal`, `MuscleGainGoal`, `StrengthGoal`, `OverallFitnessGoal` - goal classes
- `ExerciseProvider` - interface for exercise selection
- `RoutineSelector` - builds the weekly workout schedule
- `ExerciseSelector` - chooses exercises based on equipment
- `ReportPrinter` - displays the final workout plan
- `WorkoutDay` - represents one day in the weekly schedule
