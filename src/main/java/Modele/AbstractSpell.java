package Modele;

public abstract class AbstractSpell extends Spell {

    public abstract int getDamage();

    public AbstractSpell(String name, int levelRequired, Core core) {
        super(name, levelRequired, core);
    }

    @Override
    public int getLevelRequired() {
        return super.getLevelRequired();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void cast(Enemy enemy, int wandSize) {
        int damage = calculateDamage(wandSize);
        enemy.takeDamage(damage);
        System.out.println("You cast " + getName() + " and dealt " + damage + " damage to " + enemy.getName() + ".");
    }

}

