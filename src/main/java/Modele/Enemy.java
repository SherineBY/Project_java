package Modele;

public class Enemy extends AbstractEnemy  {

    public Enemy(String name, int level, int maxhp, int attack) {
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
