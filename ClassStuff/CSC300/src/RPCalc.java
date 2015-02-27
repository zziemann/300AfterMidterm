import java.util.Scanner;


public class RPCalc 
{
	private Stack theStack;
	
	public RPCalc()
	{
		this.theStack = new Stack();
	}
	
	//method that returns true if it's a number
	private boolean isNumber(String s)
	{
		try
		{
			Integer.parseInt(s);
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}
	
	//method that returns true it it's an operator
	private boolean isOperator(String s)
	{
		String map = "+-*/";
		return map.indexOf(s) != -1 && s.length() == 1;
	}
	
	//main calculations 
	public void on() throws Exception
	{
		Scanner input = new Scanner(System.in);
		
		while(true)
		{
			//asking us to type something
			System.out.print("=> ");
			
			//goes to next line, gets rid of any spaces
			String val = input.nextLine().trim();
			
			//TYPED IN QUIT 
			//how to stop
			if(val.equalsIgnoreCase("quit"))
			{
				break;
			}
			
			//TYPED IN SHOW
			//our display method
			else if(val.equalsIgnoreCase("show"))
			{
				//if empty stack
				if(this.theStack.isEmpty())
				{
					System.out.println("Empty Stack");
					continue;
				}
				
				
				Stack temp = new Stack();
				//transferring to our temp stack, in opposite order
				while(!this.theStack.isEmpty())
				{
					temp.push(this.theStack.pop());
				}
				
				//we have temp all set up, now putting it back to theStack
				while(!temp.isEmpty())
				{
					//taking top off of temp
					int num = temp.pop();
					//display our top number 
					System.out.println(num);
					//put that back on the original list
					this.theStack.push(num);
				}
			}
			
			//TYPED IN NUMBER
			//if it's a number it will push into theStack 
			else if(this.isNumber(val))
			{
				this.theStack.push(Integer.parseInt(val));
			}
			
			//TYPED IN OPERATOR
			else if(this.isOperator(val))
			{
				//this will take the two top numbers in stack and perform the op on them, 
				//replacing both of them with one new one on the top of the stack
				int num1 = this.theStack.pop();
				int num2 = this.theStack.pop();
				if(val.equals("+"))
				{
					this.theStack.push(num1 + num2);
				}
				else if(val.equals("-"))
				{
					this.theStack.push(num1 - num2);
				}
				else if(val.equals("*"))
				{
					this.theStack.push(num1 * num2);
				}
				else if(val.equals("/"))
				{
					this.theStack.push(num1 / num2);
				}
			}
			
			//TYPED IN SUM
			//this will add everything in the list and remove it all, then push the sum as the only number in the list
			else if(val.equalsIgnoreCase("sum"))
			{
				//if empty stack
				if(this.theStack.isEmpty())
				{
					System.out.println("Empty Stack");
					continue;
				}
				//taking everything out of the list adding them all and saving as a variable
				int runningTotal = 0;
				while(!this.theStack.isEmpty())
				{
					runningTotal = this.theStack.pop() + runningTotal;					
				}
				//adding our sum, runningTotal, to the stack now 
				this.theStack.push(runningTotal);
			}
			else
			{
				//if it's not "show", "quit", "sum", number, or operator
				System.out.println("Illegal Input");
			}
		}
	}
}