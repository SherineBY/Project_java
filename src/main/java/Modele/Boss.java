package Modele;

import java.util.concurrent.ThreadLocalRandom;

public class Boss extends Enemy{
    private int damage;
    private int mana;
    private String specialAbility;

    private Wand wand;
    private Core core;



    public Boss(String name, int level, int maxhp, int attack, int hp, int damage, int mana, String specialAbility, Core core, int size) {
        super(name, level, maxhp, attack, hp);
        this.damage = damage;
        this.mana = mana;
        this.specialAbility = specialAbility;
        this.wand = new Wand(core, size);
        this.core = core;
    }
    public void setCore(Core core) {
        this.core = core;
    }


    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public int getMana() {
        return mana;
    }

    public String getSpecialAbility() {
        return specialAbility;
    }

    public Wand getWand() {
        return wand;
    }

    public void setWand(Wand wand) {
        this.wand = wand;
    }

    public void useSpecialAbility(Wizard player, AbstractSpell[] spells, Potion attackPotion) {
        if (name.equals("Voldemort")) {
            if (player.getWand().getCore() == Core.Phoenix_feather) {
                System.out.println("Something unpredictable happens when your wand and Voldemort's wand share the same core (PHOENIX_FEATHER)!");

            } else {
                System.out.println(name + " uses special ability: " + specialAbility);
                int damageAmount = attackPotion.getDamageAmount();

            }

        } else if (name.equals("Bellatrix Lestrange")) {
            // Gérer la capacité spéciale de Bellatrix Lestrange
            System.out.println(name + " uses special ability: " + specialAbility);
            AbstractSpell spell = spells[ThreadLocalRandom.current().nextInt(spells.length)];
            spell.cast(this, player.getWand().getSize());
            // ...
        }
    }


    public void attack(Wizard wizard) {
        wizard.takeDamage(damage);
        System.out.println(name + " attacked " + wizard.getName() + " and dealt " + damage + " damage.");
    }
    public void takeDamage(int damage) {
        hp -= damage;
        if (hp <= 0) {
            System.out.println(name + " has been defeated!");
        }
    }
}
