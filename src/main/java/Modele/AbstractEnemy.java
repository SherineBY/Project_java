package Modele;

public abstract class AbstractEnemy extends Character {


    public AbstractEnemy(String name, int level, int maxhp, int attack, int hp) {
        super(name, level, maxhp, attack);
        this.hp=maxhp;
    }

    public int getHp(){
        return hp;
    }
    public void setHp(){
        this.hp=hp;
    }
    public String getName(){
        return name;
    }

    @Override
    public int attack(Character character) {
        return super.attack(character);
    }

    @Override
    public boolean isDead() {
        return super.isDead();
    }
}
