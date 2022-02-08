package virtual_pet;

public abstract class OrganicPet extends VirtualPet{

    protected int hungry;
    protected int thirsty;
    protected int bored;
    protected int health;

    public OrganicPet(String name, String petType, boolean dead, String kindOfPet, int hungry, int thirsty, int bored, int health) {
        super(name, petType, dead, kindOfPet);
        this.hungry = hungry;
        this.thirsty = thirsty;
        this.bored = bored;
        this.health = health;
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

    public int getHealth() {
        return health;
    }

    @Override
    public String toString() {
        return "OrganicPet{" +
                "hungry=" + hungry +
                ", thirsty=" + thirsty +
                ", bored=" + bored +
                ", health=" + health +
                '}';
    }

    public void petPlaying() {

        if (dead == false) {
            hungry = hungry + 3;
            thirsty = thirsty + 3;
            if (hungry > hungryMsg) {
                dead = true;
                health = 0;
            }
            if (thirsty > thirstyMsg) {
                dead = true;
                health = 0;
            }
            if (bored > 0) {
                bored = bored - 3;
                if (bored <= 0) {
                    bored = 0;
                }
            }
        }

    }

    public void feedFood() {
        if (hungry >= hungryMsg) {
//            System.out.println(ANSI_YELLOW + "pet dead from hunger." + ANSI_RESET);
            dead = true;
//            happy = 0;
            health = 0;
        }

        if (hungry > 0) {
//            System.out.println("I am eating.");
            hungry = hungry - 1;
            dead = false;
        }
        else {
            dead = false;
        }

    }
    public void feedWater() {
        if (thirsty >= thirstyMsg) {
            dead = true;
            health = 0;
        }
        else if (thirsty > 0 && thirsty < thirstyMsg) {
//            System.out.println("I am drinking water.");
            thirsty = thirsty - 1;
            if (thirsty < 0) {
                thirsty = 0;
            }
            dead = false;
        }
        else {
            dead = false;
        }
    }

    public void tick() {
        if (dead == false) {
            thirsty = thirsty + 5;
            hungry = hungry + 5;
            bored = bored + 5;
            health = health - 1;
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
            System.out.println((getName() + " dead."));
        }
        else {
            System.out.println(getName() + " needs to see doctor right now. if health level goes to 0, the pet will die.");
            dead = false;
        }
        return dead;
    }

    public void petSeeDoctor() {

        if (health == 0) {
            dead = true;
            health = 0;
            System.out.println("The pet dead.");
        }
        else if (health == 3){
            System.out.println("Nothing wrong with " + getName());
            dead = false;
        }
        else {
            health = 3;     // doctor fix the health
            dead = false;
        }
    }

    public void getOrganicPetBored() {
        if (dead == false) {
            bored = bored + 1;
        }
    }

    public abstract void makeDirty();

}
