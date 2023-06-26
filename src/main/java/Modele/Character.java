package Modele;

public abstract class Character {
    public String name;
    public int maxhp;
    public  int hp;
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

    public String getName() {
        return name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp <= 0) {
            System.out.println(name + " has been defeated!");
        }
    }



    public boolean isDead() {
        return hp <=0;
        }


}



