package virtual_pet;

public abstract class RoboticPet extends VirtualPet{

    protected int power;
    protected int battery;

    public RoboticPet(String name, String petType, boolean dead, String kindOfPet, int power, int battery) {
        super(name, petType, dead, kindOfPet);
        this.power = power;
        this.battery = battery;
    }

    public int getPower() {
        return power;
    }

    public int getBattery() {
        return battery;
    }

    public void changeBattery() {

        // System.out.println("changed the battery.");
        battery = 3;
        power = 3;
    }

    public void robotPlaying() {
        if (dead == false) {
            power = power - 2;
            battery = battery - 2;
            if (power <= 0 || battery <= 0) {
                dead = true;
                power = 0;
                battery = 0;
            }
        }
    }

    public void robotTick() {
        if (dead == false) {
            power = power - 1;
            battery = battery - 1;

            if (power <= 0 || battery <= 0) {
                dead = true;
                power = 0;
                battery = 0;
            }
        }
    }



}
