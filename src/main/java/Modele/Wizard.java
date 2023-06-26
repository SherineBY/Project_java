package Modele;

import java.util.ArrayList;
import java.util.List;

public class Wizard extends Character {
    private Wand wand;
    private Pet pet;
    private House house;
    private List<Spell> knownSpells;
    private List<Potion> potions;

    public Wizard(String name, int level, int maxhp, int attack, Pet pet, Wand wand, House house) {
        super(name, level, maxhp, attack);
        this.pet = pet;
        this.wand = wand;
        this.house = house;
        this.potions = new ArrayList<>();
    }

    public int getMaxHp() {
        return maxhp;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Pet getPet() {
        return pet;
    }

    public void setWand(Wand wand) {
        this.wand = wand;
    }

    public Wand getWand() {
        return wand;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
    }

    @Override
    public boolean isDead() {
        return super.isDead();
    }

    public void defend() {
        System.out.println(this.name + " Wizard, you have blocked an attack from the enemy");
    }

    public void newPotion(Potion potion) {
        this.potions.add(potion);
    }

    public List<Potion> getPotions() {
        return potions;
    }

    public void setPotions(List<Potion> potions) {
        this.potions = potions;
    }

    public void removePotion(Potion potion) {
        this.potions.remove(potion);
    }

    public void levelUp() {
        System.out.println("Congratulations, you have reached level " + level + "!");
        maxhp += 10;
        hp = maxhp;
        attack += 2;

        // Ajout d'une potion de guérison et d'une potion d'attaque
        potions.add(new Potion("healing potion", 10,20));
        potions.add(new Potion("attack potion", 15,23));
    }

}
