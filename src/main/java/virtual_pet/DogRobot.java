package virtual_pet;

public class DogRobot extends RoboticPet implements petWalking{

    public DogRobot(String name, String petType, boolean dead, String kindOfPet, int power, int battery) {
        super(name, petType, dead, kindOfPet, power, battery);
    }

    @Override
    public void walking() {
        if (power <= 0) {
            power = 0;
            dead = true;
        }
        else {
            power = power - 2;
            if (power <= 0) {
                power = 0;
                dead = true;
            }
        }

        if (battery <= 0) {
            battery = 0;
            dead = true;
        }
        else {
            battery = battery - 2;
            if (battery <= 0) {
                battery = 0;
                dead = true;
            }
        }

    }
}
