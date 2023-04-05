package Modele;

public abstract class Character {
    public String name;
    public static int maxhp;
    public static int hp;
    public int level;
    public int attack;

    public Character(String name, int level, int maxhp, int attack) {
        this.hp = maxhp;
        this.level = level;
        this.name = name;
        this.maxhp = maxhp;
        this.attack = attack;

    }

    public int getLevel(){
        return level;
    }


    public int attack(Character character) {
        int damage = this.attack;
        character.hp -= damage;
        if (character.hp <= 0) {
            System.out.println(name + " has been defeated!");
        }
        return damage;
    }


    public boolean isDead() {
        return hp <=0;
        }
    }


