package Modele;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class House {
    public static void house (String[] args) {
        // Instanciation de la liste à l'aide de Arrays.asList()
        List<String> house =Arrays.asList("Hufflepuf","Slytherin"," Gryffindor","Ravenclaw");
        String choiceHouse=house.get(new Random().nextInt(house.size()));
        // Afficher la liste
        System.out.println(choiceHouse);
    }

}
