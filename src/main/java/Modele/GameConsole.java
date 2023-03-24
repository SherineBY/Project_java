package Modele;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GameConsole {


        public House choiceHouse(){
                ThreadLocalRandom threadLocalRandom= ThreadLocalRandom.current();
                Random house = new Random();
                int houseindex = threadLocalRandom.nextInt(House.values().length);
                return House.values()[houseindex];
        }

        public Core choiceCore(){
                ThreadLocalRandom threadLocalRandom=ThreadLocalRandom.current();
                Random core = new Random();
                int coreindex=threadLocalRandom.nextInt(Core.values().length);
                return Core.values()[coreindex];
        }
    public void startofgame(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("what is your name?");
            String name= scanner.nextLine();
            System.out.println("hello young wizard " +name+" welcome to Hogwarts ");
            System.out.println("you will now participate in the sorting ceremony in which the SortingHat will define to which house you belong ");
            System.out.println("Difficult, very difficult... I see a lot of courage and intellectual qualities too. There's talent, oh yes, and a great desire to prove yourself. So where do I put you?");
            System.out.println("Okey I know!you are " + choiceHouse());
            System.out.println("Now go the Ollivander shop, you will be assigned a wand ");
            Wand wand = new Wand(choiceCore(), 25);
            System.out.println("Okey now you have Wand .The core is " +wand.getCore()+ "and the size of your hand is "  +wand.getSize()+"cm");
            System.out.println(" before you enter Hogwarts you have to choose your pet ");
            System.out.println("Choose your pet among this list: " + Arrays.toString(Pet.values()));
            String petName = scanner.nextLine();
            for (Pet pet : Pet.values()) {
                    if (pet.name().equals(petName)) {
                            System.out.println("You have chosen " + petName + " as your pet.");
                            break;
                    }else{
                            System.out.println("Invalid input. Please choose one of the available pets.");
                            break;
                    }
            }

        }
}








