/**
 * This class provide a path for the maze to solve it by
 * checking the starting square as the first element, checking its
 * neighbor based on N,S,E,W
 * We will do the same thing for all the neighbors of starting point
 * until we find a path.
 *
 */

public abstract class MazeSolver {
	
	/**
	 * This method solves the maze by visiting and adding the start square
	 * in the wl which is our worklist, marks it as visited square and 
	 * after that it checks all of its neighbors based on N,S,E,W. And after that
	 * it does this process for all of the neighbors of the start square.
	 * It gets help from our helper method availableNeighbor to see if we need 
	 * to visit the neighbors or not.
	 * @param maze instance variable of Maze class
	 * @param wl worklist for adding the square on it
	 * @return
	 */
	public static Square solve(Maze maze, SearchWorklist wl) {
		
		// Adding the starting square in the worklist
		wl.add(maze.start);
		//Mark start square as visit
		maze.start.visit();
		
		/*
		 * Since our worklist is not empty, we remove the first element
		 * and check if that element is the finish square. If that element is 
		 * the finish square, we will return it. Otherwise, we are gonna check
		 * All the neighbors based on N,S,E,W and also we consider the condition of
		 * the helper method to see if we need to visit that square or not.
		 */
		while(!wl.isEmpty()) {
			
			// current is the first element to remove
			Square current = wl.remove();
			
			// if current is finish square, return it
			if(current.equals(maze.finish)) {
				
				return current;
			}
			
			else {
				
				// check for the north neighbor of the current to check if we need to visit it
				if(availableNeighbor(maze.contents, current, current.getRow() - 1, 
						current.getCol())) {
					
					// Creating the north neighbor square
					Square north = maze.contents[current.getRow() - 1][current.getCol()];
					// mark the north square as visited
					north.visit();
					// Set it to the previous of the current
					north.setPrevious(current);
					//add north square in the work list
					wl.add(north);
				}
				
				// check for the south neighbor of the current to check if we need to visit it
				if(availableNeighbor(maze.contents, current, current.getRow() + 1, 
						current.getCol())) {
					
					// Creating the south neighbor square
					Square south = maze.contents[current.getRow() + 1][current.getCol()];
					// mark the south square as visited
					south.visit();
					// Set it to the previous of the current
					south.setPrevious(current);
					//add south square in the work list
					wl.add(south);
				}
				
				// check for the east neighbor of the current to check if we need to visit it
				if(availableNeighbor(maze.contents, current, current.getRow(),
						current.getCol() + 1)) {
					
					// Creating the east neighbor square
					Square east = maze.contents[current.getRow()][current.getCol() + 1];
					// mark the east square as visited
					east.visit();
					// Set it to the previous of the current
					east.setPrevious(current);
					//add east square in the work list
					wl.add(east);
				}
				
				// check for the west neighbor of the current to check if we need to visit it
				if(availableNeighbor(maze.contents, current, current.getRow(),
						current.getCol() - 1)) {
					
					// Creating the west neighbor square
					Square west = maze.contents[current.getRow()][current.getCol() - 1];
					// mark the west square as visited
					west.visit();
					// Set it to the previous of the current
					west.setPrevious(current);
					//add east square in the work list
					wl.add(west);			
			    }
			}
		}
		return null;
	}
    
	/**
	 * This is a helper method that helps us to check all the neighbors 
	 * of the intended method to if we need to visit it.
	 * We cannot visit the neighbors if they are out of bound or if they are
	 * wall or they have visited.
	 * This method returns true if we need to visit them and false otherwise.
	 * @param contents represents the arrayList of square from maze class 
	 * @param s represents the intended square
	 * @param rowOffset represent the row of the square we need to check it
	 * @param colOffset represent the column of the square we need to check it
	 * @return true if we need to visit it and false otherwise
	 */
	private static boolean availableNeighbor(Square[][] contents, Square s, int rowOffset,
			int colOffset) {
		
		// Check to see if the square we want to check is in the bound
		if((rowOffset >= 0 && rowOffset <= contents.length - 1 ) &&
				(colOffset >= 0 && colOffset <= contents[0].length - 1)) {
			
			// Check to see of the square we want to check is not wall or has not been visited
			if((contents[rowOffset][colOffset].getIsWall() == false) && 
					(contents[rowOffset][colOffset].isVisited() == false)) {
				
				return true;
			}
		}
		
		return false;
	}
}
