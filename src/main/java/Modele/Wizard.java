package Modele;

import java.util.List;

public class Wizard extends Character{
    private Wand wand;
    private Pet pet;
    private House house;
    private List<Spell> knownSpells;
    private List<Potion> potions;

    public Wizard(String name, int level, int maxhp, int attack) {
        super(name, level, maxhp, attack);
        this.potions.add(new Potion("Potion", 50));
    }

    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int attack(Character character) {
        return character.hp - this.attack;
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
    public void usePotion(){
        this.potions.remove(0);
    }
}


