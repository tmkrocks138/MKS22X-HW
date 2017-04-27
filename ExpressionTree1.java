public class ExpressionTree{

    public String toString(){
	if(isValue()){
	    return getValue();
	}
	else{
	    return "( " + getLeft()+" "+getOp()+" "+getRight()+" )";
	}
    }

    /*return the expression as a postfix notation string without parenthesis*/
    /* The sample tree would be: "3 2 10 * +"     */
    public String toStringPostfix(){
	if(isValue()){
	    return getValue();
	}
	else{
	    return  getLeft()+" "+getRight()+" "+getOp();
	}
    }
    /*return the expression as a prefix notation string without parenthesis*/
    /* The sample tree would be: "+ 3 * 2 10"     */
    public String toStringPrefix(){
	if(isValue()){
	    return getValue();
	}
	else{
	    return  getOp()+" "+getLeft()+" "+getRight();
	}
    }

    /*return the value of the expression tree*/
    public double evaluate(){
	if(isValue()){
	    return getVal();
	}
	if(isOp()){}
    }
}
