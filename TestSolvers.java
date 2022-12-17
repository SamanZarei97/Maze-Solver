/**
 * Name: Saman Zarei
 * This file is for testing our program to make sure
 * for the correctness of implementation.
 */
import java.util.ArrayList;

/*
 * Write your JUnit tests here
 * Use the formatMaze() method to get nicer JUnit output
 */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class is for testing the different part of program
 * by testing it against some chaff and wheat test to make sure
 * about the correctness of the program.
 * @author Saman Zarei
 *
 */
public class TestSolvers {

	/* Helper method to compare two mazes */
	public void checkMaze(SearchWorklist wl, Maze startMaze, String[] expected) {
		Square s = MazeSolver.solve(startMaze, wl);
		if(expected == null) { assertNull(s); }
		else {
			ArrayList<Square> sp = startMaze.storePath();
			String actualStr = formatMaze(startMaze.showSolution(sp));
			String expectedStr = formatMaze(expected);
			assertEquals(expectedStr, actualStr);
		}
	}	

	/* Helper method to format String[] output as String */
	public String formatMaze(String[] arr) {
		String result = "";
		for (String s: arr)
			result += "\n"+s;
		return (result+"\n");
	}
    
	/**
	 * This method check the correctness of the Stackworklist when
	 * we add square in stack work list and we expected that the Stackworklist
	 * should not be empty. adding is based on stack behavior.
	 */
	@Test
	public void testAddandIsemptyForStackWorklist() {
		
		Square s1 = new Square(0,0,false);
		Square s2 = new Square(1,0,false);
		Square s3 = new Square(0,1,false);
		Square s4 = new Square(1,1,false);
		
		SearchWorklist swl = new StackWorklist();
		
		swl.add(s1);
		swl.add(s2);
		swl.add(s3);
		swl.add(s4);
		
		assertEquals(false, swl.isEmpty());
	}
	
	/**
	 * This method check the correctness of the Stackworklist when 
	 * we remove all the squares after adding them and we expect 
	 * the Stackworklist be empty. adding and removing is based on stack behavior.
	 */
	@Test
	public void testRemoveAndIsemptyForStackWorklist() {
		
		Square s1 = new Square(0,0,false);
		Square s2 = new Square(1,0,false);
		Square s3 = new Square(0,1,false);
		Square s4 = new Square(1,1,false);
		
		SearchWorklist swl = new StackWorklist();
		
		swl.add(s1);
		swl.add(s2);
		swl.add(s3);
		swl.add(s4);
		
		swl.remove();
		swl.remove();
		swl.remove();
		swl.remove();
		assertEquals(true, swl.isEmpty());
	}
	
	/**
	 * This class check the correctness of Stackworklist when
	 * we remove a square from the Stackworklist to make sure about
	 * Stackworklist behavior means removing the last added square.
	 */
	@Test
	public void testRemovingSquareForStackworklist() {
		
		Square s1 = new Square(0,0,false);
		Square s2 = new Square(1,0,false);
		Square s3 = new Square(0,1,false);
		Square s4 = new Square(1,1,false);
		
		SearchWorklist swl = new StackWorklist();
		
		swl.add(s1);
		swl.add(s2);
		swl.add(s3);
		swl.add(s4);
		
		assertEquals(s4, swl.remove());
	}
    
	/**
	 * This method check the correctness of the Queueworklist when
	 * we add square in queue work list and we expected that the QueueWorklist
	 * should not be empty. adding is based on queue behavior.
	 */
	@Test
	public void testAddAndIsemptyForQueuekWorklist() {
		
		Square s1 = new Square(0,0,false);
		Square s2 = new Square(1,0,false);
		Square s3 = new Square(0,1,false);
		Square s4 = new Square(1,1,false);
		
		SearchWorklist qwl = new QueueWorklist();
		
		qwl.add(s1);
		qwl.add(s2);
		qwl.add(s3);
		qwl.add(s4);
		
		assertEquals(false, qwl.isEmpty());
	}
	
	/**
	 * This method check the correctness of the Queueworklist when 
	 * we remove all the squares after adding them and we expect 
	 * the Queueworklist be empty. Adding and removing is based on Queue behavior.
	 */
	@Test
	public void testRemoveAndIsemptyForQueueWorklist() {
		
		Square s1 = new Square(0,0,false);
		Square s2 = new Square(1,0,false);
		Square s3 = new Square(0,1,false);
		Square s4 = new Square(1,1,false);
		
		SearchWorklist qwl = new QueueWorklist();
		
		qwl.add(s1);
		qwl.add(s2);
		qwl.add(s3);
		qwl.add(s4);
		
		qwl.remove();
		qwl.remove();
		qwl.remove();
		qwl.remove();
		assertEquals(true, qwl.isEmpty());
	}
	
	/**
	 * This class check the correctness of Queueworklist when
	 * we remove a square from the Queueworklist to make sure about
	 * Queueworklist behavior means removing the first added square.
	 */
	@Test
	public void testRemovingSquareForQueuekworklist() {
		
		Square s1 = new Square(0,0,false);
		Square s2 = new Square(1,0,false);
		Square s3 = new Square(0,1,false);
		Square s4 = new Square(1,1,false);
		
		SearchWorklist qwl = new QueueWorklist();
		
		qwl.add(s1);
		qwl.add(s2);
		qwl.add(s3);
		qwl.add(s4);
		
		assertEquals(s1, qwl.remove());
	}
	
	/**
	 * This method is to determine the correctness of the program
	 * when we need to solve the solution path of our maze from start to finish
	 * it solves the maze by StackWorklist(DFS)
	 * # = wall
	 * _ = empty space
	 * S = Start
	 * F = Finish
	 * '*' = solution path
	 */
	@Test
	public void testClassExample() {
		Maze m = new Maze(new String[]{
				"#_#_",
				"____",
				"_##S",
				"F___"
			});
		String[] stackExpected = {
				"#_#_",
				"____",
				"_##S",
				"F***"
			};
		
		/* call checkMaze to solve Maze m (using a stack) with your solve method
		   and assert that the solution you get matches stackExpected */
		checkMaze(new StackWorklist(), m, stackExpected);
	}
	
	/**
	 * This method check the correctness of the program
	 * by having different result for expected string and actual string
	 * and it supposes to pass this method when we test them as 2 non equal 
	 * String array
	 */
	@Test
	public void testFailingOrder() {
		String[] expected = {
				"#_#_",
				"****",
				"*##S",
				"F___"
			};
		
		String[] actualAndWrong= {
				"#_#_",
				"____",
				"_##S",
				"F***"
			};
		
		assertNotEquals(formatMaze(expected), formatMaze(actualAndWrong));
	}
	
	/**
	 * This method checks the correctness of the program
	 * by the solving the maze that we have had in the discussion. It solves
	 * the maze by StackWorklist(DFS) and original array and expected array
	 * we need to get.
	 */
	@Test
	public void testDiscussionDFS() {
		Maze m = new Maze(new String[]{
				"#___",
				"__F_",
				"S##_",
				"____"
			});
		String[] stackExpected = {
				"#___",
				"__F*",
				"S##*",
				"****"
			};
		
		/* call checkMaze to solve Maze m (using a stack) with your solve method
		   and assert that the solution you get matches stackExpected */
		checkMaze(new StackWorklist(), m, stackExpected);
	}
	
	/**
	 * This method checks the correctness of the program
	 * by the solving the maze that we have had in the discussion. It solves
	 * the maze by QueueWorklist(BFS) and having original array
	 *  and compares the original string array with expected one. 
	 */
	@Test
	public void testDiscussionBFS() {
		Maze m = new Maze(new String[]{
				"#___",
				"__F_",
				"S##_",
				"____"
			});
		
		String[] queueExpected = {
				"#___",
				"**F_",
				"S##_",
				"____"
			};
		
		/* call checkMaze to solve Maze m (using a queue) with your solve method
		   and assert that the solution you get matches queueExpected */
		checkMaze(new QueueWorklist(), m, queueExpected);
	}
	
	/**
	 * This method checks the correctness of program
	 * when there is no path from starting to finish by
	 * BFS method
	 */
	@Test
	public void testNoPathBFS() {
		
		Maze m = new Maze(new String[] {
				
				"F___",
				"####",
				"####",
				"#S##"
		});
		
		checkMaze(new QueueWorklist(), m, null);
	}
	
	/**
	 * This method checks the correctness of program
	 * when there is no path from starting to finish by
	 * DFS method
	 */
	@Test
	public void testNoPathDFS() {
		
		Maze m = new Maze(new String[] {
				
				"F___",
				"####",
				"####",
				"#S##"
		});
		
		checkMaze(new StackWorklist(), m, null);
	}
	
	/**
	 * This method checks the correctness of the program
	 * when the starting square and finish square are next to
	 * each other by DFS method.
	 */
	@Test
	public void testSquaresNextToEachOtherDFS() {
		
		Maze m = new Maze(new String[] {
			
			"__##",
			"_##_",
			"__FS",
			"####"
		});
		
		String[] expected = {
			
				"__##",
				"_##_",
				"__FS",
				"####"	
		};
		
		checkMaze(new StackWorklist(), m, expected);
	}
	
	/**
	 * This method checks the correctness of the program
	 * when the starting square and finish square are next to
	 * each other by BFS method.
	 */
	@Test
	public void testSquaresNextToEachOtherBFS() {
		
		Maze m = new Maze(new String[] {
			
			"__##",
			"_##_",
			"__FS",
			"####"
		});
		
		String[] expected = {
			
				"__##",
				"_##_",
				"__FS",
				"####"	
		};
		
		checkMaze(new QueueWorklist(), m, expected);
	}
	
	/**
	 * This method checks the correctness of the program
	 * when there is no wall and solves by BFS way.
	 */
	@Test
	public void testNoWallBFS() {
		
		Maze m = new Maze(new String[] {
			
			"____",
			"__S_",
			"___F",
			"____",
		});
		
		String[] expected = {
			
			"____",
			"__S_",
			"__*F",
			"____"
		};
		
		checkMaze(new QueueWorklist(), m, expected);
	}
	
	/**
	 * This method checks the correctness of the program
	 * when there is no wall and solves by DFS way.
	 */
	@Test
	public void testNoWallDFS() {
		
		Maze m = new Maze(new String[] {
				
				"_F__",
				"__S_",
				"____",
				"____",
			});
		
		String[] expected = {
			
			"_F__",
			"_*S_",
			"____",
			"____"
		};
		
		checkMaze(new StackWorklist(), m, expected);
		
	}
	
	/**
	 * This method checks the correctness of the program
	 * when there are lot of walls between start and finish
	 * by BFS way
	 */
	@Test
	public void testWithManyWallsBFS() {
		
		Maze m = new Maze(new String[] {
				
				"F###",
				"_#S#",
				"___#",
				"####",
			});
		
		String[] expected = {
			
			"F###",
			"*#S#",
			"***#",
			"####"
		};
		
		checkMaze(new QueueWorklist(), m, expected);
	}
	
	/**
	 * This method checks the correctness of the program
	 * when there are lot of walls between start and finish
	 * by DFS way
	 */
	@Test
	public void testWithManyWallsDFS() {
		
		Maze m = new Maze(new String[] {
				
				"_F##",
				"_#S#",
				"___#",
				"####",
			});
		
		String[] expected = {
			
			"*F##",
			"*#S#",
			"***#",
			"####"
		};
		
		checkMaze(new StackWorklist(), m, expected);
	}
	
	/**
	 * This method tests the correctness of the program when
	 * the start and finish are in the same line by BFS
	 */
	@Test
	public void testInStraightLineBFS() {
		
		Maze m = new Maze(new String[] {
				
				"_F___S",
				"_#####",
				"___###",
				"######"
			});
		
		String[] expected = {
			
				"_F***S",
				"_#####",
				"___###",
				"######"
		};
		
		checkMaze(new QueueWorklist(), m, expected);
	}
	
	/**
	 * This method tests the correctness of the program when
	 * the start and finish are in the same line by DFS way
	 */
	@Test
	public void testInStraightLineDFS() {
		
		Maze m = new Maze(new String[] {
				
				"_F___S",
				"_#####",
				"___###",
				"######"
			});
		
		String[] expected = {
			
				"_F***S",
				"_#####",
				"___###",
				"######"
		};
		
		checkMaze(new StackWorklist(), m, expected);
	}
	
	/**
	 * This method checks the correctness of the program
	 * when start and finish are in different corner 
	 * it solves by BFS way
	 */
	@Test
	public void testInDifferentConrnerBFS() {
		
		Maze m = new Maze(new String[] {
			
			"F__#",
			"____",
			"_##_",
			"###S"
		});
		
		String[] expected = {
			
			"F**#",
			"__**",
			"_##*",
			"###S"
		};
		
		checkMaze(new QueueWorklist(), m, expected);
	}
	
	/**
	 * This method checks the correctness of the program
	 * when start and finish are in different corner 
	 * it solves by DFS way
	 */
	@Test
	public void testInDifferentConrnerDFS() {
		
		Maze m = new Maze(new String[] {
			
			"F__#",
			"____",
			"_##_",
			"###S"
		});
		
		String[] expected = {
			
			"F__#",
			"****",
			"_##*",
			"###S"				
		};
		
		checkMaze(new StackWorklist(), m, expected);
		
		
	}
	
	/**
	 * This method check the correctness of the program
	 * When start and finish are next to each other diagonally 
	 * by BFS method
	 */
	@Test
	public void testDiagonalBFS() {
		
		Maze m = new Maze(new String[] {
				
				"F__#",
				"_S__",
				"_##_",
				"####"
			});
		
		String[] expected = {
			
			"F*_#",
			"_S__",
			"_##_",
			"####"
		};
		
		checkMaze(new QueueWorklist(), m, expected);
	}
	
	/**
	 * This method check the correctness of the program
	 * When start and finish are next to each other diagonally 
	 * by DFS method
	 */
	@Test
	public void testDiagonalDFS() {
		
		Maze m = new Maze(new String[] {
				
				"F__#",
				"_S__",
				"_##_",
				"####"
			});
		
		String[] expected = {
			
			"F__#",
			"*S__",
			"_##_",
			"####"
		};
		
		checkMaze(new StackWorklist(), m, expected);
	}
}



