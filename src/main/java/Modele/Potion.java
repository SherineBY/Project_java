package Modele;

public class Potion {
    private String name;
    private int amount;
    private int damageAmount;

    public Potion(String name, int amount, int damageAmount) {
        this.name = name;
        this.amount = amount;
        this.damageAmount = damageAmount;
    }



    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public int getDamageAmount() {
        return damageAmount;
    }

    public static void useHealingPotion(Wizard wizard, int healAmount) {
        if (wizard.getHp() == wizard.getMaxHp()) {
            System.out.println("You are already at full health. No need to use a healing potion.");
        } else {
            int remainingHp = wizard.getHp() + healAmount;
            if (remainingHp > wizard.getMaxHp()) {
                remainingHp = wizard.getMaxHp();
            }
            int amountHealed = remainingHp - wizard.getHp();
            wizard.setHp(remainingHp);
            System.out.println("You used a healing potion and healed " + amountHealed + " HP. Your current HP is " + wizard.getHp() + ".");
        }
    }

    public static void useAttackPotion(Enemy enemy, Wizard playerWizard, int damageAmount) {
        int remainingHp = enemy.getHp() - damageAmount;
        if (remainingHp < 0) {
            remainingHp = 0;
        }
        int damageDealt = damageAmount - remainingHp;
        enemy.takeDamage(damageDealt);
        System.out.println("You used an attack potion and dealt " + damageDealt + " damage to " + enemy.getName() + ". " + enemy.getName() + "'s current HP is " + enemy.getHp() + ".");
    }


}
