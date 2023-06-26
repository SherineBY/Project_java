package Modele;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class GameConsole {

    private Wizard playerWizard;
    private List<Enemy> enemies;
    private Enemy currentEnemy;

    public House choiceHouse() {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        Random house = new Random();
        int houseIndex = threadLocalRandom.nextInt(House.values().length);
        return House.values()[houseIndex];
    }

    public Core choiceCore() {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        Random core = new Random();
        int coreIndex = threadLocalRandom.nextInt(Core.values().length);
        return Core.values()[coreIndex];
    }

    public Wizard startOfGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        Pet petName = null;
        Wand wand = null;
        House house = choiceHouse();
        playerWizard = new Wizard(name, 1, 100, 0, petName, wand, house);
        System.out.println("Hello young wizard " + name + ", welcome to Hogwarts!");
        System.out.println("You will now participate in the sorting ceremony, in which the Sorting Hat will determine to which house you belong.");
        System.out.println("Difficult, very difficult... I see a lot of courage and intellectual qualities too. There's talent, oh yes, and a great desire to prove yourself. So, where do I put you?");
        playerWizard.setHouse(house);
        System.out.println("Okay, I know! You are in " + house);
        System.out.println("Now, go to Ollivander's shop. You will be assigned a wand.");
        wand = new Wand(choiceCore(), 25);
        playerWizard.setWand(wand);
        System.out.println("Okay, now you have a wand. The core is " + wand.getCore() + " and the size of your hand is " + wand.getSize() + " cm.");
        System.out.println("Before you enter Hogwarts, you have to choose your pet.");
        System.out.println("Choose your pet from this list: " + Arrays.toString(Pet.values()));
        petName = Pet.valueOf(scanner.nextLine());
        playerWizard.setPet(petName);
        System.out.println("You have chosen " + petName + " as your pet.");
        return playerWizard;
    }

    public List<Enemy> defineEnemies() {
        this.enemies = new ArrayList<>();
        Enemy enemyLevel1 = new Enemy("Troll", 1, 100, 10, 100);
        Enemy enemyLevel2 = new Enemy("Basilisk", 2, 100, 15, 100);
        Enemy enemyLevel3 = new Enemy("Dementors", 3, 100, 20, 100);
        Enemy enemyLevel4bis = new Enemy("Peter Pettigrew", 4, 100, 25, 100);
        Enemy enemyLevel4 = new Enemy("Voldemort", 4, 100, 50, 100);
        Enemy enemyLevel5 = new Enemy("Dolores Umbridge", 4, 100, 30, 100);
        Enemy enemyLevel6 = new Enemy("Death Eaters", 5, 100, 35, 100);

        this.enemies.add(enemyLevel1);
        this.enemies.add(enemyLevel2);
        this.enemies.add(enemyLevel3);
        this.enemies.add(enemyLevel4);
        this.enemies.add(enemyLevel4bis);
        this.enemies.add(enemyLevel5);
        this.enemies.add(enemyLevel6);

        return enemies;
    }

    public void level() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the level of the Philosopher's Stone!");
        defineEnemies();
        currentEnemy = enemies.get(playerWizard.getLevel() - 1);
        Potion healPotion = new Potion("Healing Potion", 20,10);
        Potion attackPotion = new Potion("Attack Potion", 10,20);
        AbstractSpell[] spells = {
                new AbstractSpell("Wingardium Leviosa", 1, Core.Phoenix_feather) {
                    @Override
                    public int getDamage() {

                        return 10;
                    }
                },
                new AbstractSpell("Expecto Patronum", 2, Core.Horned_serpent_horn) {
                    @Override
                    public int getDamage() {

                        return 15;
                    }
                },
                new AbstractSpell("Accio", 3, Core.Dragon_heartsring) {
                    @Override
                    public int getDamage() {

                        return 5;
                    }
                },
                new AbstractSpell("Sectumsempra", 4, Core.Unicorn_hair) {
                    @Override
                    public int getDamage() {

                        return 20;
                    }
                },
                new AbstractSpell("Expelliarmus", 5, Core.Troll_whisker) {
                    @Override
                    public int getDamage() {

                        return 8;
                    }
                }
        };

        while (playerWizard.getHp() > 0 && currentEnemy.getHp() > 0) {
            System.out.println("\n" + playerWizard.getName() + ", what do you want to do?");
            System.out.println("1. Use potion");
            System.out.println("2. Use spell");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("1. Drink healing potion");
                System.out.println("2. Drink attack potion");
                int choicePotion = scanner.nextInt();
                if (choicePotion == 1) {
                    System.out.println("You have chosen a healing potion.");
                    Potion.useHealingPotion(playerWizard, healPotion.getAmount());
                } else if (choicePotion == 2) {
                    System.out.println("You have chosen an attack potion.");
                    Potion.useAttackPotion(currentEnemy, playerWizard, attackPotion.getDamageAmount());

                }
            } else if (choice == 2) {
                System.out.println("Choose a spell to use:");
                for (int i = 0; i < spells.length; i++) {
                    System.out.println((i + 1) + ". " + spells[i].getName());
                }
                int spellChoice = scanner.nextInt();
                if (spellChoice >= 1 && spellChoice <= spells.length) {
                    AbstractSpell spell = spells[spellChoice - 1];
                    spell.cast(currentEnemy, playerWizard.getWand().getSize());
                    System.out.println("You used " + spell.getName() + " and dealt " + spell.getDamage() + " damage to " + currentEnemy.getName() + ".");
                } else {
                    System.out.println("Invalid spell choice. Please try again.");
                }
            }
        }

        if (playerWizard.getHp() > 0) {
            System.out.println("\nCongratulations, you have defeated " + currentEnemy.getName() + "!");
            playerWizard.levelUp();
            System.out.println("You are now at level " + playerWizard.getLevel() + ".");
            level();
        } else {
            System.out.println("\n" + currentEnemy.getName() + " has defeated you. Game Over.");
        }
    }
    public void level7() {
        AbstractSpell[] spells = {
                new AbstractSpell("expelliarmus !", 7, Core.Phoenix_feather) {
                    @Override
                    public int getDamage() {

                        return 10;
                    }
                },
                new AbstractSpell("avada kedavra", 7, Core.Phoenix_feather) {
                    @Override
                    public int getDamage() {

                        return 10;
                    }
                },
        };

        System.out.println("Welcome to Level 7 - Battle Against the Bosses!");
        System.out.println("Welcome to Level 7 - Battle Against the Bosses!");
        Core core = Core.Phoenix_feather;
        Boss voldemort = new Boss("Voldemort", 7, 100, 50, currentEnemy.maxhp, 50, 15, "Avada Kedavra", core, 25);
        Boss bellatrix = new Boss("Bellatrix Lestrange", 7, 100, 30, currentEnemy.maxhp, 50, 15, "expelliarmus", core, 0);

        voldemort.setCore(core);

        Potion healPotion = new Potion("Healing Potion", 20,10);
        Potion attackPotion = new Potion("Attack Potion", 30,20);

        Scanner scanner = new Scanner(System.in);

        // Fight against Voldemort
        System.out.println("\nPrepare to face Voldemort!");
        while (playerWizard.getHp() > 0 && voldemort.getHp() > 0) {
            System.out.println("\n" + playerWizard.getName() + ", what do you want to do?");
            System.out.println("1. Use potion");
            System.out.println("2. Use spell");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("1. Drink healing potion");
                System.out.println("2. Drink attack potion");

                int choicePotion = scanner.nextInt();

                if (choicePotion == 1) {
                    System.out.println("You have chosen a healing potion.");
                    Potion.useHealingPotion(playerWizard, healPotion.getAmount());
                } else if (choicePotion == 2) {
                    System.out.println("You have chosen an attack potion.");
                    if (playerWizard.getWand().getCore() == voldemort.getWand().getCore()) {
                        System.out.println("Your wand shares the same core as Voldemort's wand. Something unpredictable happens!");
                        // Implement unpredictable behavior here
                    } else {
                        Potion.useAttackPotion(voldemort, playerWizard, attackPotion.getDamageAmount());
                    }
                }
            } else if (choice == 2) {
                System.out.println("Choose a spell to use:");
                int spellChoice = scanner.nextInt();

                if (spellChoice >= 1 && spellChoice <= spells.length) {
                    AbstractSpell spell = spells[spellChoice - 1];
                    if (voldemort.getName().equals("Voldemort") && spell.getName().equals("Expelliarmus")) {
                        System.out.println("You used Expelliarmus and successfully countered Avada Kedavra!");
                        // Implement counter logic for Avada Kedavra here
                    } else {
                        spell.cast(voldemort, playerWizard.getWand().getSize());
                        System.out.println("You used " + spell.getName() + " and dealt " + spell.getDamage() + " damage to " + voldemort.getName() + ".");
                    }
                } else {
                    System.out.println("Invalid spell choice. Please try again.");
                }
            }
        }

        if (playerWizard.getHp() > 0) {
            System.out.println("\nCongratulations, you have defeated Voldemort!");
            playerWizard.levelUp();
            System.out.println("You are now at level " + playerWizard.getLevel() + ".");
        } else {
            System.out.println("\nVoldemort has defeated you. Game Over.");
            return; // Exit the level if the player is defeated
        }

        // Fight against Bellatrix Lestrange
        System.out.println("\nPrepare to face Bellatrix Lestrange!");
        while (playerWizard.getHp() > 0 && bellatrix.getHp() > 0) {
            System.out.println("\n" + playerWizard.getName() + ", what do you want to do?");
            System.out.println("1. Use potion");
            System.out.println("2. Use spell");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("1. Drink healing potion");
                System.out.println("2. Drink attack potion");

                int choicePotion = scanner.nextInt();

                if (choicePotion == 1) {
                    System.out.println("You have chosen a healing potion.");
                    Potion.useHealingPotion(playerWizard, healPotion.getAmount());
                } else if (choicePotion == 2) {
                    System.out.println("You have chosen an attack potion.");
                    if (playerWizard.getWand().getCore() == bellatrix.getWand().getCore()) {
                        System.out.println("Your wand shares the same core as Bellatrix Lestrange's wand. Something unpredictable happens!");
                        // Implement unpredictable behavior here
                    } else {
                        Potion.useAttackPotion(bellatrix, playerWizard, attackPotion.getDamageAmount());
                    }
                }
            } else if (choice == 2) {
                System.out.println("Choose a spell to use:");
                // Add your spells here
                int spellChoice = scanner.nextInt();

                if (spellChoice >= 1 && spellChoice <= spells.length) {
                    AbstractSpell spell = spells[spellChoice - 1];
                    spell.cast(bellatrix, playerWizard.getWand().getSize());
                    System.out.println("You used " + spell.getName() + " and dealt " + spell.getDamage() + " damage to " + bellatrix.getName() + ".");
                } else {
                    System.out.println("Invalid spell choice. Please try again.");
                }
            }
        }

        if (playerWizard.getHp() > 0) {
            System.out.println("\nCongratulations, you have defeated Bellatrix Lestrange!");
            playerWizard.levelUp();
            System.out.println("You are now at level " + playerWizard.getLevel() + ".");
        } else {
            System.out.println("\nBellatrix Lestrange has defeated you. Game Over.");
        }
    }


}

