package virtual_pet;

import java.util.Scanner;

public class VirtualPetApplication {

    // this game is depending on the pet hungry level, thirsty level and bored level to choose how to .
    // if the pet not happy, displaying text color will change to yellow;
    // if the pet hungry, or thirsty, or bored, displaying text color will change to red;
    // if the pet not hungry, not thirsty, or not bored; the pet happy, the text color will change to green;
    // this game the setup for:
    //              * hungry level is 10 (meaning 0 is very full, > 10 need to feed food);
    //              * thirst level is 10 (meaning 0 is don't need water, > 10 need to feed water);
    //              * bored level is 8 (meaning 0 is not bored at all, > 8 is bored);
    //
    // the menu of the game to play:
    //          1 -- time passes;           hungry increase by 5, thirsty increase by 5 and bored increase by 5
    //          2 -- feed the pet food;     hungry down by 1
    //          3 -- give the pet water;    thirsty down by 1
    //          4 -- pet playing;           hungry up by 3, thirsty up by 3 and bored down by 3
    //          5 -- pet self clean;        bored up by 1;
    //          6 -- Exit.                  stop the game. exit te problem.
    //
    public static void main(String[] args) {
        //Interact with a VirtualPet object in this method

        System.out.println("Welcome to the Virtual Pet Game!!!");

        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter your pet name: ");
        String petName = userInput.nextLine();

        VirtualPet myPet = new VirtualPet(petName, 0, 0,0);
        System.out.println(myPet.talking() );

        boolean gameStop = false;

        while ( gameStop == false ) {
            myPet.showPetStatus();
            System.out.println("Please enter number: 1 -- time passes; 2 -- feed the pet food; 3 -- give the pet water; 4 -- pet playing; 5 -- self clean; 6 -- Exit.");
            int inputNum = userInput.nextInt();
            userInput.nextLine();

            if (inputNum == 1) {
                myPet.tick();
            }
            else if (inputNum == 2) {
                myPet.feedFood();

            }
            else if (inputNum == 3) {
                myPet.feedWater();
            }
            else if (inputNum == 4) {
                myPet.petPlaying();
            }
            else if (inputNum == 5) {
                myPet.selfClean();
            }
            else if (inputNum == 6) {
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