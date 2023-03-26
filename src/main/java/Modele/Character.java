package Modele;

public abstract class Character {
    public String name;
    public int maxhp, hp, level, attack;

    public Character(String name, int level, int maxhp, int attack) {
        this.hp = maxhp;
        this.level = level;
        this.name = name;
        this.maxhp = maxhp;
        this.attack = attack;

    }

    public int attack(Character character) {
        int damage = this.attack;
        character.hp -= damage;
        if (character.hp <= 0) {
            System.out.println(name + " has been defeated!");
        }
        return damage;
    }


    public String isDead() {
        if (this.hp <= 0) {
            return "You have been defeated!";
        } else {
            return "Enemy has been defeated!";
        }
    }

}
