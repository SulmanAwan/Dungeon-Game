public class Encounter
{
	private String name;
	
	public Encounter(String name)
	{
		this.name = name;
	}
	
	@Override
	public String toString()
	{ 
		return name;
	}	
	
	public void printName()
	{
		System.out.println(name);
	}
}

