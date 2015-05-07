public class Parser 
{
	private String theStmt;
	private int pos; //where am I in the theStmt string
	private static final String legalVariableCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ "; 
	private static final String legalLiteralCharacter = "0123456789 ";
	private static final String legalSymbolCharacters = Parser.legalVariableCharacters + Parser.legalLiteralCharacter;
	private static final String legalOpCharacters = "+-*/% ";
	private VarDefStatement theSyntaxTree;
	private VarDefStatement secondSyntaxTree;
	private Variable theVariable;

	public Parser(String theStmt)
	{
		this.theStmt = theStmt;
		this.theSyntaxTree = null;
		this.secondSyntaxTree = null;
		this.theVariable = null;
		this.pos = 0;
	}

	public VarDefStatement getTheSyntaxTree() {
		return theSyntaxTree;
	}

	public VarDefStatement getSecondSyntaxTree() {
		return secondSyntaxTree;
	}

	void parse()
	{
		this.theSyntaxTree = this.parse_stmt();
		if(this.theSyntaxTree != null && this.pos != this.theStmt.length())
		{
			this.secondSyntaxTree = this.parse_stmt();
		}
	}

	private String getNextToken(char c)
	{
		while(pos < this.theStmt.length())
		{
			if(this.theStmt.charAt(pos) == c)
			{
				pos++;
				break;
			}
			pos++;
		}
		return "" + c;
	}

	private String getNextToken(String legalChars)
	{
		String token = "";
		while(pos < this.theStmt.length())
		{
			if(legalChars.indexOf(this.theStmt.charAt(pos)) != -1)
			{
				token += this.theStmt.charAt(pos);
			}
			else
			{
				//this means we are at the end of the token
				//We are always trimming leading and trailing spaces
				//move forward one
				break;
			}
			pos++;
		}
		return token.trim();
	}

	private VarDefStatement parse_stmt()
	{
		//Print each time it reads something like:
		// Read: VarName = a
		String varName = this.getNextToken(Parser.legalVariableCharacters);
		System.out.println("Read VarName: " + varName);
		VarExpression theVE = new VarExpression(varName);

		//burn past the =
		this.getNextToken('=');
		System.out.println("Burned =");
		
		
		//if the next token is an int followed by a semicolon 
		//store the variable/int-value pair(so that we can call upon it when performing doMath)
		if (theSyntaxTree == null)
		{
			String varNum = this.getNextToken(Parser.legalLiteralCharacter);
			varNum.trim();

			if(isVariable(varNum))
			{
				int variableNum = Integer.parseInt(varNum);
				System.out.println("Variable Number: " + variableNum);
				theVariable = new Variable(varName, variableNum);

				//System.out.println(variableEnv.getVariableArray().toString());
				pos++;
				pos++;
				return new VarDefStatement(theVariable);
			}
		}



		// Reading: Math-Expr
		MathExpression theME = this.parse_math_expr();
		
		System.out.println("The Right Side Math is: " + theME.doMath(theVariable));

		//burn past the ;
		this.getNextToken(';');
		System.out.println("Burned ;");

		return new VarDefStatement(theVE, theME);
	}

	private boolean isVariable(String symbol)
	{
		symbol = symbol.trim();
		for(int i = 0; i < symbol.length(); i++)
		{
			//System.out.println(Parser.legalLiteralCharacter.indexOf(symbol.charAt(i)));
			if(Parser.legalLiteralCharacter.indexOf(symbol.charAt(i)) == -1 )
			{
				return false;
			}
		}

		/*if(symbol.charAt(symbol.length()-1) == ';')
		{
			System.out.println("SUCCESSFUL VARIABLE");
			return true;
		}*/
		return true;
	}

	private boolean isVarExpression(String symbol)
	{
		for(int i = 0; i < symbol.length(); i++)
		{
			if(Parser.legalVariableCharacters.indexOf(symbol.charAt(i)) == -1 || symbol.charAt(i) == ' ')
			{
				return false;
			}
		}
		return true;
	}

	private MathExpression parse_math_expr()
	{
		String symbol = this.getNextToken(Parser.legalSymbolCharacters);
		Expression leftOperand = null;
		Expression rightOperand = null;
		OpExpression theOpExpression = null;

		if(symbol.length() == 0)
		{
			//we know that we are at the beginning of a paren-math-expr
			this.getNextToken('(');
			System.out.println("Burned (");
			leftOperand = this.parse_math_expr();
			this.getNextToken(')');
			System.out.println("Burned )");
		}
		else
		{
			//is it a var or a lit expression?
			if(this.isVarExpression(symbol))
			{
				System.out.println("Read VarExpression: " + symbol);
				leftOperand = new VarExpression(symbol);
			}
			else
			{
				System.out.println("Read LitExpression: " + symbol);
				leftOperand = new LitExpression(Integer.parseInt(symbol));
			}
		}
		String op = this.getNextToken(Parser.legalOpCharacters);
		System.out.println("Read Op: " + op);
		theOpExpression = new OpExpression(op.charAt(0));

		symbol = this.getNextToken(Parser.legalSymbolCharacters);
		if(symbol.length() == 0)
		{
			//we know that we are at the beginning of a paren-math-expr
			this.getNextToken('(');
			rightOperand = this.parse_math_expr();
			this.getNextToken(')');
		}
		else
		{
			//is it a var or a lit expression?
			if(this.isVarExpression(symbol))
			{
				System.out.println("Read VarExpression: " + symbol);
				rightOperand = new VarExpression(symbol);
			}
			else
			{
				System.out.println("Read LitExpression: " + symbol);
				rightOperand = new LitExpression(Integer.parseInt(symbol));
			}
		}
		return new MathExpression(leftOperand, rightOperand, theOpExpression);
	}
}