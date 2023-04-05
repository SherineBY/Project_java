package Modele;

public abstract class Spell {
    private String name;
    private static int levelRequired;
    // Autres champs et méthodes

    public Spell(String name, int levelRequired) {
        this.name = name;
        this.levelRequired = levelRequired;
    }

    public String getName() {
        return name;
    }

    public int getLevelRequired() {
        return levelRequired;
    }

    public void cast(Character character) {
        if (character.getLevel() >= levelRequired) {
            // Lancer le sort
        } else {
            System.out.println("you have not level require for use this spell");
        }
    }

}
