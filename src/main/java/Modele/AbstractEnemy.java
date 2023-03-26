package Modele;

public abstract class AbstractEnemy extends Character {

    public AbstractEnemy(String name, int level, int maxhp, int attack) {
        super(name, level, maxhp, attack);
    }

    @Override
    public int attack(Character character) {
        return super.attack(character);
    }

    @Override
    public String isDead() {
        return super.isDead();
    }
}
