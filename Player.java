import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player extends Encounter
{
	private String name;
	private ArrayList<Item> inventory; 
	private Scanner scan;
	private int attack;
	private int speed;
	private int defense;
	private int maxLife; 
	private int experience;
	private int level;
	private int tempAttackBuff;
	private int tempSpeedBuff;
	private int tempShieldBuff;
	
	public Player(String name, int maxLife, int defense, int attack, int speed)
	{
		super(name);
		this.name = name;
		this.attack = attack;
		this.speed = speed;
		this.defense = defense;
		this.maxLife = maxLife;
		experience = 0;
		level = 1;
		tempAttackBuff = 0;
		tempSpeedBuff = 0;
		tempShieldBuff = 0;
		
		inventory = new ArrayList<Item>();
		scan = new Scanner(System.in);
	}
	
	public void pickUp(Item item)
	{
		inventory.add(item); 
	}
	
	public void useItem(int index)
	{
		if(index == -1)
		{
			return;
		}
		if(inventory.get(index) instanceof RedHealingPotion) 
		{
			maxLife = maxLife + inventory.get(index).getBuff();
			if(maxLife > 150)
				maxLife = 150;
			
			inventory.remove(index);
			System.out.println("\nAlert: You used a Red_Healing_Potion (New HP: " + maxLife + ")");
		}
		else if(inventory.get(index) instanceof BlueHealingPotion) 
		{
			maxLife = maxLife + inventory.get(index).getBuff();
			if(maxLife > 150)
				maxLife = 150;
			
			inventory.remove(index);
			System.out.println("\nAlert: You used a Blue_Healing_Potion (New HP: " + maxLife + ")");
		}
		else if(inventory.get(index) instanceof GoldenHealingPotion) 
		{
			maxLife = maxLife + inventory.get(index).getBuff();
			if(maxLife > 150)
				maxLife = 150;
			
			inventory.remove(index);
			System.out.println("\nAlert: You used a Golden_Healing_Potion (New HP: " + maxLife + ")");
		}
		else if(inventory.get(index) instanceof PurpleAttackPotion)
		{
			tempAttackBuff += inventory.get(index).getBuff();
			inventory.remove(index);
			System.out.println("\nAlert: You used a Purple_Attack_Potion (Temperary Attack: " + tempAttackBuff + ")");
		}
		else if(inventory.get(index) instanceof GoldenAttackPotion)
		{
			tempAttackBuff += inventory.get(index).getBuff();
			inventory.remove(index);
			System.out.println("\nAlert: You used a Golden_Attack_Potion (Temperary Attack: " + tempAttackBuff + ")");
		}
		else if(inventory.get(index) instanceof SpeedPotion)
		{
			tempSpeedBuff += inventory.get(index).getBuff();
			inventory.remove(index);
			System.out.println("\nAlert: You used a Speed_Potion (Temperary Speed: " + tempSpeedBuff + ")");
		}
		else if(inventory.get(index) instanceof ShieldPotion)
		{
			tempShieldBuff += inventory.get(index).getBuff();
			inventory.remove(index);
			System.out.println("\nAlert: You used a Shield_Potion (Temperary Defense: " + tempShieldBuff + ")");
		}
	}
	
	public void equipe(Item item)
	{
		if(item instanceof IronSword)
		{
			attack += item.getBuff();
		}
		else if(item instanceof HeavyAxe)
		{
			attack += item.getBuff();
			speed += item.getDebuff();
			if(speed < 0)
				speed = 1;
		}
		else if(item instanceof IronArmor)
		{
			defense += item.getBuff();
			speed = speed - item.getDebuff();
			if(speed < 0)
				speed = 1;
		}
		else if(item instanceof IronBoots)
		{
			defense += item.getBuff();
			speed += item.getDebuff();
			if(speed < 0)
				speed = 1;
		}
		else if(item instanceof SpeedBoots)
		{
			speed += item.getBuff();
		}
		else if(item instanceof DarknessRing)
		{
			defense *= item.getBuff();
			attack += item.getDebuff();
			if(attack < 0)
				attack = 10;
		}
		else if(item instanceof FireRing)
		{
			attack += item.getBuff();
		}
		else
		{
			
		}
			
	}
	
	public int getInventorySize()
	{
		return inventory.size();
	}
	
	public void combat(Monster monster, int firstAttack) //if firstAttack = 1 user attack first otherwise mob first
	{
		boolean attackBuff = false;
		boolean speedBuff = false;
		boolean shieldBuff = false;
		
		tempAttackBuff = tempShieldBuff = tempSpeedBuff = 0;
		
		if(tempAttackBuff != 0)
		{
			attack += tempAttackBuff;
			attackBuff = true;
		}
		if(tempSpeedBuff != 0)
		{
			speed += tempSpeedBuff;
			speedBuff = true;
		}
		if(tempShieldBuff != 0)
		{
			defense += tempShieldBuff;
			shieldBuff = true;
		}
		
		int tempPlayerAttack = this.attack - monster.getDefense();
		int tempMonsterAttack = monster.getAttack() - this.defense;
		
		if(tempPlayerAttack < 1)
		{
			tempPlayerAttack = 1;
		}
		if(tempMonsterAttack < 1)
		{
			tempMonsterAttack = 1;
		}
		
		if(firstAttack == 1)
		{
			while(isAlive() && monster.isAlive())
			{
				monster.setLife(monster.getLife() - tempPlayerAttack);
				if(monster.isAlive())
				{
					this.maxLife = maxLife - tempMonsterAttack;
				}
			}
		}
		else
		{
			while(isAlive() && monster.isAlive())
			{
				this.maxLife = maxLife - tempMonsterAttack;
				if(isAlive())
				{
					monster.setLife(monster.getLife() - tempPlayerAttack);
				}
			}
		}
		
		if(attackBuff)
		{
			attack = attack - tempAttackBuff;
		}
		if(speedBuff)
		{
			speed = speed - tempSpeedBuff;
		}
		if(shieldBuff)
		{
			defense = defense - tempShieldBuff;
		}
		
		tempAttackBuff = tempShieldBuff = tempSpeedBuff = 0;
	}
	
	public void getHit(Monster monster)
	{
		int tempMonsterAttack = monster.getAttack() - this.defense;

		if(tempMonsterAttack < 1) 
		{
			tempMonsterAttack = 1; 
		}
		maxLife = maxLife - tempMonsterAttack; 
		
	}
	
	public void displayInventory()
	{
		System.out.print("Your Inventory: ");
		
		for(Item item: inventory)
		{
			System.out.print("[ " + item + " ]");
		}
	}

	public boolean isAlive()
	{
		if(maxLife > 0)
		{
			return true;
		}
		return false;
	}
	
	public void gainExperience(Monster defeatedMonster)
	{
		int experienceToGain = defeatedMonster.getExperienceValue();
		experience += experienceToGain;
		
		if(experience > 100)
		{
			experience = experience % 100;
			levelUp();
		}
		else if(experience == 100)
		{
			experience = 0;
			levelUp();
		}
		else
		{
			return;
		}
	}
	
	public void levelUp()
	{
		level++;
		attack += 15;
		speed += 10;
		defense += 5;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getAttack()
	{
		return attack;
	}

	public int getSpeed()
	{
		return speed;
	}
	
	public int getDefense()
	{
		return defense;
	}
	
	public int getLife()
	{
		return maxLife;
	}
	
	public void setLife(int newLife)
	{
		maxLife = newLife;
	}
	
	public int getLevel()
	{
		return level;
	}
	
	public int getEXP()
	{
		return experience;
	}
}


