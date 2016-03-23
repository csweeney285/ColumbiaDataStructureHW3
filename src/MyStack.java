/*Conor Sweeney
 * cjs2201
 * MyStack.java
*/

//create public custom stack class
public class MyStack <AnyType> {
	
	//set variables
	private int size;
	private AnyType[] stackArray;
	private int top;
	
	//create stack
	//user sets the number of objects in the array
	//and the rest is calculated
	//suppress warning to create AnyType Array within class
	@SuppressWarnings("unchecked")
	public MyStack(int size) {
		this.size = size;
        stackArray = (AnyType[])new Object[size]; //Creation of Generic Stack Array
        top = -1; // initialize Stack to with -1
	}
	
	//custom push method
	//increase the value of top as well as setting it to j
	public void push(AnyType j) {
		stackArray[++top] = j;
	}
	
	//custom pop method
	public AnyType pop() {
		return stackArray[top--];
	}
	
	//custom peek method
	//return top value in array
	public AnyType peek() {
		return stackArray[top];
	}
	
	//custom is empty method
	public boolean isEmpty() {
		return (top == -1);
	}
	
	//custom is full method
	public boolean isFull() {
		return (top == size - 1);
	}
}
