package Modele;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class GameConsole {



        private Wizard Playerwizard;
        private Wand wand;
        private House house;
        private List<Enemy> enemies;
        private AbstractEnemy currentEnemy;
        public House choiceHouse(){
                ThreadLocalRandom threadLocalRandom= ThreadLocalRandom.current();
                Random house = new Random();
                int houseindex = threadLocalRandom.nextInt(House.values().length);
                return House.values()[houseindex];
        }

        public Core choiceCore(){
                ThreadLocalRandom threadLocalRandom=ThreadLocalRandom.current();
                Random core = new Random();
                int coreindex=threadLocalRandom.nextInt(Core.values().length);
                return Core.values()[coreindex];
        }
    public Wizard startofgame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("what is your name?");
        String name = scanner.nextLine();
        Pet petName = null;
        Wand wand = null;
        Playerwizard = new Wizard(name, 1, 100, 0, petName, wand, choiceHouse());
        AbstractEnemy currentEnemy = this.enemies.get(Playerwizard.getLevel() - 1);
        System.out.println("hello young wizard " + name + " welcome to Hogwarts ");
        System.out.println("you will now participate in the sorting ceremony in which the SortingHat will define to which house you belong ");
        System.out.println("Difficult, very difficult... I see a lot of courage and intellectual qualities too. There's talent, " +
                "oh yes, and a great desire to prove yourself. So where do I put you?");
        System.out.println("Okey I know!you are " + choiceHouse());
        System.out.println("Now go the Ollivander shop, you will be assigned a wand ");
        wand = new Wand(choiceCore(), 25);
        Playerwizard.setWand(wand);
        System.out.println("Okey now you have Wand .The core is " + wand.getCore() + "and the size of your hand is " + wand.getSize() + "cm");
        System.out.println(" before you enter Hogwarts you have to choose your pet ");
        System.out.println("Choose your pet among this list: " + Arrays.toString(Pet.values()));
        petName = Pet.valueOf(scanner.nextLine());
        Playerwizard.setPet(petName);
        System.out.println("You have chosen " + petName + " as your pet.");
        return Playerwizard;
    }

    public List<Enemy> defineEnemies(){
        this.enemies=new ArrayList<>();
        Enemy enemylevel1=new Enemy("troll",1,100,10,100);
        Enemy enemylevel2=new Enemy("basilik",2,100,15,100);
        Enemy enemylevel3=new Enemy("detraquors",3,100,20,100);
        Enemy enemylevel4bis=new Enemy("Peter Pettigrow",4,100,25,100);
        Enemy enemylevel4=new Enemy("voldemort",4,100,50,100);
        Enemy enemylevel5=new Enemy("Dolores Ombrage",4,100,30,100);
        Enemy enemylevel6=new Enemy("the death eaters",5,100,35,100);

        this.enemies.add(enemylevel1);
        this.enemies.add(enemylevel2);
        this.enemies.add(enemylevel3);
        this.enemies.add(enemylevel4);
        this.enemies.add(enemylevel4bis);
        this.enemies.add(enemylevel5);
        this.enemies.add(enemylevel6);

        return enemies;
    }
    public void level() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue au niveau de la Pierre Philosophale");
        List<Enemy> enemies = defineEnemies();
        Enemy currentEnemy = enemies.get(Playerwizard.getLevel() - 1);
        while (Playerwizard.getHp() > 0 && currentEnemy.getHp() > 0) {
            System.out.println("\n" + Playerwizard.getName() + ", what do you want to do");
            System.out.println("1. use potion");
            System.out.println("2. use spell");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("1. Boire une potion de guérison");
                System.out.println("2. Boire une potion d'attaque");
                int choicePotion = scanner.nextInt();
                if (choicePotion==1) {
                    System.out.println("1. drink heal potion ");
                    System.out.println("2. drink immunity potion");
                    int choisehealPotion= scanner.nextInt();
                    if (choisehealPotion==1) {
                        Potion healPotion = Playerwizard.getPotionOfType("heal potion");
                        Potion.healpotioneffect(Playerwizard);
                        Playerwizard.removePotion(healPotion);
                    }else{
                        Potion immunityPotion = Playerwizard.getPotionOfType("immunity potion");
                        Potion.healpotioneffect(Playerwizard);
                        Playerwizard.removePotion(immunityPotion);
                    }
                } else {
                    System.out.println("you have chosen an attack potion so you will poison your enemy ");
                    Potion Attackpotion = Playerwizard.getPotionOfType("poison potion attack");
                    Potion.attackpotioneffect(currentEnemy);
                    Playerwizard.removePotion(Attackpotion);
                }
            } else if (choice == 2) {
                System.out.println("Choose a spell to use: " + Arrays.toString(AbstractSpell.values()));
                AbstractSpell spell = AbstractSpell.valueOf(scanner.next());
                if (Playerwizard.getWand().getCore() == AbstractSpell.getCore()) {
                    System.out.println("The wand and the spell have the same core, the spell is twice as effective!");
                    AbstractSpell.cast(currentEnemy, Playerwizard.getWand().getSize() * 2);
                } else {
                    AbstractSpell.cast(currentEnemy, Playerwizard.getWand().getSize());
                }
                System.out.println("You used " + AbstractSpell.getName() + " and dealt " + currentEnemy.getAttack() + " damage to " + currentEnemy.getName() + ".");
            }
            }
        }

        if (Playerwizard.getHp() > 0) {
            System.out.println("\nFélicitations, vous avez vaincu " + currentEnemy.getName() + " !");
            Playerwizard.levelUp();
            System.out.println("Vous êtes maintenant au niveau " + Playerwizard.getLevel() + ".");
            level();
        } else {
            System.out.println("\n" + currentEnemy.getName() + " vous a vaincu. Game Over.");
        }
        }
}












