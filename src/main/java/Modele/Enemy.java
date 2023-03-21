package Modele;

public class Enemy extends AbstractEnemy  {

    public Enemy(String name, int level, int maxhp, int attack) {
        super(name, level, maxhp, attack);
    }

    @Override
    public int attack() {
        return 0;
    }
}
