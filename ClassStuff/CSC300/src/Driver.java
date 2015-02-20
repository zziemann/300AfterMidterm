
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
		 */	 
		 LinkedList ll = new LinkedList(); 
		 ll.display();		 
		 ll.addFront(55);		 
		 ll.addEnd(3);
		 ll.addEnd(0);
		 ll.addFront(222);
		 ll.addEnd(1);
		 ll.addAtIndex(33,3);
		 ll.display();
		 ll.displayReverse();
		 
		 
		 /*
		 ll.addAtIndex(111,1);
		 ll.display();
		 ll.addFront(6);
		 ll.addEnd(7);
		 ll.addEnd(2);		 
		 ll.addEnd(4);	
		 ll.addAtIndex(999,45);
		 ll.display();
		 
		 ll.removeAtIndex(4);
		 ll.display(); */
		 
	}
}
