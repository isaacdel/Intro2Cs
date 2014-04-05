
/**
* 
The class Operator for ex. 10. An operator can be one of 4 basic mathematical 
operators (+,-,*,/), and holds the two expressions that it operates on.

*/

public class Operator implements Expression{
    /**
    * Constructor that builds an Operator object. Gets the operator symbol (+,-,*,/) and the
 two expressions that it operates on.

    * @param operator String representation of the operation.
    * @param left The left expression.
    * @param right The right expression.
    */
	private String mathOperator;
	private Expression leftExpression,rightExpression;
    public Operator(String operator, Expression left, Expression right) {
    	super();
    	operator=this.mathOperator;
    	left=this.leftExpression;
    	right=this.rightExpression;

    }
    /**
    * String representation of the expression. This representation can be INFIX,PREFIX or POSTFIX, 
 depending with the requested operator order.

    * @param order the operator order used to build the String.
 If order==OpOrder.INFIX, brackets are added for every operation. 
 If order==OpOrder.POSTFIX or order==OpOrder.PREFIX, space is added between the operands.

    * @return representation of the expression as String.
    */
    public String toString(OpOrder order) {
    
    	if(order.equals(OpOrder.INFIX)){
    		return ("("+leftExpression+mathOperator+rightExpression+")");
    	}
    	if(order.equals(OpOrder.POSTFIX)){
    		return (leftExpression+" "+rightExpression+mathOperator);
    	}
    	if(order.equals(OpOrder.PREFIX)){
    		return (mathOperator+leftExpression+" "+rightExpression);
    	}
    	return null;
    }
    /**
    * Evaluates an expression. The value of an Operator is the result of its operation on its operands.
 The Map of variables is passed to the operands to evaluate the value of variables.

    * @param env a Map used to evaluate unknown expressions.

    * @return the value of the expression
    */
    public double eval(java.util.Map<String,java.lang.Double> env) {
    	if(this.mathOperator.equals("+")){
    		return leftExpression.eval(env)+rightExpression.eval(env);
    	}
    	if(this.mathOperator.equals("-")){
    		return leftExpression.eval(env)-rightExpression.eval(env);
    	}
    	if(this.mathOperator.equals("*")){
    		return leftExpression.eval(env)*rightExpression.eval(env);
    	}
    		return leftExpression.eval(env)/rightExpression.eval(env);
    	
    }
}