package Modele;

public class Potion {
    private String name;
    private int heal;

    public Potion(String name,int heal){
        this.name=name;
        this.heal=heal;
    }

    public void healpotioneffect(Wizard wizard){
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
    public void Attackpotioneffect(Wizard wizard){
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
}
