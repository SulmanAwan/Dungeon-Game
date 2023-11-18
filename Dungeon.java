import java.util.Random;
import java.util.Scanner;

public class Dungeon
{
	private Random generator;
	private Scanner scan;
	private Cell head;
	private Cell tail;
	private Cell player; 
	private String playerName;
	private boolean isAlive = true;
	private int playerIndex; 
	private int size;
	private int floor = 1;
	private int print;
	
	public Dungeon()
	{
		scan = new Scanner(System.in);
		
		System.out.print("Enter your player's name: ");
		playerName = scan.nextLine();
		
		createDungeon(null);
	}
		
	private void createDungeon(Player plyr)
	{
		head = null;
		tail = null;
		print = 0;
		size = 0;
		generator = new Random();
		
		play(playerName, plyr);
		
		if(print == 0)
		{
			System.out.println("You died");
		}
		print++;
	}
	
	private void add()
	{
		Cell newNode = new Cell(randomEncounter());	
		
		if(isEmpty())								
		{
			head = newNode;							
			tail = newNode;
		}
		else
		{
	        
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			newNode.setNext(head);
			tail = newNode;
			head.setPrevious(tail);
			
		}
	}
	
	public void remove(Cell cellToRemove)
	{
		Cell previous = cellToRemove.getPrevious();
		Cell next = cellToRemove.getNext();
		
		previous.setNext(next);
		next.setPrevious(previous);
		size--;
	}
	
	private Encounter randomEncounter()
	{
		int randomValue;
		Encounter randomEncounter = null;
		
		//Cases 1-7 (mobs)
		//Cases 8-14 (permanent items)
		//Cases 15-21 (one-time-use items)
		randomValue = generator.nextInt(50) + 1;
		
		switch(randomValue)
		{
		case 1: //monster types:
			
			//Slime (threat: very low)
			randomEncounter = new Slime("Slime", 5, 5, 0, 5, 40, floor);
			break;
			
		case 2:
			
			//Goblin (threat: low)
			randomEncounter = new Goblin("Goblin", 5, 5, 5, 5, 40, floor);
			break;
				
		case 3:
			
			//Zombie (threat: low)
			randomEncounter = new Zombie("Zombie", 10, 5, 5, 5, 40, floor);
			break;
			
		case 4:
			
			//Ghost (threat: medium)
			randomEncounter = new Ghost("Ghost", 10, 25, 0, 10, 50, floor);
			break;
			
		case 5:
			
			//Ogre (threat: medium)
			randomEncounter = new Ogre("Ogre", 15, 10, 10, 10, 100, floor);
			break;
			
		case 6:
			
			//Demon (threat: high)
			randomEncounter = new Demon("Demon", 15, 20, 15, 30, 100, floor);
			break;
			
		case 7:
			
			//Dragon (threat: high)
			randomEncounter = new Dragon("Dragon", 25, 25, 15, 40, 200, floor);
			break;
			
		case 8: //perm item types:
			
			//Iron sword (perm item, buff: attack, de-buff: none)
			randomEncounter = new IronSword("Iron_Sword", 15, 0);
			break;
			
		case 9:
			
			//Heavy Axe (perm item, buff: attack, de-buff: speed)
			randomEncounter = new HeavyAxe("Heavy_Axe", 20, -10);
			break;
			
		case 10:
			
			//Iron armor (perm item, buff: defense, de-buff: speed)
			randomEncounter = new IronArmor("Iron_Armor", 20, -10);
			break;
			
		case 11:
			
			//Iron Boots (perm item, buff: defense, de-buff: speed)
			randomEncounter = new IronBoots("Iron_Boots", 15, -10);
			break;
			
		case 12:
			
			//Swift boots (perm item, buff: speed, de-buff: none)
			randomEncounter = new SpeedBoots("Speed_Boots", 30, 0);
			break;
			
		case 13:
			
			//Experience ring (perm item, buff: x2 defense, debuff: -40 attack)
			randomEncounter = new DarknessRing("Darkness_Ring", 2, -40);
			break;
			
		case 14:
			
			//Flame ring (perm item, buff: attack, de-buff: none)
			randomEncounter = new FireRing("Fire_Ring", 20, 0);
			break;
			
		case 15: //single-use item types:
			
			//Red Healing potion: (effect: +25 health)
			randomEncounter = new RedHealingPotion("Red_Healing_Potion", 25, 0);
			break;
			
		case 16:
			
			//Blue Healing potion: (effect: +50 health)
			randomEncounter = new BlueHealingPotion("Blue_Healing_Potion", 50, 0);
			break;
			
		case 17:
			
			//Golden healing potion: (effect: +150 health)
			randomEncounter = new GoldenHealingPotion("Golden_Healing_Potion", 150, 0);
			break;
			
		case 18:
			
			//Purple Attack potion: (effect: +40 attack)
			randomEncounter = new PurpleAttackPotion("Purple_Attack_Potion", 40, 0);
			break;
			
		case 19:
			//Golden attack potion: (effect +100 attack)
			randomEncounter = new GoldenAttackPotion("Golden_Attack_Potion", 100, 0);
			break;
			
		case 20:
			
			//Shield potion: (effect: +30 defense against 1 monster)
			randomEncounter = new ShieldPotion("Shield_Potion", 30, 0);
			break;
			
		case 21:
			
			//Speed potion: (effect: +40 speed against 1 monster)
			randomEncounter = new SpeedPotion("Speed_Potion", 40, 0);
			break;
			
		case 22: //monster types:
			
			//Slime (threat: very low)
			randomEncounter = new Slime("Slime", 5, 5, 0, 5, 40, floor);
			break;
			
		case 23:
			
			//Goblin (threat: low)
			randomEncounter = new Goblin("Goblin", 5, 5, 5, 5, 40, floor);
			break;
				
		case 24:
			
			//Zombie (threat: low)
			randomEncounter = new Zombie("Zombie", 10, 5, 5, 5, 40, floor);
			break;
			
		case 25:
			
			//Ghost (threat: medium)
			randomEncounter = new Ghost("Ghost", 10, 25, 0, 10, 50, floor);
			break;
			
		case 26:
			
			//Ogre (threat: medium)
			randomEncounter = new Ogre("Ogre", 15, 10, 10, 10, 100, floor);
			break;
			
		case 27:
			
			//Demon (threat: high)
			randomEncounter = new Demon("Demon", 15, 20, 15, 30, 100, floor);
			break;
			
		case 28:
			
			//Dragon (threat: high)
			randomEncounter = new Dragon("Dragon", 25, 25, 15, 40, 200, floor);
			break;
			
		case 29:
			
			randomEncounter = new RedHealingPotion("Red_Healing_Potion", 25, 0);
			break;
			
		case 30:
			
			randomEncounter = new BlueHealingPotion("Blue_Healing_Potion", 50, 0);
			break;
			
		case 40:
			
			randomEncounter = new GoldenHealingPotion("Golden_Healing_Potion", 150, 0);
			break;
			
			
		default:
			
			randomEncounter = new Empty(" ");
			break;
		}
		
		return randomEncounter;
	}
	
	private void generateDungeon(String playerName, Player newPlayer) 
	{
		int randomValue = generator.nextInt(5)+10; 
		size = randomValue;

		for(int i = 0; i < randomValue; i++)
		{
			add();		
		}

		if(newPlayer == null)
		{
			spawn(new Player(playerName, 150, 10, 30, 40), new Door("Door"));
		}
		else
		{
			spawn(newPlayer, new Door("Door"));
		}
		player = retrievePlayerCell();
		
	}

	private void spawn(Encounter typePlayer, Encounter typeDoor)
	{
		int playerValue;
		int doorValue;
		
		do
		{
			playerValue = generator.nextInt(size); 
			doorValue = generator.nextInt(size);
			
		} while(playerValue == doorValue);
		
		inserter(typeDoor, doorValue);	
		inserter(typePlayer, playerValue);
	}
	
	private void inserter(Encounter type, int index)
	{
		Cell current = head;
		
		for(int i = 0; i < size; i++)
		{
			if(index == i)
			{
				current.setEncounter(type); 
			}
			current = current.getNext();
		}
	}
	
	private Cell retrievePlayerCell()
	{
		Cell current = head;
		
		for(int i = 0; i < size; i++)
		{
			if(current.getEncounter() instanceof Player)
			{
				playerIndex = i;
				return current;
			}
			current = current.getNext();
		}
		return null;
	}
		
	public void printEntireDungeon()
	{
		Cell current = head;
		
		while(current.getNext() != head)
		{
			System.out.print("[ ");
			System.out.print(current.getEncounter());					
			current = current.getNext();
			System.out.print(" ]"); 
		}
		System.out.print("[ " + current.getEncounter() + " ]");
	}
	
	public void printPlayerCenter()
	{
		Cell current = head;
		int midpoint = size/2;
		
		for(int i = 0; i < playerIndex + 1 + midpoint; i++)	
		{
			current = current.getNext();
		}
		
		for(int i = 0; i < size; i++) 
		{
			System.out.print("[ ");
			System.out.print(current.getEncounter());
			System.out.print(" ]");
			current = current.getNext();
		}
	}
	
	public int size()
	{
		return size;
	}
	
	private boolean isEmpty()
	{
		if(head == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	

	private void play(String playerName, Player newPlayer) 
	{
		int movement;
		generateDungeon(playerName, newPlayer);
		Player user = (Player) retrievePlayerCell().getEncounter();
		System.out.println("\n----------------------------------------------------\n");
		
		while(isAlive)
		{
			printPlayerCenter();
			System.out.println("\nDungeon size: " + size() + "\t\tDungeon Floor: " + floor);
			System.out.println("\n" + playerName + "'s Current Stats: ");
			System.out.print("Player Health: " + user.getLife() + "   ");
			System.out.print("Player Defense: " + user.getDefense() + "   ");
			System.out.print("Player Damage: " + user.getAttack() + "   ");
			System.out.print("Player Speed: " + user.getSpeed() + "   ");
			System.out.print("Player Level: " + user.getLevel() + "   ");
			System.out.print("Player Experience: " + user.getEXP() + "   ");
			
			System.out.println("\n\nWhere would you like to move? \n1. Right\n2. Left");
			movement = scan.nextInt();
			System.out.println("\n----------------------------------------------------\n");
			
			move(movement);
			
			if(!user.isAlive()) 
			{
				isAlive = false;
			}
		}
	}
	
	private void move(int direction)		//direction = 1 (move right), direction = 2 (move left)
	{
		Player user = (Player) player.getEncounter(); 
		Monster monster;
		Item item;
		Door door;
		int userInput;
		int firstAttack;
		boolean empty = false;
		
		
		//moving right
		if(direction == 1)		
		{
			if(player.getNext().getEncounter() instanceof Monster)
			{
				monster = (Monster) player.getNext().getEncounter();

				user.displayInventory();
				System.out.println("\n\nYou ran into a " + monster.getName() + "! ");
				System.out.println("\n" + monster.getName() + "'s Current Stats: ");
				System.out.print(monster.getName() + " Health: " + monster.getLife() + "   ");
				System.out.print(monster.getName() + " Defense: " + monster.getDefense() + "   ");
				System.out.print(monster.getName() + " Damage: " + monster.getAttack() + "   ");
				System.out.print(monster.getName() + " Speed: " + monster.getSpeed() + "   ");
				
				if(user.getInventorySize() != 0)
				{
					
					System.out.println("\n\nWould you like to use any of your one-time-use items?");
					System.out.println("Enter the index of the item you want to use or enter -1 to not use any:");
					userInput = scan.nextInt();
					
					user.useItem(userInput);
					
					
				}
				System.out.println("\n\nDo you wish to attack it the monster? ");
				System.out.println("1. Attack \n2. Run Past \nNote: If you run past a monster you will be hit.");
				
				userInput = scan.nextInt();
				System.out.println("\n----------------------------------------------------\n");
				
				if(userInput == 1) //fight
				{
					firstAttack = determineSpeed(user, monster); //returns 1 if user faster, 0 is monster faster
					user.combat(monster, firstAttack);
					
					if(user.isAlive())
					{
						user.gainExperience(monster);
						remove(player.getNext());
						
					}
				}
				else if(userInput == 2)//run
				{
					player.setEncounter(new Empty(" "));
					//user.getHit(monster);
					player = player.getNext();
					int firstPrompt = 1;
					playerIndex ++;
					
					while(player.getEncounter() instanceof Monster)
					{
						Monster tempMonster = (Monster) player.getEncounter();
						if(firstPrompt != 1)
						{
							user.displayInventory();
							System.out.println("\n\nYou ran into a " + tempMonster.getName() + "! ");
							System.out.println("\n" + tempMonster.getName() + "'s Current Stats: ");
							System.out.print(tempMonster.getName() + " Health: " + tempMonster.getLife() + "   ");
							System.out.print(tempMonster.getName() + " Defense: " + tempMonster.getDefense() + "   ");
							System.out.print(tempMonster.getName() + " Damage: " + tempMonster.getAttack() + "   ");
							System.out.print(tempMonster.getName() + " Speed: " + tempMonster.getSpeed() + "   ");
							
							if(user.getInventorySize() != 0)
							{
								System.out.println("\n\nWould you like to use any of your one-time-use items?");
								System.out.println("Enter the index of the item you want to use or enter -1 to not use any:");
								userInput = scan.nextInt();
								
								user.useItem(userInput);
							}
							System.out.println("\n1. Attack \n2. Run Past \nNote: If you run past a monster you will be hit.");
							userInput = scan.nextInt();
							System.out.println("\n----------------------------------------------------\n");
						}

						if(userInput == 1)
						{
							firstAttack = determineSpeed(user, tempMonster); //returns 1 if user faster, 0 is monster faster
							user.combat(tempMonster, firstAttack);
							
							if(user.isAlive())
							{
								user.gainExperience(tempMonster);
								player.setEncounter(user);
								return;
							}
							else
							{
								return;
							}
						}
						else
						{
							user.getHit(tempMonster);
						}
						player = player.getNext();
						playerIndex++;
						firstPrompt++;
					}
					if(!user.isAlive())////
					{
						return;
					}
					
					if(player.getEncounter() instanceof Item)
					{
						item = (Item) player.getEncounter();
						
						System.out.println("You found a " + item.getName() + "!");
						
						if(player.getEncounter() instanceof PermaItem)
						{
							System.out.println("Would you like to equipe with it?");
							System.out.println("\n1. Equipe Item\n2. Ignore Item");
							userInput = scan.nextInt();
							
							if(userInput == 1)
							{
								user.equipe(item);
							}
						}
						else
						{
							System.out.println("Would you like to pick it up?");
							System.out.println("\n1. Pick Up\n2. Avoid Item");
							System.out.println("Note: If you don't pick it up, then it will disappear!");
							userInput = scan.nextInt();
							
							if(userInput == 1)
							{
								user.pickUp(item);
								System.out.println(item + " has been added to your inventory!\n");
								user.displayInventory();
							}
							
						}
						player.setEncounter(user);
						System.out.println("\n----------------------------------------------------\n");
					}
					
					if(player.getEncounter() instanceof Door)
					{
						System.out.println("You stumble upon a door! Will you enter it?");
						System.out.println("\n1. Enter Door");
						if(player.getNext().getEncounter() instanceof Empty)
						{
							System.out.println("2. Run Past Door");
							empty = true;
						}
						
						userInput = scan.nextInt();
						
						if(userInput == 1)
						{
							floor++; 
							System.out.println("\n----------------------------------------------------\n\n");
							System.out.println("Entering Dungeon Floor: " + floor + "...\n");
							createDungeon(user);
							return;
						}
						else if(userInput == 2)
						{
							if(empty)
							{
								player = player.getNext();
								playerIndex ++;
								player.setEncounter(user);
							}
						}
						else
						{
							System.out.println("Invalid Input");
							return;
						}
					}
					
					if(player.getEncounter() instanceof Empty)
					{
						player.setEncounter(user);
					}////
				}
				
				
			
			}
			
			else if(player.getNext().getEncounter() instanceof Item)
			{
				item = (Item) player.getNext().getEncounter();
				
				System.out.println("You found a " + item.getName() + "!");
				
				if(player.getNext().getEncounter() instanceof PermaItem)
				{
					System.out.println("Would you like to equipe with it?");
					System.out.println("\n1. Equipe Item\n2. Ignore Item");
					userInput = scan.nextInt();
					
					if(userInput == 1)
					{
						user.equipe(item);
					}
				}
				else
				{
					System.out.println("Would you like to pick it up?");
					System.out.println("\n1. Pick Up\n2. Avoid Item");
					System.out.println("Note: If you don't pick it up, then it will disappear!");
					userInput = scan.nextInt();
					
					if(userInput == 1)
					{
						user.pickUp(item);
						System.out.println(item + " has been added to your inventory!\n");
						user.displayInventory();
					}
					
				}

				shiftPlayer("right"); 
				System.out.println("\n----------------------------------------------------\n");
			}
			else if(player.getNext().getEncounter() instanceof Door) 
			{
				
				System.out.println("You stumble upon a door! Will you enter it?");
				System.out.println("\n1. Enter Door");
				if(player.getNext().getNext().getEncounter() instanceof Empty)
				{
					System.out.println("2. Run Past Door");
					empty = true;
				}
				
				userInput = scan.nextInt();
				
				if(userInput == 1)
				{
					floor++; 
					System.out.println("\n----------------------------------------------------\n\n");
					System.out.println("Entering Dungeon Floor: " + floor + "...\n");
					createDungeon(user);
					return;
				}
				else if(userInput == 2) //you can run past door only if cell in front of door is empty.
				{
					if(empty)
					{
						player.setEncounter(new Empty(" "));
						player = player.getNext().getNext();
						playerIndex += 2;
						player.setEncounter(user);
					}
				}
				else
				{
					System.out.println("Invalid Input");
					return;
				}
			}
			else	
			{
				shiftPlayer("right");
			}
		}
		
		//moving left:
		else if(direction == 2)			
		{
			if(player.getPrevious().getEncounter() instanceof Monster)
			{
				monster = (Monster) player.getPrevious().getEncounter();

				user.displayInventory();
				System.out.println("\n\nYou ran into a " + monster.getName() + "! ");
				System.out.println("\n" + monster.getName() + "'s Current Stats: ");
				System.out.print(monster.getName() + " Health: " + monster.getLife() + "   ");
				System.out.print(monster.getName() + " Defense: " + monster.getDefense() + "   ");
				System.out.print(monster.getName() + " Damage: " + monster.getAttack() + "   ");
				System.out.print(monster.getName() + " Speed: " + monster.getSpeed() + "   ");
				
				if(user.getInventorySize() != 0)
				{
					System.out.println("\n\nWould you like to use any of your one-time-use items?");
					System.out.println("Enter the index of the item you want to use or enter -1 to not use any:");
					userInput = scan.nextInt();
					
					user.useItem(userInput);
				}
				
				System.out.println("\n\nDo you wish to attack it the monster? ");
				System.out.println("1. Attack \n2. Run Past \nNote: If you run past a monster you will be hit.");
				
				userInput = scan.nextInt();
				System.out.println("\n----------------------------------------------------\n");
				
				if(userInput == 1) //fight
				{
					firstAttack = determineSpeed(user, monster); //returns 1 if user faster, 0 is monster faster
					user.combat(monster, firstAttack);
					if(user.isAlive())
					{
						user.gainExperience(monster);
						remove(player.getPrevious());
						if(playerIndex > 0)
							playerIndex = (playerIndex - 1) % size;
							
					}
				}
				else if(userInput == 2)//run
				{
					player.setEncounter(new Empty(" "));
					//user.getHit(monster);
					player = player.getPrevious();
					int firstPrompt = 1;
					playerIndex = (playerIndex - 1) %size;
					
					while(player.getEncounter() instanceof Monster)
					{
						Monster tempMonster = (Monster) player.getEncounter();
						if(firstPrompt != 1)
						{
							user.displayInventory();
							System.out.println("\n\nYou ran into a " + tempMonster.getName() + "! ");
							System.out.println("\n" + tempMonster.getName() + "'s Current Stats: ");
							System.out.print(tempMonster.getName() + " Health: " + tempMonster.getLife() + "   ");
							System.out.print(tempMonster.getName() + " Defense: " + tempMonster.getDefense() + "   ");
							System.out.print(tempMonster.getName() + " Damage: " + tempMonster.getAttack() + "   ");
							System.out.print(tempMonster.getName() + " Speed: " + tempMonster.getSpeed() + "   ");
							
							if(user.getInventorySize() != 0)
							{
								System.out.println("\n\nWould you like to use any of your one-time-use items?");
								System.out.println("Enter the index of the item you want to use or enter -1 to not use any:");
								userInput = scan.nextInt();
								
								user.useItem(userInput);
							}
							System.out.println("\n1. Attack \n2. Run Past \nNote: If you run past a monster you will be hit.");
							userInput = scan.nextInt();
							System.out.println("\n----------------------------------------------------\n");
						}

						if(userInput == 1)
						{
							firstAttack = determineSpeed(user, tempMonster); //returns 1 if user faster, 0 is monster faster
							user.combat(tempMonster, firstAttack);
							
							if(user.isAlive())
							{
								user.gainExperience(tempMonster);
								player.setEncounter(user);
								return;
							}
							else
							{
								return;
							}
						}
						else
						{
							user.getHit(tempMonster);
						}
						player = player.getPrevious();
						playerIndex = (playerIndex - 1 ) % size;
						firstPrompt++;
					}

					if(!user.isAlive())
					{
						return;
					}
					
					if(player.getEncounter() instanceof Item)
					{
						item = (Item) player.getEncounter();
						
						System.out.println("You found a " + item.getName() + "!");
						
						if(player.getEncounter() instanceof PermaItem)
						{
							System.out.println("Would you like to equipe with it?");
							System.out.println("\n1. Equipe Item\n2. Ignore Item");
							userInput = scan.nextInt();
							
							if(userInput == 1)
							{
								user.equipe(item);
							}
						}
						else
						{
							System.out.println("Would you like to pick it up?");
							System.out.println("\n1. Pick Up\n2. Avoid Item");
							System.out.println("Note: If you don't pick it up, then it will disappear!");
							userInput = scan.nextInt();
							
							if(userInput == 1)
							{
								user.pickUp(item);
								System.out.println(item + " has been added to your inventory!\n");
								user.displayInventory();
							}
							
						}
						player.setEncounter(user);
						System.out.println("\n----------------------------------------------------\n");
					}
					
					if(player.getEncounter() instanceof Door)
					{
						System.out.println("You stumble upon a door! Will you enter it?");
						System.out.println("\n1. Enter Door");
						if(player.getPrevious().getEncounter() instanceof Empty)
						{
							System.out.println("2. Run Past Door");
							empty = true;
						}
						
						userInput = scan.nextInt();
						
						if(userInput == 1)
						{
							floor++; 
							System.out.println("\n----------------------------------------------------\n\n");
							System.out.println("Entering Dungeon Floor: " + floor + "...\n");
							createDungeon(user);
							return;
						}
						else if(userInput == 2)
						{
							if(empty)
							{
								player = player.getPrevious();
								playerIndex = (playerIndex - 1) % size;
								player.setEncounter(user);
							}
						}
						else
						{
							System.out.println("Invalid Input");
							return;
						}
					}
					
					if(player.getEncounter() instanceof Empty)
					{
						player.setEncounter(user);
					}
				}
				
			}
			
			else if(player.getPrevious().getEncounter() instanceof Item)
			{
				item = (Item) player.getPrevious().getEncounter();
				
				System.out.println("You found a " + item.getName() + "!");
				if(player.getPrevious().getEncounter() instanceof PermaItem)
				{
					System.out.println("Would you like to equipe with it?");
					System.out.println("\n1. Equipe Item\n2. Ignore Item");
					userInput = scan.nextInt();
					
					if(userInput == 1)
					{
						user.equipe(item);
					}
				}
				else
				{
					System.out.println("Would you like to pick it up?");
					System.out.println("\n1. Pick Up\n2. Avoid Item");
					System.out.println("Note: If you don't pick it up, then it will disappear!");
					userInput = scan.nextInt();
					
					if(userInput == 1)
					{
						user.pickUp(item);
						System.out.println(item + " has been added to your inventory!\n");
						user.displayInventory();
					}
					
				}
				shiftPlayer("left");
				System.out.println("\n----------------------------------------------------\n");
			}
			
			else if(player.getPrevious().getEncounter() instanceof Door)
			{
				System.out.println("You stumble upon a door! Will you enter it?");
				System.out.println("\n1. Enter Door");
				
				if(player.getPrevious().getPrevious().getEncounter() instanceof Empty)
				{
					System.out.println("2. Run Past Door");
					empty = true;
				}
				
				userInput = scan.nextInt();
				
				if(userInput == 1)
				{
					floor++;
					System.out.println("\n----------------------------------------------------\n\n");
					System.out.println("Entering Dungeon Floor: " + floor + "...\n");
					
					createDungeon(user);
					return;
				}
				else if(userInput == 2) //you can run past door only if cell in behind door is empty
				{
					if(empty)
					{
						player.setEncounter(new Empty(" "));
						player = player.getPrevious().getPrevious();
						playerIndex = (playerIndex - 2) % size; ///note
						player.setEncounter(user);
					}
				}
				else
				{
					System.out.println("Invalid Input");
					return;
				}
				
			}
			
			else	//empty
			{
				shiftPlayer("left");
			}
		}
		else
		{
			System.out.println("Invalid input, try again: \n");
		}
		
	}
	
	private int determineSpeed(Player user, Monster enemy)
	{
		int randomValue;
		
		if(user.getSpeed() == enemy.getSpeed())
		{
			randomValue = generator.nextInt(2); 
			return randomValue;
		}
		else if(user.getSpeed() > enemy.getSpeed())
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	private void shiftPlayer(String position)
	{
		if(position.toUpperCase().equals("RIGHT"))
		{	
			player.getNext().setEncounter(player.getEncounter());
			player.setEncounter(new Empty(" "));
			player = player.getNext();
			playerIndex++;
		}
		else if(position.toUpperCase().equals("LEFT"))
		{
			player.getPrevious().setEncounter(player.getEncounter());
			player.setEncounter(new Empty(" "));
			player = player.getPrevious();
			playerIndex = (playerIndex - 1) % size;
		}
		else
		{
			System.out.println("Enter either \"right\" or \"left\"");
		}
	}

}
