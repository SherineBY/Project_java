package Modele;

public class Enemy extends AbstractEnemy  {
    public Enemy(String name, int level, int maxhp, int attaque) {
        super(name, level, maxhp, attaque);
    }

    @Override
    public boolean isDead() {
        return super.isDead();
    }

    @Override
    public int attack(Character character) {
        return super.attack(character);
    }
}
