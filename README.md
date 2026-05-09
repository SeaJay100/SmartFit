# SmartFit

SmartFit is a simple Java console system that creates a weekly workout plan based on:

- User name
- Available workout days
- Fitness goal
- Available equipment

## Main Modules

- `Main` - starts the program
- `User` - stores and validates user input
- `UserSetup` - asks questions and connects the system flow
- `GoalConfig` - creates the selected goal object
- `GoalProfile` - abstract class for all fitness goals
- `WeightLossGoal`, `MuscleGainGoal`, `StrengthGoal`, `OverallFitnessGoal` - specific goal classes
- `ExerciseProvider` - interface for exercise selection
- `RoutineSelector` - builds the weekly workout schedule
- `ExerciseSelector` - chooses exercises based on equipment
- `ReportPrinter` - displays the final workout plan
- `WorkoutDay` - represents one day in the weekly schedule
