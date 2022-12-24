/**
 * This file will implement the work list
 * in 2 different ways: Queue and Stack
 */

import java.util.*;

/**
 * This class implements the work list by the stack ways
 *
 */
class StackWorklist implements SearchWorklist {
	
	// Stack Arraylist
	ArrayList<Square> stack;
	
	/**
	 * This is a constructor that initialize the stack work list
	 */
	public StackWorklist() {
		
		// Initializing the stack
		this.stack = new ArrayList<Square>();
	}
	
	/**
	 * This method adds square to the work list
	 * by stack method which is push. It means
	 * it push the square in work list
	 * @param c the square we want to push it
	 */
	public void add(Square c) {
		
		//Pushing Square in stack worklist
		this.stack.add(c);
	}
	
	/**
	 * This method removes and returns the square
	 * from the list by stack way which is pop. It means
	 * it pops the square from stack worklist and returns it.
	 * @return returns the popping square
	 */
	public Square remove(){
		
		// popping and returning the square from work list
		return this.stack.remove(this.stack.size()-1);
	}
	
	/**
	 * This method returns true if the size of 
	 * stack work list is zero and false otherwise
	 * @return true or false
	 */
	public boolean isEmpty() {
		
		if(this.stack.size() == 0) {
			
			return true;
		}
		
		else {
			
			return false;
		}
	}	
}

/**
 * This class implements the work list by the queue ways
 * @author Saman Zarei
 */
class QueueWorklist implements SearchWorklist {
	
	// Queue arrayList
	ArrayList<Square> queue;
	
	/**
	 * This is a constructor that initialize the queue work list 
	 */
	public QueueWorklist() {
		
		// initializing the queue work list
		this.queue = new ArrayList<>();
	}
	
	/**
	 * This method adds square to the work list
	 * by queue method which is enqueue. It means
	 * it enqueues the square in work list
	 * @param c the square we want to enqueue it
	 */
	public void add(Square c) {
		
		// Enqueue c in queue work list
		this.queue.add(c);
	}
	
	/**
	 * This method removes and returns the square
	 * from the list by queue way which is dequeue. It means
	 * it dequeues the square from queue worklist and returns it.
	 * @return returns the dequeuing square
	 */
	public Square remove() {
		
		return this.queue.remove(0);
	}
	
	/**
	 * This method returns true if the size of 
	 * queue work list is zero and false otherwise
	 * @return true or false
	 */
	public boolean isEmpty() {
		
		if(this.queue.size() == 0) {
			
			return true;
		}
		
		else {
			
			return false;
		}
	}
}

public interface SearchWorklist {
	void add(Square c);
	Square remove();
	boolean isEmpty();
}
