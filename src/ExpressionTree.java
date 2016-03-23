/*Conor Sweeney
 * cjs2201
 * ExpressionTree.java
*/

import java.util.NoSuchElementException;

/*
 * Custom Expression Tree class
 * The class is given a postfix expression and creates a tree
 * The class has methods to create postfix, prefix, infix string expressions
 * as well as solve the expression for an integer value
 */

public class ExpressionTree {
	//Variable declaration
	
	private final String postfix;
    private TreeNode root;
    private MyStack<TreeNode> nodes;


    /*Expression Tree
     * Takes in a valid postfix expression and later its used to construct the expression tree.
     * The postfix expression, if invalid, leads to invalid results 
     */
    
    public ExpressionTree(String postfix) {
        if (postfix == null) { 
        	throw new NullPointerException("The posfix should not be null");
        	}
        if (postfix.length() == 0)  { 
        	throw new IllegalArgumentException("The postfix should not be empty");
        	} 
        else{
            this.postfix = postfix;
            this.createExpressionTree();
        }
    }

    //creates a tree node class
    //is used while creating the ExpressionTree
    private static class TreeNode {
        TreeNode left;
        String ch;
        TreeNode right;

        TreeNode(TreeNode left, String ch, TreeNode right) {
            this.left = left;
            this.ch = ch;
            this.right = right;
        }
    }

    //checks if a character is an operator
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
   
    /*
     * Constructs an expression tree, using the postfix expression
     * the method reads the postfix through a loop
     * if the character at the index is an operator it pops nodes 
     * then pushes a new tree node made from the nodes
     * else it adds a new tree node
     * numbers are only linked to operators
     * The tree is created using a MyStack instance the size of the postfix length
    */

    private void createExpressionTree() {
        nodes = new MyStack<TreeNode>(postfix.length());
        String tempString="";
        for (int i = 0; i < postfix.length(); i++) {
            char ch  = postfix.charAt(i);
            if (isOperator(ch)) {
            	TreeNode rightNode = nodes.pop();
            	TreeNode leftNode = nodes.pop();
            	String operatorString = Character.toString(ch);
            	nodes.push(new TreeNode(leftNode, operatorString, rightNode));
            } 
            else {
            	if(ch == ' '){
            		if(tempString!=""){
            			nodes.push(new TreeNode(null, tempString, null));
            		}
                    tempString="";
            	}
            	else{
            		tempString = tempString+ch;
            	}
            }
        }
        root = nodes.pop();
    }
    
    /*
     * prefix method
     * when invoked on an expression tree object will return a String that contains the 
     * corresponding prefix expression. It calls a private recursive method named preOrder that takes 
     * in the root.
     */
    
    public String prefix() {
        if (root == null) {
            throw new NoSuchElementException("The root is empty, the tree has not yet been constructed.");
        }

        final StringBuilder prefix = new StringBuilder();
        preOrder(root, prefix);
        return prefix.toString();
    }

    private void preOrder(TreeNode node, StringBuilder prefix) {
        if (node != null) {
            prefix.append(" "+node.ch);
            preOrder(node.left, prefix);
            preOrder(node.right, prefix);
        }
    }
    
    /* infix method
     * when invoked on an expression tree object returns a String that contains the 
     * corresponding correct infix expression. Keep in mind that parenthesis will be needed (excessive 
     * parenthesis will be tolerated as long as it is correct). It calls a private recursive
     *  method named inOrder that takes in the root.
     */
    
    public String infix() {
        if (root == null) {
            throw new NoSuchElementException("The root is empty, the tree has not yet been constructed.");
        }
        final StringBuilder infix = new StringBuilder();
        inOrder(root, infix);
        return infix.toString();
    }

    private void inOrder(TreeNode node, StringBuilder infix) {
        if (node != null) {
            infix.append("(");
            inOrder(node.left, infix);
            infix.append(node.ch);
            inOrder(node.right, infix);
            infix.append(")");
        }
    }
   
    /*this method, when invoked on an expression tree object will return the integer value associated 
    * with evaluating the expression tree. It will need to call a private recursive method called evaluate that takes 
    * in the root.
    */
    
    public int eval(){
    	if(root == null){
            throw new NoSuchElementException("The root is empty, the tree has not yet been constructed.");
    	}
    	else{
    		return evaluate(root);
    	}
    }
    
    private int evaluate(TreeNode ptr)
    {
        if (ptr.left == null && ptr.right == null){
            return Integer.parseInt(ptr.ch);
        }
        else{
            int result = 0;
            int left = evaluate(ptr.left);
            int right = evaluate(ptr.right);
            String operator = ptr.ch;
 
            switch (operator){
            	case "+" : 
            		result = left + right; 
            		break;
            	case "-" :
            		result = left - right; 
            		break;
            	case "*" :
            		result = left * right; 
            		break;
            	case "/" :
            		result = left / right; 
            		break;
            	default  : 
            		result = left + right; 
            		break;
            }
            return result;
        }
    }
    
    /*this method, when invoked on an expression tree object will return a String that contains the 
     * corresponding postfix expression. It will need to call a private recursive method that takes 
     * in the root.
     */
    
    public String postfix(){
    	  if (root == null) {
              throw new NoSuchElementException("The root is empty, the tree has not yet been constructed.");
          }
        final StringBuilder postfix = new StringBuilder();
        postOrder(root,postfix);
    	return postfix.toString();
    }
    
    private void postOrder(TreeNode node, StringBuilder postfix) {
    	   if (node != null) {
               postOrder(node.left, postfix);
               postOrder(node.right, postfix);
               postfix.append(node.ch +" ");
           }
    }
}
