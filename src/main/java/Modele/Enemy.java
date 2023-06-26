package Modele;

import java.util.ArrayList;
import java.util.List;

public class Enemy extends AbstractEnemy {
    private List<Enemy> enemies;
    public Enemy(String name, int level, int maxhp, int attack, int hp) {
        super(name, level, maxhp, attack, hp);
        enemies=new ArrayList<>();
    }
    public int getHp() {
        return hp;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }


    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
    }

    @Override
    public boolean isDead() {
        return super.isDead();
    }
}

