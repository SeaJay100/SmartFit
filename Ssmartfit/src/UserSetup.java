public class UserSetup extends User{

    public void userSetup(){
        while(true){
            System.out.println("WELCOME!\n" + "How should we address you? (Enter your name)");
            setName();

            System.out.println("Enter the days you are available (Must be separated by comma (,))");
            System.out.println("Ex. Monday, Friday, Saturday");
            System.out.println("Or Mon, Fri, Sat");
            setAvailability();

            fitnessGoals();

            System.out.println("Select your available equipment at home\n" +
                    "1. No Equipments\n" +
                    "2. Free Weights\n" +
                    "3. Machine Only\n" +
                    "4. Complete Equipments");
            setUserEquipments();

            routineList();
            break;
        }
    }

    public void routineList(){
        int days = getAvailableDaysArray().length;
        if (days == 1){
            System.out.println("Based on your selection, Full Body Routine is your perfect match!");
            System.out.println("Note: One day per week is a great start, but consider adding more days to maximize results!\n");
        }else if (days == 2){
            System.out.println("With those settings, Full Body Routine is the ideal routine for you");
            System.out.println("Tip: For better outcomes, try extending your routine to 2-3 days per week.\n");
        }else if (days >= 3 ){
            System.out.println("Based on your preferences, select your ideal routine:\n" +
                    "1. The PPL Split (Push, Pull, Legs)\n" +
                    "2. Full Body Routine\n" +
                    "3. Upper / Lower Split\n" +
                    "4. The Bro Split (Body Part Split)\n" +
                    "5. Hybrid Splits");
            setUserRoutine();
        }
    }

    public void fitnessGoals(){
        System.out.println("Select your equipments at home\n" +
                "1. Weight Loss\n" +
                "2. Muscle Gain\n" +
                "3. Maintain Overall Fitness");
        setUserFitnessGoals();
    }
}