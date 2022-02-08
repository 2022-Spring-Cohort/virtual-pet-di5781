package virtual_pet;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Scanner;

public class VirtualPetApplication {

    // Phase II virtual pet
    // this game is depending on the pet hungry level, thirsty level and bored level to choose how to .
    // if the pet not happy, displaying text color will change to yellow;
    // if the pet hungry, or thirsty, or bored, displaying text color will change to red;
    // if the pet not hungry, not thirsty, or not bored; the pet happy, the text color will change to green;
    // When pet get adopted, this pet get removed from the shelter.
    // only allow unique pet name in this shelter.
    // this game the setup for:
    //              * hungry level is 13 (meaning 0 is very full, > 13 need to feed food, pet dies );
    //              * thirst level is 13 (meaning 0 is don't need water, > 13 need to feed water, pet dies);
    //              * bored level is 8 (meaning 0 is not bored at all, > 8 is bored);
    //              * pet health level 3 is very good; 1 must see a doctor; 0 means pet dead
    //              * if all the pets in the shelter are dead, Shelter will out of business.

    // the menu of the game:
    //          1  --  display all the pet status;
    //          2  --  time passes...
    //          3  --  admit a pet;
    //          4  --  adopt a pet;
    //          5  --  pick a pet to play;
    //          6  --  pick a pet to feed food;
    //          7  --  pick a pet to feed water;
    //          8  --  change battery for Robotic pet;
    //          9  --  make organic pet cage or litter box dirty;
    //          10 --  clean cage or litter box;
    //          11 --  pick a pet to walk;
    //          12 --  see a doctor;
    //          13 --  pet is sick;;
    //          14 --  pet is getting bored;
    //          15 --  Exit.


    public static void main(String[] args) {
        //Interact with a VirtualPet object in this method

        System.out.println("Welcome to the Virtual Pet Shelter Game!!!");

        Scanner userInput = new Scanner(System.in);

        PetShelterCenter petShelter = new PetShelterCenter();

        boolean gameStop = false;

        while ( gameStop == false ) {

            System.out.println("Please enter number:  ");
            System.out.println("1  --  display all the pet status; ");
            System.out.println("2  --  time passes...");
            System.out.println("3  --  admit a pet; ");
            System.out.println("4  --  adopt a pet;");
            System.out.println("5  --  pick a pet to play;");
            System.out.println("6  --  pick a pet to feed food;");
            System.out.println("7  --  pick a pet to feed water;");
            System.out.println("8  --  change battery for Robotic pet;");
            System.out.println("9  --  make organic pet cage or litter box dirty;");
            System.out.println("10  -- clean cage or litter box;");
            System.out.println("11 --  pick a pet to walk;");
            System.out.println("12 --  see a doctor;");
            System.out.println("13 --  pet is sick;");
            System.out.println("14 --  pet is getting bored;");
            System.out.println("15 --  Exit.");

            int inputNum = userInput.nextInt();
            userInput.nextLine();

            if (inputNum == 1) {
                petShelter.showPetCenter();
                // check pet status
                if (petShelter.showAllPetsStatus() == true) {
                    gameStop = true;
                    break;
                }
            }
            else if (inputNum == 2) {
                // time passes tick...
                System.out.println("time passes...");
                petShelter.timePassForAllPet();

            }
            else if (inputNum == 3) {
                System.out.println("Pet name: ");
                String name = userInput.nextLine();
                if (petShelter.isUniqueName(name)) {
                    System.out.println("Type(type Organic or Robotic): ");
                    String petType = userInput.nextLine();
                    System.out.println("Kind Of Type(type Cat or Dog): ");
                    String kindOfType = userInput.nextLine();
                    petShelter.addPetToShelter(name, petType, kindOfType);
                }
            }
            else if (inputNum == 4) {
                System.out.println("Pet Name: ");
                String name = userInput.nextLine();
                petShelter.adoptPetFromShelter(name);
            }

            else if (inputNum == 5 || inputNum == 6 || inputNum == 7 || inputNum == 8 || inputNum == 9 || inputNum == 10 || inputNum == 11 || inputNum == 12 || inputNum == 13 || inputNum == 14) {

                if (petShelter.choosePetToPlay() == false) {
                    // message already displayed in blue
                }
                else {
                    int choice = userInput.nextInt();
                    userInput.nextLine();
                    petShelter.pickedPetWithActivities(choice, inputNum);
                }
            }
            else if (inputNum == 15) {
                System.out.println("exit the program");
                gameStop = true;
                break;
            }
            else {
                //continue the game;
            }



        }

        userInput.close();

    }

}