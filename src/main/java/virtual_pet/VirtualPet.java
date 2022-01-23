package virtual_pet;

public class VirtualPet {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";

    private String name;
    private int hungry = 0;
    private int thirsty = 0;
    private int bored = 0;
    private int hungryMsg = 10;
    private int thirstyMsg = 10;
    private int boredMsg = 8;
    private int happy = 0;
    public  VirtualPet() {

    }

    public VirtualPet(String name, int hungry, int thirsty, int bored) {
        this.name = name;
        this.hungry = hungry;
        this.thirsty = thirsty;
        this.bored = bored;
    }

    public String getName() {
        return name;
    }

    public int getHungry() {
        return hungry;
    }

    public int getThirsty() {
        return thirsty;
    }

    public int getBored() {
        return bored;
    }

    public void petPlaying() {
        System.out.println(name + " is playing now.");
        hungry = hungry + 3;
        thirsty = thirsty + 3;
        if (bored > 0) {
            bored = bored - 3;
        }

    }

    public String talking() {
        return "I am " + name + ". I am your pet today.";
    }

    public void feedFood() {
        if (hungry > 0) {
            System.out.println("I am eating.");
            hungry = hungry - 1;
        }
        else {
            System.out.println(ANSI_YELLOW  + "I am not hungry." + ANSI_RESET);
        }
//        bored = bored + 1;

    }

    public void feedWater() {
        if (thirsty > 0) {
            System.out.println("I am drinking water.");
            thirsty = thirsty - 1;
        }
        else {
            System.out.println(ANSI_YELLOW + "I am not thirsty."+ANSI_RESET);
        }
//        bored = bored - 1;
    }

    public void selfClean() {
        System.out.println("I am cleaning myself...");
        bored += 1;
    }
    public void tick() {

        System.out.println("time passes...");
        thirsty = thirsty + 5;
        hungry = hungry + 5;
        bored = bored + 5;

    }

    public void showPetStatus() {
        System.out.println("====>     Hungry Level: "+hungry + "    Thirsty Level: " + thirsty + "    Bored Level: "+ bored);
        System.out.println(ANSI_BLUE + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + ANSI_RESET);
        checkPetStatus();

    }

    public void checkPetStatus() {
        happy = 0;
        if (hungry <= hungryMsg) {
            //System.out.println("I am not hungry.");
            happy += 1;
//            System.out.println("happyh="+happy);
        }
        else {
            System.out.println(ANSI_RED + "I am hungry." + ANSI_RESET);
            happy -= 1;
        }

        if (thirsty <= thirstyMsg) {
            //System.out.println("I am not thirsty.");
            happy += 1;
//            System.out.println("happy="+happy);
        }
        else {
            System.out.println(ANSI_RED + "I am thirsty." + ANSI_RESET);
            happy -= 1;
        }

        if (bored <= boredMsg) {
            //System.out.println("I am not bored");
            happy += 1;
        }
        else {
            System.out.println(ANSI_RED + "I am board."+ ANSI_RESET);
            happy -= 1;
        }

        if (happy >= 3) {
            System.out.println(ANSI_GREEN + "I am happy! :=)" + ANSI_RESET);
        }
        else {
            System.out.println(ANSI_YELLOW + "I am not happy! :=(" + ANSI_RESET );
        }

    }

}
