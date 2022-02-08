package virtual_pet;

import java.util.ArrayList;

import static virtual_pet.VirtualPet.*;

public class PetShelterCenter {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";

    VirtualPet catOrg1 = new CatOrganic("Bobo", "Organic", false, "Cat", 0, 0, 0, 3, true);
    VirtualPet dogOrg1 = new DogOrganic("Lacy", "Organic", false, "Dog", 0, 0, 0, 3, true);
    VirtualPet catRobot1 = new CatRobot("Robo", "Robotic", false, "Cat", 3, 3);
    VirtualPet dogRobot1 = new DogRobot("Elliot", "Robotic", false, "Dog", 3, 3);


    private ArrayList<VirtualPet> pets;

    public PetShelterCenter() {
        pets = new ArrayList<VirtualPet>();
        pets.add(catOrg1);
        pets.add(dogOrg1);
        pets.add(catRobot1);
        pets.add(dogRobot1);
    }

    public void showPetCenter() {

        System.out.println(ANSI_BLUE +"=================================  Pet Status  =================================================================================================="+ ANSI_RESET);
        if (pets.size() == 0) {
            System.out.println(ANSI_BLUE +"================================================================================================================================================="+ ANSI_RESET);
        }
        for (VirtualPet onePet : pets) {
            if (onePet instanceof CatOrganic) {
                System.out.println("Name: " + onePet.getName() + ";    " + onePet.getPetType() + " " + onePet.getKindOfPet() +
                        "      Hungry: " + ((OrganicPet) onePet).getHungry() + "      Thirsty: " + ((OrganicPet) onePet).getThirsty() +
                        "      Bored: " + ((OrganicPet) onePet).getBored() + "     Litter box is cleaning: " + ((CatOrganic) onePet).isLitterBoxIsClean() + "     Health: "+
                        ((CatOrganic) onePet).health + "        Dead: " + onePet.isDead());
            }
            if (onePet instanceof DogOrganic) {
                System.out.println("Name: " + onePet.getName() + ";    " + onePet.getPetType() + " "  + onePet.getKindOfPet() +
                        "      Hungry: " + ((OrganicPet) onePet).getHungry() + "      Thirsty: " + ((OrganicPet) onePet).getThirsty() +
                        "      Bored: " + ((OrganicPet) onePet).getBored() + "     Cage is cleaning:       " + ((DogOrganic) onePet).isCageIsClean() + "     Health: " + ((DogOrganic) onePet).health +
                        "        Dead: "+ onePet.isDead());
            }
            if (onePet instanceof CatRobot) {
                System.out.println("Name: " + onePet.getName() + ";    " + onePet.getPetType() + " "  + onePet.getKindOfPet() +
                        "      Power: " + ((CatRobot) onePet).getPower() + "       Battery: " + ((CatRobot) onePet).getBattery() + "                                                                     Dead: "+ onePet.isDead());
            }
            if (onePet instanceof DogRobot) {
                System.out.println("Name: " + onePet.getName() + ";  " + onePet.getPetType() + " "  + onePet.getKindOfPet() +
                        "      Power: " + ((DogRobot) onePet).getPower() + "       Battery: " + ((DogRobot) onePet).getBattery() + "                                                                     Dead: "+ onePet.isDead());
            }
            System.out.println(ANSI_BLUE +"================================================================================================================================================="+ ANSI_RESET);
        }

    }

    public boolean showAllPetsStatus() {

        boolean isAllDead = true;
        for (VirtualPet onePet : pets) {
            if (onePet.isDead() == false) {
                isAllDead = false;
                break;
            }
        }
        if (isAllDead == true) {
            System.out.println(ANSI_RED + "All pets in the shelter are dead now. Shelter is out of business!!!!" +ANSI_RESET);
            return true;
        }
        else {
            return false;
        }

    }

    public void addPetToShelter(String name, String petType, String kindOfType) {
        if (petType.equalsIgnoreCase("organic")) {
            if (kindOfType.equalsIgnoreCase("cat")) {
                VirtualPet catOrgNew = new CatOrganic(name, "Organic", false, "Cat", 0, 0, 0, 3, true);
                pets.add(catOrgNew);
            }
            else {
                VirtualPet dogOrgNew = new DogOrganic(name, "Organic", false, "Dog", 0, 0, 0, 3, true);
                pets.add(dogOrgNew);
            }
        }
        else {
            if (kindOfType.equalsIgnoreCase("cat")) {
                VirtualPet catRobotNew = new CatRobot(name, "Robotic", false, "Cat", 3, 3);
                pets.add(catRobotNew);
            }
            else {
                VirtualPet dogRobotNew = new DogRobot(name, "Robotic", false, "Dog", 3, 3);
                pets.add(dogRobotNew);
            }
        }

        System.out.println("We have a new pet: " + name + " -- " + petType + " " + kindOfType);
    }

    public boolean isUniqueName(String name) {
        for (VirtualPet onePet : pets) {
            if (onePet.getName().equalsIgnoreCase(name)) {
                System.out.println("We already have pet name(" + name + ") in our shelter. Please change pet name!");
                return false;
            }
        }
        return true;
    }

    public void adoptPetFromShelter(String name) {
        boolean found = true;
        if (pets.size() != 0) {
            for (VirtualPet adoptPet : pets) {
                if (adoptPet.dead == false) {
                    if (adoptPet.getName().equalsIgnoreCase(name)) {
                        pets.remove(adoptPet);
                        found = true;
                        break;
                    }
                    else {
                        found = false;
                    }
                }
                else {
                    found = false;      // pet dead
                }
            }
            if (found == false) {
                System.out.println(ANSI_RED + "No name(" + name + ") or the pet already dead in our shelter." + ANSI_RESET);
            }
        }
        else {
            System.out.println(ANSI_RED + "no pet in the shelter you can adopt." + ANSI_RESET);
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
                    System.out.println("          [" +  pets.indexOf(onePet) + "] -- "+onePet.getName() + " - " + onePet.getPetType() + " " + onePet.getKindOfPet());
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
                if (pickedPet instanceof CatOrganic) {
                    ((CatOrganic) pickedPet).petPlaying();
                }
                if (pickedPet instanceof DogOrganic) {
                    ((DogOrganic) pickedPet).petPlaying();
                }
                if (pickedPet instanceof CatRobot) {
                    ((CatRobot) pickedPet).robotPlaying();
                }
                if (pickedPet instanceof DogRobot) {
                    ((DogRobot) pickedPet).robotPlaying();
                }
                else {
                    //do nothing
                }
            } else if (chooice == 6) {
                // hungry
                if (pickedPet instanceof CatOrganic) {
                    ((CatOrganic) pickedPet).feedFood();
                }
                else if (pickedPet instanceof DogOrganic) {
                    ((DogOrganic) pickedPet).feedFood();
                }
                else {
                    System.out.println(ANSI_RED+"Only organic pet eat food."+ANSI_RESET);
                }
                // robot pet don't need to feed food
            } else if (chooice == 7) {
                // thirsty
                if (pickedPet instanceof CatOrganic) {
                    ((CatOrganic) pickedPet).feedWater();
                }
                else if (pickedPet instanceof DogOrganic) {
                    ((DogOrganic) pickedPet).feedWater();
                }
                else {
                    System.out.println(ANSI_RED + "Only organic pet drink water." + ANSI_RESET);
                }
                // robot pet don't need to feed water
            } else if (chooice == 8) {
                // change battery for robot pet
                if (pickedPet instanceof CatRobot) {
                    ((CatRobot) pickedPet).changeBattery();
                }
                else if (pickedPet instanceof DogRobot) {
                    ((DogRobot) pickedPet).changeBattery();
                }
                else {
                    System.out.println(ANSI_RED + "Only robotic pet need change battery."+ANSI_RESET);
                }
            } else if (chooice == 9) {
                // make cage and litter box dirty
                if (pickedPet instanceof CatOrganic) {
                    ((CatOrganic) pickedPet).makeDirty();
                }
                else if (pickedPet instanceof DogOrganic) {
                    ((DogOrganic) pickedPet).makeDirty();
                }
                else {
                    System.out.println(ANSI_RED + "Only organic pet make cage or litter box dirty." + ANSI_RESET);
                }
                // robotic pet doesn't make mess
            } else if (chooice == 10) {
                // clean the dirty cage and litter box
                if (pickedPet instanceof DogOrganic) {
                    ((DogOrganic) pickedPet).clean("Dog");
                }
                else if (pickedPet instanceof CatOrganic) {
                    ((CatOrganic) pickedPet).clean("Cat");
                }
                else {
                    System.out.println(ANSI_RED + "Only organic pet cage or litter box need to clean." + ANSI_RESET);
                }

            } else if (chooice == 11) {
                // take pet to walk
                if (pickedPet instanceof DogOrganic) {
                    ((DogOrganic) pickedPet).walking();
                }
                else if (pickedPet instanceof DogRobot) {
                    ((DogRobot) pickedPet).walking();
                }
                else {
                    System.out.println(ANSI_RED + "only dog will take a walk." + ANSI_RESET);
                }
            } else if (chooice == 12) {
                // see a doctor
                if (pickedPet instanceof OrganicPet) {
                    ((OrganicPet) pickedPet).petSeeDoctor();
                }
                else {
                    System.out.println(ANSI_RED + "Only organic pet get see doctor." + ANSI_RESET);
                }

            } else if (chooice == 13) {
                // pet sick
                if (pickedPet instanceof OrganicPet) {
                    ((OrganicPet) pickedPet).petSick();
                }
                else {
                    System.out.println(ANSI_RED + "only organic pet get sick." + ANSI_RESET);
                }
            } else if (chooice == 14) {
                // organic pet get bored
                if (pickedPet instanceof OrganicPet) {
                    ((OrganicPet) pickedPet).getOrganicPetBored();
                }
                else {
                    System.out.println(ANSI_RED+"Only organic pet get bored."+ANSI_RESET);
                }
            }

            } else {

                // do nothing
            }

        }

    public void timePassForAllPet() {
        for (VirtualPet onePet : pets) {
            if (onePet instanceof OrganicPet) {
                ((OrganicPet) onePet).tick();
            }
            if (onePet instanceof RoboticPet) {
                ((RoboticPet) onePet).robotTick();
            }
            else {
                // do nothing;
            }
        }
    }

}
