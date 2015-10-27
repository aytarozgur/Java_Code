/*  Student information for assignment:
 *
 *  On my honor, Anna Mengjie Yu and Chang Chih Chi, this programming assignment is Our own work
 *  and We have not provided this code to any other student.
 *
 *  Number of slip days used: 0
 *
 *  Student 1: (Student whose turnin account is being used) Anna Mengjie Yu
 *  UTEID: my3852
 *  email address: annayu2010@gmail.com
 *  Grader name: Eric
 *  Section number: 90130
 *  
 *  Student 2: Chang Chih Chi
 *  UTEID: cc45524
 *  email address: johnnychang6@gmail.com
 *  Grader name: Eric
 *  Section number: 90130
 *  
 */


//imports

import java.util.*;
import java.awt.*;

public class Recursive {

	/**
	 * Problem 1: convert a base 10 int to binary recursively.<br> 
	 *   pre: n >= 0<br>
	 *   post: Returns a String that represents N in binary.
	 *   All chars in returned String are '1's or '0's. Most significant digit is at position 0
	 *   @param n the base 10 int to covnert to base 2
	 */
	public String getBinary(int n) {
		if( n < 0) 
			throw new IllegalArgumentException("Failed precondition: getBinary. n must be >= 0. n: " + n);
		else
			if (n <= 1)
				return Integer.toString(n);
			return getBinary(n/2) + Integer.toString(n%2);        		
	}


	/**
	 * Problem 2: reverse a String recursively.<br>
	 *   pre: stringToRev != null<br>
	 *   post: returns a String that is the reverse of stringToRev
	 *   @param stringToRev the String to reverse.
	 */
	public String revString(String stringToRev) {
		if( stringToRev == null)
			throw new IllegalArgumentException("Failed precondition: revString. parameter may not be null.");
		else
		{
			if (stringToRev.length() == 0)
				return "";
			else if(stringToRev.length() == 1)
				return stringToRev;
			else
			{
				return revString(stringToRev.substring(1)) +stringToRev.charAt(0);
			}
		}
	}


	/**
	 * Problem 3: Returns the number of elements in data 
	 * that are followed directly by value that is
	 * double that element. 
	 * pre: data != null
	 * post: return the number of elements in data that are followed immediately by double the value
	 */
	public int nextIsDouble(int[] data) {
		if (data == null)
			throw new IllegalArgumentException("Failed precondition: data may not be null.");
		else if (data.length == 0)
			return 0;
		else
			return nextIsDoubleHelper(data, 0);
	}


	// CS314 students, add your nextIsDouble helper method here

	private int nextIsDoubleHelper(int[] data, int index) {
		if (index == data.length -1)
			return 0;
		else
		{
			//if element at position (index+1) is twice of the element at position(index)
			if (data[index+1] == 2 * data[index])
				return 1 + nextIsDoubleHelper(data, index+1);
			else
				return nextIsDoubleHelper(data,index+1);  		 
		}		
	}

	/**  Problem 4: Find all combinations of mnemonics for the given number.<br>
	 *   pre: number != null, all characters in number are digits<br>
	 *   post: see tips section of assigment handout
	 *   @param number The number to find mnemoics for
	 */
	public ArrayList<String> listMnemonics(String number) {
		if( number == null ||  !allDigits(number))
			throw new IllegalArgumentException("Failed precondition: listMnemonics");

		ArrayList<String> result = new ArrayList<String>();
		recursiveMnemonics(result, "", number);
		return result;
	}


	/*
	 * Helper method for listMnemonics
	 * mnemonics stores completed mnemonics
	 * mneominicSoFar is a partial (possibly complete) mnemonic
	 * digitsLeft are the digits that have not been used from the original number
	 */
	private void recursiveMnemonics(ArrayList<String> mnemonics, 
			String mnemonicSoFar, String digitsLeft) {

		// base case is no digits left
		if (digitsLeft.length() == 0)
			mnemonics.add(mnemonicSoFar);
		else
		{
			char digit = digitsLeft.charAt(0);
			//get the total letters correspond the first digit
			String letters1 = digitLetters(digit);

			for (int i = 0; i < letters1.length(); i++)
			{
				char letter = letters1.charAt(i); // get the first letter from the string
				String addedSoFar = mnemonicSoFar + letter; 
				//recursive call with the rest of the digits
				recursiveMnemonics(mnemonics, addedSoFar, digitsLeft.substring(1));  
			}   	
		}				
	}

	// used by method digitLetters
	private static final String[] letters = {"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};


	/* helper method for recursiveMnemonics
	 * pre: ch is a digit '0' through '9'
	 * post: return the characters associated with this digit on a phone keypad
	 */
	private String digitLetters(char ch) {
		assert ('0' <= ch) && (ch <= '9') : "Failed precondition: digitLetters";
		int index = ch - '0';
		return letters[index];
	}


	/* helper method for listMnemonics
	 * pre: s != null
	 * post: return true if every character in s is a digit ('0' through '9')
	 * */
	private boolean allDigits(String s) {
		assert s != null : "Failed precondition: allDigits";
		boolean allDigits = true;
		int i = 0;
		while(i < s.length() && allDigits){
			allDigits = s.charAt(i) >= '0' && s.charAt(i) <= '9';
			i++;
		}
		return allDigits;
	}


	/**
	 * Problem 5: Create a DrawingPanel and place Sierpinski triangles in it. 
	 * The lower left corner shall be 20 pixels 
	 * from the left edge of the window
	 * and 20 pixels from the bottom of the window.
	 * @param windowSize > 20
	 * @param minSideLength > 4
	 * @param startingSideLength > minSideLength
	 */
	public void drawTriangles(int windowSize, 
			int minSideLength, int startingSideLength){

		DrawingPanel p = new DrawingPanel(windowSize, windowSize);
		Graphics g = p.getGraphics();
		g.setColor(Color.BLUE);
		drawTriangles(minSideLength, startingSideLength, 20, windowSize - 20, g);
	}

	// helper method for drawTriangles
	private void drawTriangles(int minSideLength, double currentSideLength, 
			double x1, double y1, Graphics g) {
		//base case just draw the triangle
		if (currentSideLength <= minSideLength)
		{
			int xpoints[] = {(int)(x1), (int)(x1+0.5*currentSideLength), (int)(x1+currentSideLength)};
			int ypoints[] = {(int)(y1), (int)(y1-Math.sqrt(3)*currentSideLength/2), (int)(y1)};
			int npoints = 3;

			g.fillPolygon(xpoints, ypoints, npoints);
		}
		//make three recursive calls
		else
		{			
			drawTriangles(minSideLength, currentSideLength/2, x1, y1, g);
			drawTriangles(minSideLength, currentSideLength/2, (int)(x1+0.25*currentSideLength), (int)(y1-Math.sqrt(3)*currentSideLength/4), g);
			drawTriangles(minSideLength, currentSideLength/2, (int)(x1+0.5*currentSideLength), (int)(y1), g);
		}
	}


	/**
	 * Problem 6: Draw a Sierpinski Carpet.
	 * @param size the size in pixels of the window
	 * @param limit the smallest size of a sqauer in the carpet.
	 */
	public void drawCarpet(int size, int limit) {
		DrawingPanel p = new DrawingPanel(size, size);
		Graphics g = p.getGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0,0,size,size);
		g.setColor(Color.WHITE);
		drawSquares(g, size, limit, 0, 0);
	}


	/* Helper method for drawCarpet
	 * Draw the individual squares of the carpet.
	 * @param g The Graphics object to use to fill rectangles
	 * @param size the size of the current square
	 * @param limit the smallest allowable size of squares
	 * @param x the x coordinate of the upper left corner of the current square
	 * @param y the y coordinate of the upper left corner of the current square
	 */
	private static void drawSquares(Graphics g, int size, int limit, double x, double y) {

		if (size > limit)
		{
			//fill the center square with white, "cut out" the board
			g.fillRect((int)(x+ size * 1/3), (int)(y + size *1/3), size/3, size/3);
			
			//eight recursive calls on the new vertices
			drawSquares(g, size/3, limit, (int)x, (int)y);
			drawSquares(g, size/3, limit, (int)(x + size* 1/3), (int)y);
			drawSquares(g, size/3, limit, (int)(x + size * 2/3), (int)y);
			drawSquares(g, size/3, limit, (int)(x), (int)(y + size *1/3));
			drawSquares(g, size/3, limit, (int)(x + size * 2/3), (int)(y + size * 1/3));
			drawSquares(g, size/3, limit, (int)(x) , (int)(y + size * 2/3));
			drawSquares(g, size/3, limit, (int)(x + size * 1/3), (int)(y + size * 2/3));
			drawSquares(g, size/3, limit, (int)(x + size * 2/3), (int)(y + size * 2/3));			
		}

	}

	
	// size of Sudoko board
	/**
	 * The size of the Sudoko board. Value will be a perfect square greater than 0.
	 */
	public static final int BOARD_SIZE = 9; // must be perfect square

	/**
	 * The size of a mini marix on the Sodoko board.
	 */
	public static final int MINI_SIZE = (int)(Math.sqrt(BOARD_SIZE));


	/** 
	 * Problem 7: Find a solution to a Sudoko puzzle. 
	 * <br>pre: board != null, board is 9 by 9. 
	 * <br>post: return a board that is the solved puzzle 
	 * or a copy of the original board if there is no solution
	 * @param startBoard The starting board. 
	 * Empty values = 0, given values = 1 through 9 may not be changed
	 */
	public int[][] getSudokoSolution(int[][] startBoard) {
		if(startBoard == null || startBoard.length != BOARD_SIZE || startBoard[0].length != BOARD_SIZE)
			throw new IllegalArgumentException("Violation of precondition in getSudo");

		// store solution in board so we don't change startBoard
		int[][] board = copyBoard(startBoard); 

		// CS314 students. Call your recursive method here!
		//if sodoKuHelper found a solution
		sudokuHelper(board,0,0);							
		return board;
	}


	// CS314 students, add your recursive sudoko solver method here
	private boolean sudokuHelper(int[][] board, int row, int col) {	
		//base case: successfully traverse the board
		if ( row == BOARD_SIZE)
			return true;
		//recursive cases: if the current position is not 0, recursive call on next position
		else if (board[row][col] != 0)
		{
			return sudokuHelper(board, getNextRow(row, col),getNextCol(col));
		}
		//if current position is 0
		else 
		{
			for (int i = 1; i < 10; i++)
			{
				//place a number
				board[row][col] = i;
				//check if it's valid
				if (digitsOkay(board,row,col))
				{
					if( sudokuHelper(board, getNextRow(row,col), getNextCol(col)))
						return true;
				}
				//undo the choice
				board[row][col] = 0;								
			}						
			return false;
		}
	}
	
	//helper method, get next column position
	private int getNextCol(int col) {		
		//if already on the last col, update row
		if ( col == BOARD_SIZE -1)
			return 0;
		else
			return col+1;
	}
	
	//helper method get next row position
	private int getNextRow(int row, int col) {
		//if at the end of the row, we will begin a new row
		if ( col == BOARD_SIZE -1)
			return row +1;
		else
			return row;
	}


	// helper method to make a copy of a sudoko.
	// CS314 students, you DO NOT need to call this method.
	private static int[][] copyBoard(int[][] startBoard) {
		int[][] result = new int[startBoard.length][];
		for(int r = 0; r < result.length; r++)
			result[r] = Arrays.copyOf(startBoard[r], startBoard[r].length);
		return result;
	}



	// Helper method check to ensure no digit other than zero
	// is repeated in a given row, column, or mini matrix.
	private static boolean digitsOkay(int[][] board, int row, int col) {
		return portionOkay(row, 0, 0, 1, board) &&
				portionOkay(0, col, 1, 0, board) &&
				miniMatrixOkay(row, col, board);

	}



	// helper method to see if no repeat digits (other than 0) in a row or column
	// CS314 students, you don't need to call this method directly
	private static boolean portionOkay(int rowStart, int colStart, int rowChange, int colChange, int[][] board) {
		// check digits in row or column. 
		// for all non zero digits update array of booleans. if digit appears twice then
		// used[digit] is set to true first time and we return false second time
		boolean[] used = new boolean[BOARD_SIZE + 1]; // don't use zero element in array

		// pretty GACKY, change to while loop?
		for(int i = 0, row = rowStart, col = colStart; i < BOARD_SIZE; i++, row += rowChange, col += colChange) {
			int digit = board[row][col];
			if(digit != 0){
				if(used[digit])
					return false; // duplicate!!
				used[digit] = true; // mark as used
			}
		}
		return true; // no repeats found!
	}

	// helper to check that no digits other than 0 are
	// repeated in the mini matric cell row, col
	// is a part of.
	// CS314 students, you don't need to call this method directly
	private static boolean miniMatrixOkay(int row, 
			int col, int[][] board) {

		boolean[] used = new boolean[BOARD_SIZE + 1];

		// figure out upper left indices for mini matrix
		// we need to check

		// row 0,1,2 -> 0, row 3, 4, 5 -> 3, row 6, 7, 8 -> 6 
		// same logic for column
		int new_row = (row / MINI_SIZE) * MINI_SIZE;
		int new_col = (col / MINI_SIZE) * MINI_SIZE;

		for(int r = 0; r < 3; r++)
			for(int c = 0; c < 3; c++)  {
				int digit = board[new_row + r][new_col + c];
				if(digit != 0){
					if(used[digit])
						return false; // duplicate!!
					used[digit] = true; // mark as used
				}
			}
		return true;
	}    


	/**
	 * Problem 8: Determine if water at a given point 
	 * on a map can flow off the map.
	 * <br>pre: map != null, map.length > 0, 
	 * map is a rectangular matrix, 0 <= row < map.length, 0 <= col < map[0].length
	 * <br>post: return true if a drop of water starting at the location 
	 * specified by row, column can reach the edge of the map, false otherwise.
	 * @param map The elevations of a section of a map.
	 * @param row The starting row of a drop of water.
	 * @param col The starting column of a drop of water.
	 */
	public boolean canFlowOffMap(int[][] map, int row, int col) {
		//check preconditions
		if( map == null || map.length == 0 || !isRectangular(map) || !inbounds(row, col, map))
			throw new IllegalArgumentException("Failed precondition: canFlowOffMap");
		else
		{
			//base case: if the current position is on the edge of the board then return true
			if (row == 0 || col == 0 || row == map.length -1 || col == map[0].length -1)
				return true;
			else
			//recursive case: try four directions: North, South, West & East
				return (map[row][col-1] < map[row][col] && canFlowOffMap(map, row, col-1) 
						|| map[row][col+1] < map[row][col] && canFlowOffMap(map, row, col+1)
						|| map[row-1][col] < map[row][col] && canFlowOffMap(map, row-1, col) 
						|| map[row+1][col] < map[row][col] && canFlowOffMap(map, row+1, col));
		}

	}




	/* helper method for canFlowOfMap - CS314 students you should not have to 
	 * call this method,
	 * pre: mat != null, 
	 */
	private boolean inbounds(int r, int c, int[][] mat) {
		assert mat != null : "Failed precondition: inbounds";
		return r >= 0 && r < mat.length && mat[r] != null && c >= 0 && c < mat[r].length;
	}

	/* 
	 * helper method for canFlowOfMap - CS314 stdents you should not have to 
	 * call this method,
	 * pre: mat != null, mat.length > 0
	 * post: return true if mat is rectangular
	 */
	private static boolean isRectangular(int[][] mat) {
		assert (mat != null) && (mat.length > 0) : "Violation of precondition: isRectangular";

		boolean correct = true;
		final int numCols = mat[0].length;
		int row = 0;
		while( correct && row < mat.length) {
			correct = (mat[row] != null) && (mat[row].length == numCols);
			row++;
		}
		return correct;
	}


	/**
	 * Problem 9: Find the minimum difference possible between teams
	 * based on ability scores. The number of teams may be greater than 2.
	 * The goal is to minimize the difference between the team with the 
	 * maximum total ability and the team with the minimum total ability.
	 * <br> pre: numTeams >= 2, abilities != null, abilities.length >= numTeams
	 * <br> post: return the minimum possible difference between the team
	 * with the maximum total ability and the team with the minimum total
	 * ability. 
	 * @param numTeams the number of teams to form. 
	 * Every team must have at least one member
	 * @param abilities the ability scores of the people to distribute
	 * The return value will be greater than or equal to 0.
	 */
	public int minDifference(int numTeams, int[] abilities) {
		if (numTeams < 2 || abilities == null || abilities.length < numTeams)
			throw new IllegalArgumentException("Input numTeams and abilities are not valid.");

		
		//Create an ArrayList of ArrayList of Integers indicates team list
		ArrayList<ArrayList<Integer>> teams = new ArrayList<ArrayList<Integer>>();
		//initiate the size of the team list according to the given numTeams
		for ( int i = 0; i < numTeams; i++)
		{
			teams.add(new ArrayList<Integer>());			
		}
		//Method call
		return minDifferenceHelper(teams, 0, numTeams, abilities);		
	}

	//helper method
	private int minDifferenceHelper(ArrayList<ArrayList<Integer>> teams, int peopleIndex,
			int numTeams, int[] abilities) 
	{
		//base case, successfully allocate each person, check the validity of the setup
		if ( peopleIndex == abilities.length)
		{
			if (noEmptyTeam(teams))
				return getMinDifference(teams);
			return Integer.MAX_VALUE;
		}	
		//recursive case, still have people remaining to be allocated
		else
		{
			int minDiff = Integer.MAX_VALUE;
		
			//for each available team 
			for ( int i = 0; i < numTeams; i++)
			{
				//add each person to the current team
				teams.get(i).add(abilities[peopleIndex]);
				
				int tmp = minDifferenceHelper(teams, peopleIndex+1, numTeams, abilities);
				//update the minimum possible difference
				if (tmp < minDiff )
				{
					minDiff = tmp;
				}
				//remove the person from the current team
				teams.get(i).remove(teams.get(i).size() -1);				
			}
			return minDiff;
		}
	}


	//calculate the minimum possible difference from an ArrayList
	private int getMinDifference(ArrayList<ArrayList<Integer>> teams) {
		// TODO Auto-generated method stub
		int maxTeam = calculateSum(teams.get(0));
		int minTeam = calculateSum(teams.get(0));

		for (ArrayList<Integer> intList : teams)
		{
			if(calculateSum(intList) > maxTeam)
				maxTeam = calculateSum(intList);
			if(calculateSum(intList) < minTeam)
				minTeam = calculateSum(intList);					
		}
		return Math.abs(maxTeam - minTeam);			
	}
	
	
	

	//check if the current ArrayList is empty 
	private boolean noEmptyTeam(ArrayList<ArrayList<Integer>> teams) {
		for (ArrayList<Integer> intList: teams)
			if(intList.size() == 0)
				return false;
		return true;
	}

	private int calculateSum(ArrayList<Integer> arrayList) {
		int sum = 0;
		for ( int i : arrayList)
			sum += i;
		return sum;
	}
}