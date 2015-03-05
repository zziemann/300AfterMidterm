
public class Disc 
{
	private int size;
	private Disc nextDisc;
	
	public Disc(int size)
	{
		this.size = size;
		this.nextDisc = null;
	}

	public int getSize() 
	{
		return size;
	}

	public void setSize(int size) 
	{
		this.size = size;
	}

	public Disc getNextDisc() 
	{
		return nextDisc;
	}

	public void setNextDisc(Disc nextDisc) 
	{
		this.nextDisc = nextDisc;
	}
	
	
}
