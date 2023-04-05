package Modele;

import java.util.*;

public class Wizard extends Character{
    private Wand wand;
    private Pet pet;
    private House house;
    private List<Spell> knownSpells;
    private List<Potion> potions;

    public Wizard(String name, int level, int maxhp, int attack,Pet pet,Wand wand,House house) {
        super(name, level, maxhp, attack);
        this.pet=pet;
        this.wand=wand;
        this.house=house;
        this.hp=maxhp;
        this.potions=new ArrayList<>();
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public void setName(String name){

        this.name= name;
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

    public void setWand(Wand wand){

        this.wand= wand;
    }
    public Wand getWand(){

        return wand;
    }
    public int getLevel(){
        return level;
    }
    public void setLevel(int level){
        this.level=level;
    }
    public int getHp(){
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public int attack(Character character) {
        return super.attack(character);
    }

    @Override
    public boolean isDead() {
        return super.isDead();
    }

    public void defend(){

        System.out.println(this.name+"Wizard you have blocked an attack of the enemy");
    }
    public void newpotion(Potion potion){

        this.potions.add(potion);
    }

    public List<Potion> getPotions() {

        return potions;
    }

    public void setPotions(List<Potion> potions) {

        this.potions = potions;
    }
    public void removePotion(Potion potion){
        this.potions.remove(0);
    }
    public void levelUp(){
        System.out.println("Félicitations, vous êtes maintenant au niveau " + level + " !");
        maxhp += 10;
        hp = maxhp;
        attack += 2;

        // Ajout d'une potion de guérison et d'une potion d'attaque
        potions.add(new Potion("healing potion",20));
        potions.add(new Potion("immunity potion",100));
        potions.add(new Potion("attack potion", 30));
    }




}


