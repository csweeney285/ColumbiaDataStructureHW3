Conor Sweeney
cjs2201
README.txt

Programming 1:

This problem uses three files: ExpressionTree.java MyStack.java and Problem1.java . ExpressionTree.java is a custom class that uses my custom MyStack class to create an expression tree.

Expression Tree receives a postfix expression string and uses it to create an Expression tree. It has several methods which produce postfix prefix and infix traversals of the tree. The infix traversal method groups the string with parenthesis while the postfix and prefix simply separate elements with a space. The expression tree will also solve the tree when its eval method is called. All of these methods use private recursive methods.

In Problem1.java the expression tree is tested. If the programs are run on Eclipse it will print out all of the methods in the command line proving that the class works.

Programming 2:

This problem uses a customized version of Weiss’s AvlTree class, and a customized version of his UnderflowException.java as well as Problem2.java and TestFile.txt.

AvlTree class has been customized to receive AnyType as well as an integer which in this case is the line number of where a word appears in the txt file. In Problem2.java AvlTree.java is used to convert TestFile.txt into an AvlTree. Every word and its line number is added to the tree. The tree checks to see if that word exists. If it does it adds the line number to its list of line numbers in the word node. If that number already exists, it is not re added.

Once the entire file is read and placed into the avltree. It is printed and appears on the command line.