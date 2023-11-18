public class Monster extends Encounter
{
	private String name;
	private int attack;
	private int speed;
	private int defense;
	private int life;
	private int experienceValue;
	private int floor;
	
	public Monster(String name, int attack, int speed, int defense, int life, int experienceValue, int floor)
	{
		super(name);
		this.floor = floor;
		this.name = name;
		this.attack = attack * floor; 
		this.speed = speed * floor;
		this.defense = defense * floor;
		this.life = life * floor;
		this.experienceValue = experienceValue * floor;
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
	
	public void setDefense(int newDefense)
	{
		defense = newDefense;
	}
	
	public int getLife()
	{
		return life;
	}
	
	public void setLife(int newLife)
	{
		life = newLife;
	}
	
	public int getFloor()
	{
		return floor;
	}
	
	public void setFloor(int newFloor)
	{
		floor = newFloor;
	}
	
	public int getExperienceValue()
	{
		return experienceValue;
	}

	public boolean isAlive()
	{
		if(life > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}