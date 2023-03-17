package Modele;

import Modele.*;
import Modele.Character;

import java.util.List;

public class Wizard extends Character{
    private Wand wand;
    private Pet pet;
    private House house;
    private List<Spell> knownSpells;
    private List<Potion> potions;
    public String[] defend_upgrades=("Potion");
    public Wizard(String name) {
        super(name, xp, hp);
    }

    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int defend() {
        return 0;
    }
}

