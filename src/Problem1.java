/*Conor Sweeney
 * cjs2201
 * Problem1.java
*/

/*
 * This program tests the ExpressionTree class using the postfix string given
 * in the assignment. Other strings will work as well.
 */
public class Problem1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExpressionTree myTree = new ExpressionTree("34 2 - 5 *");
		System.out.println("My Tree:");
		System.out.println("Postfix: " + myTree.postfix());
		System.out.println("Prefix: " + myTree.prefix());
		System.out.println("Infix: " +myTree.infix());
		System.out.println("Eval: " +myTree.eval());
		
		ExpressionTree myTree1 = new ExpressionTree("3 2 + 5 /");
		System.out.println("\nMy Tree1:");
		System.out.println("Postfix: " + myTree1.postfix());
		System.out.println("Prefix: " + myTree1.prefix());
		System.out.println("Infix: " +myTree1.infix());
		System.out.println("Eval: " +myTree1.eval());
		
		ExpressionTree myTree2 = new ExpressionTree("3 2 + 5 / 10 +");
		System.out.println("\nMy Tree2:");
		System.out.println("Postfix: " + myTree2.postfix());
		System.out.println("Prefix: " + myTree2.prefix());
		System.out.println("Infix: " +myTree2.infix());
		System.out.println("Eval: " +myTree2.eval());
	}
}
