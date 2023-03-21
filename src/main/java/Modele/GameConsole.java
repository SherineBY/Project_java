package Modele;

import java.util.Scanner;

public class GameConsole {

    public void startofgame(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("what is your name?");
        int name= scanner.nextInt();
        System.out.println("hello young wizard"+name+" welcome to Hogwarts ");
        System.out.println("you will now participate in the sorting ceremony that will define to which house you belong ");
    }
}
