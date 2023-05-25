# Maze Solver
The Maze Solver is a Java program that provides a solution for traversing a maze. It uses either a depth-first search (DFS) or a breadth-first search (BFS) algorithm to find the path from the starting point to the finish point in the maze.

## Files

- Maze.java: This file contains the implementation of the Maze class, which represents a maze and provides methods for initializing the maze, storing the path, and showing the solution.
- MazeSolver.java: This file contains the MazeSolver class, which provides methods for solving the maze using either DFS or BFS algorithm.
- SearchWorklist.java: This file defines the SearchWorklist interface, which is implemented by the StackWorklist and QueueWorklist classes to provide different types of worklists for the maze solver.
- Square.java: This file defines the Square class, which represents a square in the maze and stores information about its position, whether it is a wall or not, whether it has been visited, and its previous square.
- TestSolvers.java: This file contains JUnit tests to verify the correctness of the maze solver implementation.

## Usage
To use the Maze Solver, you can create an instance of the Maze class by providing a maze specification in the form of a string array. The maze specification should contain characters representing the maze structure, such as walls ('#'), empty spaces ('_'), the start point ('S'), and the finish point ('F').

Example usage:
    
    ''' 
    // Create a maze from a maze specification
    Maze maze = new Maze(new String[]{
        "#_#_",
        "____",
        "_##S",
        "F___"
    });

    // Solve the maze using DFS
    Square solution = MazeSolver.solve(maze, new StackWorklist());

    // Get the solution path as an ArrayList of squares
    ArrayList<Square> path = maze.storePath();

    // Show the solution path as a string array
    String[] solutionString = maze.showSolution(path);

## Acknowledgments
The Maze Solver implementation is based on algorithms commonly used for maze solving. The code structure and documentation were inspired by various maze-solving algorithms and data structures.

Please note that this project is for educational purposes and coverd all edge cases bot might not optimizations. Use it as a starting point for further development or as a learning resource.   

