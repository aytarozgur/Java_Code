import java.util.ArrayList;
import java.util.Collections;


public class tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		    Recursive r = new Recursive();
		    
	        //Test 1 - 3 Binary method
		    //Test 1, getBinary method
		    String actualBinary = r.getBinary(19);
	        String expectedBinary = "10011";
	        if( actualBinary.equals(expectedBinary) )
	            System.out.println( "Test 1 passed. get binary.");
	        else
	            System.out.println( "Test 1 failed. get binary. expected: " + expectedBinary + ", actual: " + actualBinary);
	        //Test2, getBinary method
	        actualBinary = r.getBinary(1);
	        expectedBinary = "1";
	        if( actualBinary.equals(expectedBinary) )
	            System.out.println( "Test 2 passed. get binary.");
	        else
	            System.out.println( "Test 2 failed. get binary. expected: " + expectedBinary + ", actual: " + actualBinary);
	       
	        //Test3, getBinary method
	        actualBinary = r.getBinary(25);
	        expectedBinary = "11001";
	        if( actualBinary.equals(expectedBinary) )
	            System.out.println( "Test 3 passed. get binary.");
	        else
	            System.out.println( "Test 3 failed. get binary. expected: " + expectedBinary + ", actual: " + actualBinary);


	        
	        //Test 4 - 6, String Reverse method
	        
	        //Test 4, String reverse method
	        String actualRev = r.revString("Mike Scott is legit!");
	        String expectedRev = "!tigel si ttocS ekiM";
	        if( actualRev.equals(expectedRev) )
	            System.out.println( "Test 4 passed. reverse string.");
	        else
	            System.out.println( "Test 4 failed. reverse string. expected: " + expectedRev + ", actual: " + actualRev);

	        //Test 5, String reverse method
	        actualRev = r.revString("Hook'em Horn");
	        expectedRev = "nroH me'kooH";
	        if( actualRev.equals(expectedRev) )
	            System.out.println( "Test 5 passed. reverse string.");
	        else
	            System.out.println( "Test 5 failed. reverse string. expected: " + expectedRev + ", actual: " + actualRev);

	        //Test, 6, String reverse method
	        actualRev = r.revString("1234567890");
	        expectedRev = "0987654321";
	        if( actualRev.equals(expectedRev) )
	            System.out.println( "Test 6 passed. reverse string.");
	        else
	            System.out.println( "Test 6 failed. reverse string. expected: " + expectedRev + ", actual: " + actualRev);

	        
	        
	        
	        //Test 7 - 9 Next Is Double method
	        
	        //Test 7, Next is Double method
	        int[] numsForDouble = {4, 8, 16, 1, 2, 4, 3, 6, 12};
	        int actualDouble = r.nextIsDouble(numsForDouble);
	        int expectedDouble = 6;
	        if(actualDouble == expectedDouble)
	            System.out.println( "Test 7 passed. next is double.");
	        else
	            System.out.println( "Test 7 failed. next is double. expected: " + expectedDouble + ", actual: " + actualDouble);

	        //Test 8, Next is Double method
	        numsForDouble = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 2};
	        actualDouble = r.nextIsDouble(numsForDouble);
	        expectedDouble = 1;
	        if(actualDouble == expectedDouble)
	            System.out.println( "Test 8 passed. next is double.");
	        else
	            System.out.println( "Test 8 failed. next is double. expected: " + expectedDouble + ", actual: " + actualDouble);

	        //Test 9, Next is Double method
	        numsForDouble = new int[]{0, 0, 0, 12, 24, 0, 64, 128, 30, 60, 0};
	        actualDouble = r.nextIsDouble(numsForDouble);
	        expectedDouble = 5;
	        if(actualDouble == expectedDouble)
	            System.out.println( "Test 9 passed. next is double.");
	        else
	            System.out.println( "Test 9 failed. next is double. expected: " + expectedDouble + ", actual: " + actualDouble);

	        
	        //Test 10 - 12 Phone Mnemonics  methods

	        //Test 10, Phone Mnemonics  method
	        ArrayList<String> mnemonics = r.listMnemonics("0");
	        ArrayList<String> expected = new ArrayList<String>();
	        expected.add("0");
	        if( mnemonics.equals(expected))
	            System.out.println( "Test 10 passed. Phone mnemonics.");
	        else
	            System.out.println( "Test 10 failed. Phone mnemonics.");
	        
	        
	        //Test 11, Phone Mnemonics  method 
	        mnemonics = r.listMnemonics("22");
	        Collections.sort(mnemonics);
	        expected.clear();
	        expected.add("AA");
	        expected.add("AB");
	        expected.add("AC");
	        expected.add("BA");
	        expected.add("BB");
	        expected.add("BC");
	        expected.add("CA");
	        expected.add("CB");
	        expected.add("CC");
	        Collections.sort(expected);
	        if( mnemonics.equals(expected))
	            System.out.println( "Test 11 passed. Phone mnemonics.");
	        else
	            System.out.println( "Test 11 failed. Phone mnemonics.");

	        //Test 12, Phone Mnemonics  method
	        mnemonics = r.listMnemonics("000000");
	        expected.clear();
	        expected.add("000000");
	        if( mnemonics.equals(expected))
	            System.out.println( "Test 12 passed. Phone mnemonics.");
	        else
	            System.out.println( "Test 12 failed. Phone mnemonics.");
	        
	        

            
	        //Test 13 - 15 Sudoku methods
	        
	        //Test 13, Sudoku method
            String puzzle1 = 
            		"530070000" +
            		"600195000" +
            		"098000060" +
            		"800060003" +
            		"400803001" +
            		"700020006" +
            		"060000280" +
            		"000419005" +
            		"000080079";
            int[][] board = stringToBoard(puzzle1);
            int[][] result = r.getSudokoSolution(board);
            String actualBoard = boardToString(result);
            String expectedBoard = 
            		"534678912" +
            		"672195348" +
            		"198342567" +
            		"859761423" +
            		"426853791" +
            		"713924856" +
            		"961537284" +
            		"287419635" +
            		"345286179";
            if(actualBoard.equals(expectedBoard))
                System.out.println( "Test 13 passed. sudoko solver.");
            else {
                System.out.println("Test 13 failed. sudoku solver:");
                System.out.println("Expected board:");
                printBoard(stringToBoard(expectedBoard));
                System.out.println();
                System.out.println("Actual board:");
                printBoard(result);
            }

            
            //Test 14, Sudoku method
            String puzzle2 = "370002060000000050008073900147000000009301200000000891005120600010000000080600043";
            board = stringToBoard(puzzle2);
            result = r.getSudokoSolution(board);
            actualBoard = boardToString(result);
            expectedBoard = "371592468294816357568473912147289536859361274623745891735124689416938725982657143";
            if(actualBoard.equals(expectedBoard))
                System.out.println( "Test 14 passed. sudoko solver.");
            else {
                System.out.println("Test 14 failed. sudoku solver:");
                System.out.println("Expected board:");
                printBoard(stringToBoard(expectedBoard));
                System.out.println();
                System.out.println("Actual board:");
                printBoard(result);
            }

            //Test 15, Sudoku method
            String puzzle3 = "000010300008003500500002001003000007106070403400000200200300004004900600007080000";
            assert puzzle3.length() == 81;
            board = stringToBoard(puzzle3);
            result = r.getSudokoSolution(board);
            actualBoard = boardToString(result);
            expectedBoard = "642715389718493526539862741823546917196278453475139268261357894384921675957684132";
            if(actualBoard.equals(expectedBoard))
                System.out.println( "Test 15 passed. sudoko solver.");
            else {
                System.out.println("Test 15 failed. sudoku solver:");
                System.out.println("Expected board:");
                printBoard(stringToBoard(expectedBoard));
                System.out.println();
                System.out.println("Actual board:");
                printBoard(result);
            }
            
            //Tests 16 - 18 Water flowing off a map methods
            System.out.println("Testing water off flow");
            int[][] world = {
            		{5,5,5,5,5,5},
                    {5,5,5,5,5,5},
                    {5,5,5,5,5,5},
                    {5,5,5,5,5,5},
                    {5,5,5,5,5,5},
                    {5,5,5,5,5,5},
                    {5,5,5,5,5,5},
                    {5,5,5,5,5,5}};
            
            int[][] world2 = {
            		{1,5,1,5,5,5},
                    {5,2,2,5,5,5},
                    {5,5,3,5,5,5},
                    {5,5,4,5,5,5},
                    {5,5,5,5,5,5},
                    {5,5,5,5,5,5},
                    {5,5,5,5,5,5},
                    {5,5,5,5,5,5}};
            
            

            if( r.canFlowOffMap(world,0,5))
                System.out.println( "Test 16 passed. can flow off map.");
            else
                System.out.println( "Test 16 failed. can flow off map.");
            
            if( r.canFlowOffMap(world,5,5))
                System.out.println( "Test 17 passed. can flow off map.");
            else
                System.out.println( "Test 17 failed. can flow off map.");

            if( r.canFlowOffMap(world2,4,2))
                System.out.println( "Test 18 passed. can flow off map.");
            else
                System.out.println( "Test 18 failed. can flow off map.");
            
            
            
            //Test 19 - 21 Fair Team methods
            
            //Test 19 Fair Team method
            int[] abilities = {1, 2, 3, 4, 5, 6, 7};
            System.out.println(r.minDifference(3, abilities));
            if(r.minDifference(3, abilities) == 1)
                System.out.println( "Test 17 passed. min difference.");
            else
                System.out.println( "Test 17 failed. min difference.");

            //Test 20 Fair Team method
            abilities = new int[]{10, 10, 6, 6, 6};
            if(r.minDifference(2, abilities) == 2)
                System.out.println( "Test 21 passed. min difference.");
            else
                System.out.println( "Test 21 failed. min difference.");
            
            //Test 21 Fair Team method;
            
            
            
            
            
            

           

	}
	
	private static int[][] stringToBoard(String puzzle) {
        int[][] result = new int[Recursive.BOARD_SIZE][Recursive.BOARD_SIZE];
        int index = 0;
        for(int r = 0; r < result.length; r++)
            for(int c = 0; c < result.length; c++, index++)
                result[r][c] = puzzle.charAt(index) - '0';
        return result;
    }
	
	
	 private static void printBoard(int[][] board) {
         for(int r = 0; r < board.length; r++) {
             for(int c = 0; c < board[r].length; c++) {
                 System.out.print(board[r][c]);
                 System.out.print(" ");
             }
             System.out.println();
         }
     }
     
	 

     private static String boardToString(int[][] board) {
         StringBuilder result = new StringBuilder(81);
         for(int r = 0; r < board.length; r++)
             for(int c = 0; c < board[r].length; c++)
                 result.append(board[r][c]);
         return result.toString();
     }
     
     

}
