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
    public void level(int level) {
        currentEnemy = enemies.get(level-1);
        }

    public void level() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("welcome to The Philosopher’s Stone level");
        Enemy enemies = Playerwizard.defineEnemy();

        while (Playerwizard.getHp() > 0 && enemies.getHp() > 0) {
            System.out.println("\n" + Playerwizard.getName() + ", que voulez-vous faire?");
            System.out.println("1. Boire une potion de guérison ou d'immortalité");
            System.out.println("2. Utiliser une potion d'attaque");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    List<Potion> potions = Playerwizard.getPotions();
                    System.out.println("Quelle potion voulez-vous utiliser?");
                    for (int i = 0; i < potions.size(); i++) {
                        System.out.println(i + 1 + ". " + potions.get(i).getName());
                    }
                    int potionChoice = scanner.nextInt();
                    Potion potion = potions.get(potionChoice - 1);
                    if (potion instanceof HealPotion) {
                        Playerwizard.heal(((HealPotion) potion).getHeal());
                        System.out.println(Playerwizard.getName() + " a bu une potion de guérison et a maintenant " + wizard.getHp() + " points de vie.");
                    } else if (potion instanceof ImmortalityPotion) {
                        Playerwizard.setImmune(true);
                        System.out.println(Playerwizard.getName() + " a bu une potion d'immortalité et est maintenant immunisé contre les attaques ennemies.");
                    }
                    Playerwizard.usePotion();
                    break;
                case 2:
                    Playerwizard.attackPotionEffect(enemy);
                    if (enemies.isDead()) {
                        System.out.println("Vous avez vaincu " + enemies.getName() + " et pouvez passer au niveau suivant!");
                        level++;
                    } else {
                        enemies.attack(Playerwizard);
                    }
                    break;
                default:
                    System.out.println("Choix invalide.");
                    break;
            }
        }
        if (Playerwizard.getHp() > 0) {
            System.out.println("Félicitations, vous avez terminé le niveau " + level + "!");
        } else {
            System.out.println("Dommage, vous avez perdu. Veuillez réessayer.");
        }
    }
}












