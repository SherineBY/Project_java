package Modele;

public abstract class AbstractEnemy extends Character {


    public AbstractEnemy(String name, int level, int maxhp, int attack, int hp) {
        super(name, level, maxhp, attack);
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
