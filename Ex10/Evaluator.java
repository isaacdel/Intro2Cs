import java.io.ObjectOutputStream.PutField;
import java.util.HashMap;
import java.util.concurrent.Phaser;

/**
* 
The class Evaluator for ex. 10. Holds a mathematical expression and
maintains the environment of variable values as a Map.

*/

public class Evaluator extends java.lang.Object{
	private HashMap<String, Double> map;
	 private Expression exp;
    /**
    * Default Constructor that builds an evaluator object.

    */
    public Evaluator() {
   	this.map=new HashMap<String,Double>();
    }
    /**
    * Assigns a value to variable. Values are stored in a Map that maps variables to values.

    * @param variable the variable name.
    * @param value the value to assign.
    */
    public void assignValueToVariable(String variable, double value) {
    	map.put(variable, value);
    
    }
    /**
    * Builds an expression tree from the expression accepted as a parameter and stores it as the current expression.

    * @param expression the string to build an expression tree for.
    */
    public void setCurrentExpression(String expression) {
    	exp=Parser.parseExpression(new Tokenizer(expression));
    }
    /**
    * Evaluates the expression while using the Map of variables the the class holds to return its numeric value.

    * @return the value of the expression if all the variables are assigned a value, Double.NaN otherwise.
    */
    public double eval() {
    	return exp.eval(map);
    }
    /**
    * Prefix notation of the current expression. Space is added between operands.

    * @return Prefix notation of the expression.
    */
    public String prefix() {
    	return exp.toString(OpOrder.PREFIX);

    }
    /**
    * Postfix notation of the current expression. Space is added between operands.

    * @return Postfix notation of the expression.
    */
    public String postfix() {
    	return exp.toString(OpOrder.POSTFIX);
    }
    /**
    * Infix notation of the current expression.  
 Brackets are added for every operation.

    * @return Infix notation of the expression.
    */
    public String infix() {
    	return exp.toString(OpOrder.INFIX);
    }
}