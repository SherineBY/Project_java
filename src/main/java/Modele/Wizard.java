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
    public Wizard(String name, int level, int maxhp, int attaque) {
        super(name, level, maxhp, attaque);
        this.potions.add(new Potion("Potion", 50));
    }
    //character correspond à un ennemi ou un boss qu'on attaque
    @Override
    public int attack(Character character) {
        return character.hp - this.attaque;
    }

    @Override
    public boolean isDead() {
        if (this.hp <= 0) {
            System.out.println("You are dead !");
            return true;
        } else {
            return false;
        }
    }

    public void defend() {
        System.out.println(this.name + " Sorcier vous avez bloqué une attaque de l'enemy !");
    }

    public void newPotion(Potion potion) {
        this.potions.add(potion);
    }

    public void usePotion() {
        this.potions.remove(0);
    }
}

