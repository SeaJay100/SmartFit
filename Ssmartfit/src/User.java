// Stores user's fitness preferences (immutable)
public class User {

    private final String name;
    private final String[] availableDays;
    // Goal: 1=Weight Loss, 2=Muscle Gain, 3=Strength, 4=Overall Fitness
    private final int fitnessGoal;
    // Equipment: 1=No Equipment, 2=Free Weights, 3=Machines, 4=Complete
    private final int equipmentLevel;

    public User(String name, String[] availableDays, int fitnessGoal, int equipmentLevel) {
        this.name = name;
        this.availableDays = availableDays;
        this.fitnessGoal = fitnessGoal;
        this.equipmentLevel = equipmentLevel;
    }

    public String getName() {
        return name;
    }

    public String[] getAvailableDays() {
        return availableDays;
    }

    public int getFitnessGoal() {
        return fitnessGoal;
    }

    public int getEquipmentLevel() {
        return equipmentLevel;
    }
}
