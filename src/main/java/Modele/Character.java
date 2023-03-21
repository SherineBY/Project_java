package Modele;

import java.util.ArrayList;

public abstract class Character {
    public String name;
    public int maxhp,hp,level,attack;
    public Character(String name, int level ,int maxhp,int attack){
        this.hp =maxhp;
        this.level=level;
        this.name=name;
        this.maxhp=maxhp;
        this.attack=attack;

    }
    public abstract int attack();

    public abstract int attack(Character character);

    public boolean isDead() {
        if (this.hp <= 0) {
            System.out.println("You are dead !");
            return true;
        } else {
            return false;
        }
    }

}
