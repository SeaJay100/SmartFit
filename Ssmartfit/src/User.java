public class User {

    private final String name;
    private final String[] availableDays;
    private final int fitnessGoal;
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
