package Modele;

public abstract class AbstractSpell extends Spell {


    public AbstractSpell(String name, int levelRequired) {
        super(name, levelRequired);
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
    public void cast(Character character) {
        super.cast(character);
    }
}
