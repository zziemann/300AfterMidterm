import java.util.Random;


public class Person 
{
	private Person nextPerson;
	private Person previousPerson;
	private String name;
	private int walletBalance;
	private static Random r = new Random();
	
	public Person(String name)
	{
		this.name = name;
		this.walletBalance = Person.r.nextInt(10);
		this.nextPerson = null;
		this.previousPerson = null;
	}
	
	public void display()
	{
		System.out.println("Hi, my name is: " + this.name + " and I have: $" + this.walletBalance + " on me!");
	}

	public String getName() 
	{
		return name;
	}
	
	public int getWalletBalance() 
	{
		return walletBalance;
	}

	public Person getNextPerson() 
	{
		return nextPerson;
	}

	public void setNextPerson(Person nextPerson) 
	{
		this.nextPerson = nextPerson;
	}

	public Person getPreviousPerson() 
	{
		return previousPerson;
	}

	public void setPreviousPerson(Person previousPerson) 
	{
		this.previousPerson = previousPerson;
	}

	
	
	
}