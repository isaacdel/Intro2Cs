/**
* 
*/

public class Parser extends java.lang.Object{
    /**
    * 
    */
	
    public Parser() {

    }
    /**
    * Parses a factor. A Factor can be one of the following: 1) number; 2) variable; 3) expression in brackets.

    * @param scan the Tokenizer

    * @return Number object if the next element is number. 
 Variabe object if the next element is variable.  
 In case of expression in brackets it calls parseExpression for the expression in brackets and returns the result. 
 Returns null otherwise.
    */
    public static Expression parseFactor(Tokenizer scan) {
    	if(scan.peek()==ElementType.NUMBER){
    		return new Number(Double.valueOf(scan.nextElement()));
    	}
    	if (scan.peek()==ElementType.VARIABLE){
    		return new Variable(scan.nextElement());
    	}
    	if(scan.peek()==ElementType.BRACKET){
    		return parseExpression(scan);
    	}
    	return null;
    		
    }
    /**
    * Parses an expression. An expression can be Term { [+/-] Term }.
 Calls parseTerm to get the first expression. 
 If operations "+" or "-" are followed, it calls ParseTerm again to get the second expression
 and creates an Operand object with the operand acts on the two obtained expressions. 
 The process is repeated for every addition "+" or "-" operation.

    * @param scan the Tokenizer

    * @return the result of parseTerm if only one operand exist. The operation result if more than one operand exist.
    */
    public static Expression parseExpression(Tokenizer scan) {
    	Expression leftTerm=parseTerm(scan);
    	if(scan.peek()==ElementType.MINUS||scan.peek()==ElementType.PLUS){
    		String operator=scan.nextElement();
    		return new Operator(operator, leftTerm, parseExpression(scan));
    	}
    	if(scan.peek() == ElementType.BRACKET)//remove brackets
    		scan.nextElement();
   
    	return leftTerm;
    }
    /**
    * Parses a term. A term can be Factor { ÷\*  Factor }.
 Calls parseFactor to get the first expression.
 If operations "*" or "/" are followed, it calls ParseFactor again to get the second expression 
 and creates an Operand object with the operand acts on the two obtained expressions.
 The process is repeated for every addition "*" or "/" operation.

    * @param scan the Tokenizer

    * @return the result of parseFactor if only one operand exist. The operation result if more than one operand exist.
    */
    public static Expression parseTerm(Tokenizer scan) {
    	Expression leftTerm=parseFactor(scan);
    	while(scan.peek()==ElementType.MUL||scan.peek()==ElementType.DIV){
    		String operator=scan.nextElement();
    		return new Operator(operator, leftTerm,parseFactor(scan));
    	}
    	if(scan.peek() == ElementType.BRACKET)//remove brackets
    		scan.nextElement();
   
    	return leftTerm;
    	
    	
    }
}