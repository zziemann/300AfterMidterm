
public class Stack 
{
	private Node head;
	
	public Stack()
	{
		this.head = null;
	}
	
	public boolean isEmpty()
	{
		return this.head == null;
	}
	
	public void display()
	{
		if(head == null)
		{
			System.out.println("Empty List");
		}
		else
		{			
			Node currNode = this.head;
			while(currNode.getNextNode() != null)
			{
				System.out.print(currNode.getPayload() + " -> ");
				currNode = currNode.getNextNode();
			}
			System.out.println(currNode.getPayload() + " -> null (finished)");			
		}
	}
	
	public void push(int payload)
	{
		Node n = new Node(payload);
		if(this.head == null)
		{
			this.head = n;
		}
		else
		{
			n.setNextNode(this.head);
			this.head = n;
		}
	}
	
	public int pop() throws Exception
	{
		if(this.head == null)
		{
			throw new Exception("Emtpy Stack!!!  Cry More");
		}
		else
		{
			int valToReturn = this.head.getPayload();
			this.head = this.head.getNextNode();
			return valToReturn;
		}
	}
	
	public int peek() throws Exception
	{
		if(head == null)
		{
			throw new Exception("Can Not Peek: Empty List");			
		}
		return head.getPayload();	
	}
}
