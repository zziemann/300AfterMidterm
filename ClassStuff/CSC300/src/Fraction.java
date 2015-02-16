
public class Fraction 
{
	//fields
	private int numerator; 
	private int denominator;
	
	//constructor
	public Fraction(int numerator, int denominator)  
	{
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	
	//methods	
	public Fraction add(Fraction f)
	{
		int commonDenom = this.denominator * f.denominator;
		int newNumerator = (this.numerator * f.denominator) + (this.denominator*f.numerator);
		return new Fraction(newNumerator, commonDenom);		
	}
	
	public void display()
	{
		System.out.println(this.numerator + "/" + this.denominator);
	}
}
