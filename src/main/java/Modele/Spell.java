package Modele;

public abstract class Spell {
    private String name;
    private int levelRequired;
    private Core core;

    public Spell(String name, int levelRequired, Core core) {
        this.name = name;
        this.levelRequired = levelRequired;
        this.core = core;
    }

    public String getName() {
        return name;
    }

    public int getLevelRequired() {
        return levelRequired;
    }

    public Core getCore() {
        return core;
    }

    public void cast(Enemy enemy, int wandSize) {
        int damage = calculateDamage(wandSize);
        enemy.takeDamage(damage);
        System.out.println("You cast " + getName() + " and dealt " + damage + " damage to " + enemy.getName() + ".");
    }

    public int calculateDamage(int wandSize) {
        int baseDamage = 10; // Dégâts de base du sort
        int sizeMultiplier = 2; // Multiplicateur basé sur la taille de la baguette (à titre d'exemple)

        int damage = baseDamage + (wandSize * sizeMultiplier);
        return damage;
    }
}