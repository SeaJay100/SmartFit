// Interface for getting specific exercises based on movement type
public interface ExerciseProvider {
    // Return specific exercise for the given movement pattern
    String get(String movement);
}
