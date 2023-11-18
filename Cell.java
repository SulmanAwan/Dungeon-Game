public class Cell
{
	private Encounter encounter;  
	public String x;   
	private Cell next;//points to the next node
	private Cell previous;//points to the previous node
	
	public Cell(String x) //sets the data
	{
		this.x = x;
	}
	
	public Cell(Encounter encounter) //sets the data
	{
		this.encounter = encounter;
	}
	
	public void setNext(Cell next) //sets the next cell reference
	{
		this.next = next;
	}

	public Cell getNext()
	{
		return next;
	}
	
	public void setPrevious(Cell previous)
	{
		this.previous = previous;
	}
	
	public Cell getPrevious()
	{
		return previous;
	}
	
	public Encounter getEncounter()
	{
		return encounter;
	}
	
	public void setEncounter(Encounter encounter)
	{
		this.encounter = encounter;
	}
}
