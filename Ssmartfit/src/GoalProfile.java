public abstract class GoalProfile {

    public abstract String getLabel();

    public abstract int getSets();

    public abstract String getRepRange();

    public abstract boolean hasCardio();

    public abstract String getGoalNote();

    public String getScheduleNote() {
        return null;
    }
}
