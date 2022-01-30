package virtual_pet;

import java.util.ArrayList;

import static virtual_pet.VirtualPet.*;

public class PetShelterCenter {

    // display the shelter center's pets;

    VirtualPet aPet = new VirtualPet("Lacy", "brown", "Poodle", 3, 12, 0, 0, 0,3, 3, false);
    VirtualPet bPet = new VirtualPet("bobo", "white", "German Shepherd", 5, 9, 0, 0, 0, 3, 3, false);
    VirtualPet cPet = new VirtualPet("Coco", "black", "Labrador", 2, 10, 0, 0, 0, 3, 3, false);

    private ArrayList<VirtualPet> pets;

    public PetShelterCenter() {
        pets = new ArrayList<VirtualPet>();
        pets.add(aPet);
        pets.add(bPet);
        pets.add((cPet));
    }

    public void showPetCenter() {
        System.out.println(ANSI_BLUE + "=======================  Pet List  ===================================================================" + ANSI_RESET);
        for (VirtualPet onePet : pets) {
            System.out.println(onePet.getName()+" -- fur color is "+onePet.getFurColor()+", "+onePet.getAge() + " years old, "+ onePet.getType() + " breed, average living "
                    + onePet.getLiveLife() +" years." );
            System.out.println(ANSI_BLUE + "======================================================================================================" + ANSI_RESET);

        }
    }

    public void addPetToShelter(String name, String furColor, String breed, int age, int liveLife, int hungry, int thirsty, int bored, int happy, int health, boolean dead) {
        //VirtualPet(String name, String furColor, String type, int age, int liveLife, int hungry, int thirsty, int bored, int happy, boolean health)
        VirtualPet newPet = new VirtualPet(name, furColor, breed, age, liveLife, 0, 0, 0, 3, 3, false);
        pets.add(newPet);

        System.out.println("We have a new pet: " + newPet.getName() + ", fur color is "+newPet.getFurColor() + ", "+newPet.getAge() + " years old. It is a "+ newPet.getType()
                + " breed, average living "+ newPet.getLiveLife() + " years. ");
    }

    public boolean isUniqueName(String name) {

        for (VirtualPet onePet : pets) {
            if (onePet.getName().equalsIgnoreCase(name)) {
                System.out.println(ANSI_RED + "We already have pet name(" + name + ") in our shelter. Please change pet name!" + ANSI_RESET);
                return false;
            }
        }

        return true;
    }

    public void adoptPetFromShelter(String name) {
        boolean found = true;
        if (pets.size() != 0) {
            for (VirtualPet adoptPet : pets) {
                if (adoptPet.getName().equalsIgnoreCase(name)) {
                    pets.remove(adoptPet);
                    found = true;
                    break;
                }
                else {
                    found = false;
                }
            }
            if (found == false) {
                System.out.println(ANSI_RED + "No name(" + name + ") in our shelter." + ANSI_RESET);
            }
        }
        else {
            System.out.println(ANSI_RED + "no pet in the shelter you can adopt." + ANSI_RESET);
        }
    }

    public void showAllPetsStatus() {

        System.out.println(ANSI_BLUE + "=====================  All Pet Status  ======================================================================================="+ ANSI_RESET);

        if (pets.size() != 0) {
            for (VirtualPet onePet : pets) {
                onePet.checkPetStatus();        // check pet status
                if (onePet.isHealth() == 1) {
                    System.out.println("Name: " + onePet.getName() + "      Hunger Level: " + onePet.getHungry() + "      Thirsty Level: " +
                            onePet.getThirsty() + "      Boredom Level: " + onePet.getBored() + "      Is Health: " + ANSI_RED + onePet.isHealth() + ANSI_RESET + "      Is Dead: "+onePet.isDead());
                }
                else {
                    System.out.println("Name: " + onePet.getName() + "        Hunger Level: " + onePet.getHungry() + "        Thirsty Level: " +
                            onePet.getThirsty() + "        Boredom Level: " + onePet.getBored() + "        Is Health: " + onePet.isHealth() + "      Is Dead: "+onePet.isDead());
                }
                System.out.println(ANSI_BLUE + "==============================================================================================================================" + ANSI_RESET);
            }
        }
        else {
            System.out.println("no records");
        }
    }

    public boolean choosePetToPlay() {
        boolean havePet = false;
        for (VirtualPet onePet : pets) {
            if (onePet.isDead() == false) {
                havePet = true;
                break;
            }
        }
        if (pets.size() == 0 || havePet == false) {
            System.out.println(ANSI_BLUE + "There is no pet/lived pet in the shelter." + ANSI_RESET);
            System.out.println(ANSI_BLUE + "Please add some pets to the shelter." + ANSI_RESET);
            havePet = false;
        }
        else {
            System.out.println("Please choose a pet to play with:");
            for (VirtualPet onePet : pets) {
                if (onePet.isDead() == false) {
                    System.out.println("          [" +  pets.indexOf(onePet) + "] -- "+onePet.getName());
                }
            }
            havePet = true;

        }
        return havePet;
    }

    public void pickedPetWithActivities(int inputNum, int chooice) {
        // get this pet information with the indexOf the record
        if ((inputNum) < pets.size()) {
            VirtualPet pickedPet = pets.get(inputNum);      // pass the index of arraylist
            // need do activities in here
            if (chooice == 5) {
                // playing
                pickedPet.petPlaying();
            } else if (chooice == 6) {
                // hungry
                pickedPet.feedFood();
            } else if (chooice == 7) {
                // thirsty
                pickedPet.feedWater();
            } else if (chooice == 8) {
                // self clean
                pickedPet.selfClean();
            } else if (chooice == 9) {
                pickedPet.petSick();
                if (pickedPet.isDead()) {
                    // pet dead, remove it.
                    //adoptPetFromShelter(pickedPet.getName());
                }
            } else if (chooice == 10) {
                // see a doctor
                pickedPet.seeDoctor();
            }
            else {
                // do nothing
            }
        } else {
            System.out.println(" press wrong number");
        }

    }

    public void timePassForAllPet() {
        for (VirtualPet onePet : pets) {
            onePet.tick();
        }
    }

}
