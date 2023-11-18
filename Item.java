public class Item extends Encounter
{
	private String name;
	private int buff;
	private int debuff;
	
	public Item(String name, int buff, int debuff)
	{
		super(name);
		this.name = name;
		this.buff = buff;
		this.debuff = debuff;
	}

	public String getName()
	{
		return name;
	}
	
	public void setBuff(int buff)
	{
		this.buff = buff;
	}
	
	public int getBuff()
	{
		return buff;
	}
	
	public int getDebuff()
	{
		return debuff;
	}
}
