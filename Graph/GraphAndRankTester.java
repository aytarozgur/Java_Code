/*  Student information for assignment:
 *
 *  On my honor, Anna Mengjie YU, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: my3852
 *  email address: annayu2010@gmail.com
 *  Grader name: Eric
 *  Number of slip days I am using: 0
 */

/*
 * Question. The assignment presents three ways to rank teams using graphs.
 * The results, especially for the last two methods are reasonable. 
 * However if all results from all college football teams are included 
 * some unexpected results occur. 
 * 
 * Suggest another way of method of ranking teams using the results 
 * from the graph. Thoroughly explain your method. The method can build 
 * on one of the three existing algorithms.
 * 
 * Method: add method 1 and method 2, and calculate the average.
 */

public class GraphAndRankTester {
    
    public static void main(String[] args)  {
        System.out.println();
        testGraph();
        
        String actual = "2008ap_poll.txt";
        String gameResults = "div12008.txt";
        
        FootballRanker ranker = new FootballRanker(gameResults, actual);
        
        ranker.doUnweighted(true);
        ranker.doWeighted(true);
        ranker.doWeightedAndWinPercentAdjusted(true);
        // TODO
        // ranker.doWeightedWinPercentAdjustedAndOpponents(true);
        
        System.out.println();
        doRankTests(ranker);
        
        System.out.println();
        testGraph();
    }
    
    public static void doRankTests(FootballRanker ranker) {
        double actualError = ranker.doUnweighted(false);
        if(actualError == 13.7)
            System.out.println("Passed unweighted test");
        else
            System.out.println("FAILED UNWEIGHTED ROOT MEAN SQUARE ERROR TEST. Expected 13.7, actual: " + actualError);
        
        actualError = ranker.doWeighted(false);
        if(actualError == 12.6)
            System.out.println("Passed weigthed test");
        else
            System.out.println("FAILED WEIGHTED ROOT MEAN SQUARE ERROR TEST. Expected 12.6, actual: " + actualError);
        
        
        actualError = ranker.doWeightedAndWinPercentAdjusted(false);
        if(actualError == 6.3)
            System.out.println("Passed unweighted win percent test");
        else
            System.out.println("FAILED WEIGHTED  AND WIN PERCENT ROOT MEAN SQUARE ERROR TEST. Expected 6.3, actual: " + actualError);       
    }
    
    public static void testGraph() {
        String [][] edges = 
               {{"A", "B", "1"},
                {"B", "C", "3"},
                {"B", "D", "12"},
                {"C", "F", "3"},
                {"A", "G", "7"},
                {"D", "F", "4"},
                {"D", "G", "5"},
                {"D", "E", "6"}};
        
        Graph g = new Graph();
        for(String[] edge : edges) {
            g.addEdge(edge[0], edge[1], Integer.parseInt(edge[2]));
            g.addEdge(edge[1], edge[0], Integer.parseInt(edge[2]));
        }
        
        g.dijkstra("A");
        String actualPath = g.findPath("E").toString();
        String expected = "[A, B, C, F, D, E]";
        if(actualPath.equals(expected))
            System.out.println("Passed dijkstra path test.");
        else
            System.out.println("Failed dijkstra path test. Expected: " + expected + " actual " + actualPath);  
        
        // find all paths using unweighted edges
        g.findAllPaths(false);
        int actualDiameter = g.getDiameter();
        if(actualDiameter == 3)
            System.out.println("Passed diameter test with weighted == false.");
        else
            System.out.println("Failed diameter test with weighted == false. Expected 3 got " + actualDiameter);
        
        double costOfLongestShortestPath = g.costOfLongestShortestPath();
        if(costOfLongestShortestPath == 3.0)
            System.out.println("Passed cost of longest shortest path test with weighted == false.");
        else
            System.out.println("Failed cost of longest shortest path test with weighted == false. Expected 3.0 got " + actualDiameter);
        
        System.out.println();
        
        String[] expectedPaths = {  "Name: D                    cost per path: 1.3333, num paths: 6",
                                    "Name: B                    cost per path: 1.5000, num paths: 6",
                                    "Name: F                    cost per path: 1.8333, num paths: 6",
                                    "Name: G                    cost per path: 1.8333, num paths: 6",
                                    "Name: A                    cost per path: 2.0000, num paths: 6",
                                    "Name: C                    cost per path: 2.0000, num paths: 6",
                                    "Name: E                    cost per path: 2.1667, num paths: 6"};
        
        testAllPathsInfo(g, expectedPaths);
        
        // find all paths using weighted edges
        g.findAllPaths(true);
        actualDiameter = g.getDiameter();
        if(actualDiameter == 5)
            System.out.println("Passed diameter test with weighted == true.");
        else
            System.out.println("Failed diameter test with weighted == true. Expected 5 got " + actualDiameter);
             
        costOfLongestShortestPath = g.costOfLongestShortestPath();
        if(costOfLongestShortestPath == 17.0)
            System.out.println("Passed cost of longest shortest path test with weighted = true");
        else
            System.out.println("Failed cost of longest shortest path test with weighted = true. Expected 17.0 got " + actualDiameter);
        
        
        expectedPaths = new String[] {  "Name: F                    cost per path: 6.5000, num paths: 6",
                                        "Name: C                    cost per path: 6.8333, num paths: 6",
                                        "Name: D                    cost per path: 7.1667, num paths: 6",
                                        "Name: B                    cost per path: 7.3333, num paths: 6",
                                        "Name: A                    cost per path: 7.8333, num paths: 6",
                                        "Name: G                    cost per path: 8.5000, num paths: 6",
                                        "Name: E                    cost per path: 12.1667, num paths: 6"};
        testAllPathsInfo(g, expectedPaths);
        
        testUnconnectedGraph();
    }
    
    // Test an unconnected graph.
    private static void testUnconnectedGraph() {
        String [][] edges = 
        {{"A", "B", "13"},
         {"A", "C", "10"},
         {"A", "D", "2"},
         {"B", "E", "5"},
         {"C", "B", "1"},
         {"D", "C", "5"},
         {"E", "G", "1"},
         {"E", "F", "4"},
         {"F", "C", "3"},
         {"F", "E", "2"},
         {"G", "F", "2"},
         {"H", "I", "10"},
         {"H", "J", "5"},
         {"H", "K", "22"},
         {"I", "K", "3"},
         {"I", "J", "1"},
         {"J", "L", "8"}};
        
        
        Graph g = new Graph();
        for(String[] edge : edges) {
            g.addEdge(edge[0], edge[1], Integer.parseInt(edge[2]));
        }
        
        // find all paths using weighted edges
        g.findAllPaths(true);
        int actualDiameter = g.getDiameter();
        if(actualDiameter == 6)
            System.out.println("Passed diameter test with weighted == true.");
        else
            System.out.println("Failed diameter test with weighted == true. Expected 5 got " + actualDiameter);
             
        double costOfLongestShortestPath = g.costOfLongestShortestPath();
        if(costOfLongestShortestPath == 16.0)
            System.out.println("Passed cost of longest shortest path test with weighted = true");
        else
            System.out.println("Failed cost of longest shortest path test with weighted = true. Expected 17.0 got " + actualDiameter);
        
        
        String[] expectedPaths 
                      = {"Name: A                    cost per path: 10.0000, num paths: 6",
                         "Name: D                    cost per path: 9.6000, num paths: 5",
                         "Name: F                    cost per path: 3.0000, num paths: 4",
                         "Name: E                    cost per path: 4.2500, num paths: 4",
                         "Name: G                    cost per path: 4.2500, num paths: 4",
                         "Name: C                    cost per path: 5.7500, num paths: 4",
                         "Name: B                    cost per path: 7.5000, num paths: 4",
                         "Name: H                    cost per path: 10.2500, num paths: 4",
                         "Name: I                    cost per path: 4.3333, num paths: 3",
                         "Name: J                    cost per path: 8.0000, num paths: 1"};

        testAllPathsInfo(g, expectedPaths);
    }

    
    private static void testAllPathsInfo(Graph g, String[] expectedPaths) {
        int index = 0;
        
        for(AllPathsInfo api : g.getAllPaths()) {
            if(expectedPaths[index].equals(api.toString())) {
                System.out.println(expectedPaths[index] + " is correct!!");
            }
            else {
                System.out.println("ERROR IN ALL PATHS INFO: ");
                System.out.println("index: " + index);
                System.out.println("EXPECTED: " + expectedPaths[index]);
                System.out.println("ACTUAL: " + api.toString());
                System.out.println();
            }
            index++;
        }
        System.out.println();
    }
}
