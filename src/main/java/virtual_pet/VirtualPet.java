package virtual_pet;

public class VirtualPet {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";

    private String name;
    private String furColor;
    private String type;
    private int age;
    private int liveLife;
    private int hungry = 0;
    private int thirsty = 0;
    private int bored = 0;
    private int hungryMsg = 12;
    private int thirstyMsg = 12;
    private int boredMsg = 8;
    private int happy = 0;
    private int health;
    private boolean dead;

    public VirtualPet(String name, String furColor, String type, int age, int liveLife, int hungry, int thirsty, int bored, int happy, int health, boolean dead) {
        this.name = name;
        this.furColor = furColor;
        this.type = type;
        this.age = age;
        this.liveLife = liveLife;
        this.hungry = hungry;
        this.thirsty = thirsty;
        this.bored = bored;
        this.happy = happy;
        this.health = health;
        this.dead = dead;
    }

    public  VirtualPet() {

    }


    public VirtualPet(String name, int hungry, int thirsty, int bored) {
        this.name = name;
        this.hungry = hungry;
        this.thirsty = thirsty;
        this.bored = bored;
    }

    public VirtualPet(String name, String furColor, String type, int age, int liveLife) {
        this.name = name;
        this.furColor = furColor;
        this.type = type;
        this.age = age;
        this.liveLife = liveLife;
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

    public String getFurColor() {
        return furColor;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public int getLiveLife() {
        return liveLife;
    }

    public int isHealth() {
        return health;
    }

    public boolean isDead() {
        return dead;
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
        if (hungry >= hungryMsg) {
            System.out.println(ANSI_YELLOW + "pet dead from hunger." + ANSI_RESET);
            dead = true;
            happy = 0;
            health = 0;
        }
        if (hungry > 0) {
            System.out.println("I am eating.");
            hungry = hungry - 1;
            dead = false;
        }
        else {
            System.out.println(ANSI_YELLOW  + "I am not hungry." + ANSI_RESET);
            dead = false;
        }
//        bored = bored + 1;

    }

    public void feedWater() {
        if (thirsty >= thirstyMsg) {
            System.out.println(ANSI_YELLOW + "pet dead from thirsty." + ANSI_RESET);
            dead = true;
            happy = 0;
            health = 0;
        }
        if (thirsty > 0 && thirsty < thirstyMsg) {
            System.out.println("I am drinking water.");
            thirsty = thirsty - 1;
            dead = false;
        }
        else {
            System.out.println(ANSI_YELLOW + "I am not thirsty."+ANSI_RESET);
            dead = false;
        }
//        bored = bored - 1;
    }

    public void selfClean() {
        System.out.println("I am cleaning myself...");
        bored += 1;
    }

    public void seeDoctor() {
        System.out.println("Doctor, " + getName() + " doesn't feel good.");
        if (health == 0) {
            dead = true;
            health = 0;
            System.out.println(ANSI_YELLOW + "The pet dead." + ANSI_RESET);
        }
        else if (health == 3){
            System.out.println(ANSI_GREEN + "Nothing wrong with " + getName() + ANSI_RESET);
            dead = false;
        }
        else {
            health = 3;     // doctor fix the health
            dead = false;
        }
    }

    public void tick() {
        if (dead == false) {
            thirsty = thirsty + 5;
            hungry = hungry + 5;
            bored = bored + 5;
            if (thirsty > thirstyMsg || hungry > hungryMsg) {
                dead = true;
                health = 0;
            }
        }
    }

    public boolean petSick() {
        health = health - 2;
        if (health < 0) {
            health = 0;
            dead = true;
            System.out.println(ANSI_YELLOW + (getName() + " dead.") + ANSI_RESET);
        }
        else {
            System.out.println(ANSI_RED + getName() + " needs to see doctor right now. if health level goes to 0, the pet will die." + ANSI_RESET);
            dead = false;
        }
        return dead;
    }

    public void showPetStatus() {
        System.out.println("====>     Hungry Level: "+hungry + "    Thirsty Level: " + thirsty + "    Bored Level: "+ bored);
        System.out.println(ANSI_BLUE + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + ANSI_RESET);
        checkPetStatus();

    }

    public void checkPetStatus() {
        boolean displayMsg = true;
        if (dead != true) {
            happy = 0;
            if (hungry <= 0) {
                happy += 1;
            }

            if (hungry > 0 && hungry <= hungryMsg) {
                System.out.println(ANSI_RED + "I am hungry." + ANSI_RESET);
                happy -= 1;
                dead = false;
            }
            else {
                if (hungry > hungryMsg) {
                    dead = true;
                    health = 0;
                    System.out.println(ANSI_YELLOW + getName() + " dead from hunger."  + ANSI_RESET);
                    displayMsg = false;
                }
            }

            if (thirsty <= 0) {
                happy += 1;
            }

            if (thirsty > 0 && thirsty <= thirstyMsg) {
                System.out.println(ANSI_RED + "I am thirsty." + ANSI_RESET);
                happy -= 1;
                dead = false;
            }
            else if (thirsty > thirstyMsg) {
                System.out.println(ANSI_YELLOW + getName() +" dead from thirst." + ANSI_RESET);
                dead = true;
                health = 0;
                displayMsg = false;
            }

            if (bored <= boredMsg) {
                //System.out.println("I am not bored");
                happy += 1;
            }
            else {
                if (displayMsg) {
                    System.out.println(ANSI_RED + "I am board."+ ANSI_RESET);
                }
                happy -= 1;
            }

            if (happy >= 3 && health == 3) {
                System.out.println(ANSI_GREEN + "I am happy! :=)" + ANSI_RESET);
            }
            else {
                if (displayMsg) {
                    System.out.println(ANSI_YELLOW + "I am not happy! :=(" + ANSI_RESET );
                }
            }

            if (health == 1) {
                System.out.println(ANSI_RED + getName() + " needs to see doctor right now. if health level goes to 0, the pet will die." + ANSI_RESET);
            }
            else if (health == 0) {
                System.out.println(ANSI_YELLOW + "pet, " + getName() + " dead" +ANSI_RESET);
                dead = true;
            }

        }


    }

}
