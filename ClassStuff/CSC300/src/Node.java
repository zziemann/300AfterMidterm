
public class Node 
{
	private Node nextNode;
	private Node previousNode;
	private int payload;
	
	//where nodes are born
	public Node(int payload)
	{
		this.payload = payload;
		this.nextNode = null;
		this.previousNode = null;
		
	}
	
	public Node getNextNode()
	{
		return this.nextNode;
	}
	
	public Node getPreviousNode()
	{
		return this.previousNode;
	}

	public void setNextNode(Node nextNode) 
	{
		this.nextNode = nextNode;
	}

	public void setPreviousNode(Node previousNode)
	{
		this.previousNode = previousNode;
	}
	public int getPayload()
	{
		return payload;
	}
	
	
}
