package Modele;

public class Potion {
    private String name;
    private int heal;

    public Potion(String name,int heal){
        this.name=name;
        this.heal=heal;
    }

    public int getHeal() {
        return heal;
    }

    public String getName() {
        return name;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static void healpotioneffect(Wizard wizard){
        if (wizard.hp == wizard.maxhp) {
            System.out.println("You are already full hp ! You don't need to use a potion !");
        } else {
            int heal = wizard.hp + this.heal;
            if (heal >= wizard.maxhp) {
                wizard.hp = wizard.maxhp;
                System.out.println("You use a potion and heal : " + wizard.maxhp);
            }
            System.out.println("You use a potion and heal : " + wizard.hp);
        }


    }

    public static void attackpotioneffect(AbstractEnemy enemy){
        int damage = this.heal;
        enemy.hp -= damage;
        System.out.println("You use a potion and deal " + damage + " damage to the enemy!");
        if (enemy.isDead()) {
            System.out.println("You have defeated the enemy and can proceed to the next level!");
        }
    }

}
