import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*Conor Sweeney
 * cjs2201
 * Problem2.java
*/

//program to test my customized version of Weiss's avltree
public class Problem2 {
	
	//scanner is needed to convert .txt to strings for use
	private static Scanner scanner;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		//create a string AvlTree
		AvlTree<String> myAvlTree = new AvlTree<String>();
		
		//declare an integer variable to count the lines in the scanner
		//when a new line goes through the loop it counts
		Integer count = 0;
		String tempString;
		//add the txt file to scan
		//I am using the given hw file
		scanner = new Scanner(new File("TestFile.txt"));
		
		//run the scanner through a while loop
		//the scanner converts each line to a string and counts the lines
		//the loop converts the string to a lower case string
		//then splits the string into an array of words
		//the array of words is run through another loop where punctuation is removed
		//as long as the string is not equal to "" it is inserted into the avl tree
		while(scanner.hasNextLine()){
			count++;
			tempString = null;
			tempString = scanner.nextLine();
			String tempStringLowerCase = tempString.toLowerCase();
			String[] words =  tempStringLowerCase.split("\\s+");
			for(int x = 0; x < words.length; x++){
				String tempStringFromArray = words[x];
				String tempStringNoPunctuation = tempStringFromArray.replaceAll("[^A-Za-z0-9]", "");
				if(!tempStringNoPunctuation.equals("")){
					myAvlTree.insert(tempStringNoPunctuation, count);
				}
			}
		}
		
		//print the completed avl tree
		//all the words and the lines in which they are located at will be printed in the command line
		myAvlTree.printTree();
	}
}
