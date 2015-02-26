
public class Driver 
{
	public static void main(String[] args) throws Exception
	{
		 /*
		 LinkedList ll = new LinkedList();
		 try
		 {
			 System.out.println(ll.removeFront());
		 }
		 catch(Exception e)
		 {
			 System.out.println("Failed to remove");			 
		 }
		  
		 LinkedList ll = new LinkedList(); 
		 ll.display();		 
		 ll.addFront(55);		 
		 ll.addEnd(3);
		 ll.addAtIndex(33,4);
		 ll.addEnd(0);
		 ll.addFront(222);
		 ll.addEnd(1);		 
		 ll.display();
		 ll.displayInReverse();		
		 */
		
		Stack s = new Stack();
		s.display();		
		s.push(4);
		s.push(2);
		s.push(55);
		s.pop();
		s.push(3);
		s.push(1);
		s.display();
		s.pop();
		s.display();
		System.out.println(s.peek());
		s.display();
	}
}
