package Modele;

public abstract class Character {
    public String name;
    public int hp,xp;
    public String[] attack_upgrades=("Spells");
    public Character(String name, int xp , int hp){

    }
    public abstract int attack();
    public abstract int defend();

}
