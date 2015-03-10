
public class Queue 
{
	private Person head;
	private Person tail;
	private int count;
	
	public Queue()
	{
		this.head = null;
		this.tail = null;
		this.count = 0;
	}	
	
	public void enqueue(Person p)
	{		
		Person currPerson = p; 
		if(this.head == null)
		{
			this.head = currPerson;
			this.tail = currPerson;
		}
		else
		{
			this.tail.setNextPerson(currPerson);
			currPerson.setPreviousPerson(this.tail);
			this.tail = currPerson;			
		}
		this.count++;
	}	
		
	public Person dequeue() throws Exception
	{
		if(head == null)
		{
			throw new Exception("Can Not Dequeue: Empty Queue");
		}
		else if(this.count == 1)
		{
			Person currPerson = head;
			this.head = null;
			this.tail = null;
			this.count--;
			return currPerson;
		}
		Person currPerson = head;
		currPerson.getNextPerson().setPreviousPerson(null);
		head = head.getNextPerson();
		currPerson.setNextPerson(null);
		this.count--;
		return currPerson;
	}
	
}
