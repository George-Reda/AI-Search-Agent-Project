package code;
import java.util.*;
class Stack {

	  // store elements of stack
	  private NodeUpdated arr[];
	  private ArrayList<NodeUpdated> arr2;
	  // represent top of stack
	  private int top;
	  // total capacity of the stack
	  private int capacity;

	  // Creating a stack
	  Stack() {
	    // initialize the array
	    // initialize the stack variables
	    
	    arr2=new ArrayList<NodeUpdated>();
	 
	    top = -1;
	  }

	  // push elements to the top of stack
	  public void push(NodeUpdated x) {
	    
	    // insert element on top of stack
	//    System.out.println("Inserting: waitTime " +x.getNode().getWait() + " Food "+x.getNode().getFood()+" Materials "+x.getNode().getMaterials()+" Energy "+x.getNode().getEnergy()+" prosperity "+ x.getNode().getProsperity()+" "+x.getS() + " Depth " + x.getNode().getDepth());
	    arr2.add(++top, x);
	  }

	  // pop elements from top of stack
	  public NodeUpdated pop() {
		  NodeUpdated x=arr2.get(top);
	//	  System.out.println("popping out : waitTime " + x.getNode().getWait() + " Food "+x.getNode().getFood()+" Materials "+x.getNode().getMaterials()+" Energy "+x.getNode().getEnergy()+" prosperity "+ x.getNode().getProsperity()+" "+x.getS() + " Depth " + x.getNode().getDepth());
	    // if stack is empty
	    // no element to pop
	   
	      // terminates the program
	      
	      
	    

	    // pop element from top of stack
	    return arr2.get(top--);
	    
	  }

	  // return size of the stack
	  public int getSize() {
	    return top + 1;
	  }

	  // check if the stack is empty
	  public Boolean isEmpty() {
	    return top == -1;
	  }

	  // check if the stack is full
	 

	  // display elements of stack
//	  public void printStack() {
//	    for (int i = 0; i <= top; i++) {
//	      System.out.print(arr2.get(i) + ", ");
//	    }
//	  }

	  public static void main(String[] args) {
//	    Stack stack = new Stack();
//
//	    
//
//	    System.out.print("Stack: ");
//	    stack.printStack();
//
//	    // remove element from stack
//	    stack.pop();
//	    System.out.println("\nAfter popping out");
//	    stack.printStack();

	  }
	}