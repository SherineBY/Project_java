package Modele;

import java.util.ArrayList;
import java.util.List;

public class Enemy extends AbstractEnemy {
    private List<Enemy> enemies;
    public Enemy(String name, int level, int maxhp, int attack, int hp) {
        super(name, level, maxhp, attack, hp);
        enemies=new ArrayList<>();
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
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

