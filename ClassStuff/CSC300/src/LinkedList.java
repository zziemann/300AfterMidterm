
public class LinkedList
{
	private Node head;
	private int count;
	
	
	public LinkedList()
	{
		this.head = null;
		this.count = 0;
			
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
	
	public void addFront(int payload)
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
		this.count++;
	}	
	
	public void addEnd(int payload)
	{		
		Node n = new Node(payload);
		if(this.head == null)
		{
			//if it's the first one it'll be null right away
			this.head = n;			
		}
		else
		{
			//find the last node in the list
			Node currNode = this.head;
			//System.out.println(currNode.getNextNode());
			while(currNode.getNextNode() != null)
			{
				//moving along the list til null, end
				currNode = currNode.getNextNode();				
			}
			//currNode will point to the very last Node in the list
			currNode.setNextNode(n);			
		}
		this.count++;
	}
	
	public void addAtIndex(int payload, int index)
	{
		if(index <= 0)
		{
			addFront(payload);
		}
		if(index >= count)
		{
			addEnd(payload);
		}		
		else if(index > 0 && index < count )
		{
			Node n = new Node(payload);
			if(this.head == null)
			{
				this.head = n;
				count ++;
			}
			else
			{
				Node currNode = this.head;			
				for(int i = 0; i < index; i++)
				{
					currNode = currNode.getNextNode();
				}
				n.setNextNode(currNode);
				
				Node previousNode = this.head;
				for(int e = 0; e < index-1; e++)
				{
					previousNode = previousNode.getNextNode();
				}
				previousNode.setNextNode(n);
				count++;
			}
		}		
	}	
	
	public int count()
	{
		return this.count;				
	}
	
	public int get(int index)
	{
		int count = this.count();
		if(index >= count || index < 0)
		{
			System.err.println("Illegal Index!");
			return -1;
		}
		else
		{
			Node curr = head;
			for(int i = 0; i < index; i++)
			{
				curr = curr.getNextNode();
			}
			return curr.getPayload();
		}
	}
	
	public void printOdds()
	{
		Node curr = this.head;
		System.out.print("The Odd List: ");
		while(curr != null)
		{
			if(curr.getPayload() % 2 == 1)
			{
				System.out.print(curr.getPayload() + " ");
			}
			curr = curr.getNextNode();
		}
	}
	public int removeFront() throws Exception
	{
		if(head == null)
		{
			throw new Exception("Can Not Remove Front: Empty List");
			//throw makes method end right away
		}
		Node currNode = head;
		head = head.getNextNode();
		//set currNode's next node to null 
		currNode.setNextNode(null);
		this.count--;
		return currNode.getPayload();
	}
	
	public int removeEnd() throws Exception
	{
		if(head == null)
		{
			throw new Exception("Can Not Remove End: Empty List");
		}
		else if(this.count == 1)
		{
			return this.removeFront();
		}
		else
		{
			Node currNode = head;
			Node payload = head;			
			while(payload.getNextNode() != null)
			{
				payload = payload.getNextNode();
			}
			
			for(int i = 1; i < count-1; i++)
			{
				currNode = currNode.getNextNode();
			}			
			currNode.setNextNode(null);
			this.count--;
			return payload.getPayload();
		}		
	}
	public int removeAtIndex(int index) throws Exception
	{
		if(head == null)
		{
			throw new Exception("Can Not Remove End: Empty List");
		}
		else if(index <= 0)
		{			
			return this.removeFront();
		}
		else if(this.count < index)
		{
			return this.removeEnd();
			
		}
		else
		{
			Node currNode = head;
			Node payload = head;	
			Node frontNode = head;
			
			for(int i = 0; i < index+1; i++)
			{
				frontNode = frontNode.getNextNode();
			}
			
			for(int i = 0; i < index; i++)
			{
				payload = payload.getNextNode();
			}
						
			for(int i = 0; i < index-1; i++)
			{
				currNode = currNode.getNextNode();
			}
			currNode.setNextNode(frontNode);
			this.count--;
			return payload.getPayload();
			
		}
	}
}

