package uk.ac.aber.cs21120.solution;

import uk.ac.aber.cs21120.interfaces.IGrid;
import uk.ac.aber.cs21120.tests.Examples;

/**
 * Main Class
 *  Runs the code, has the function to solve the examples test
 *  @author Hannah Laidlaw
 *  @version 1.0
 */
public class Main
{

    /**
     * Runs the tests in examples, printing as it goes:
     *      *      the number of the test
     *      *      the time taken in milliseconds
     *      *      how many gaps the puzzle has
     * Once all puzzles are complete, prints total time taken in milliseconds
     */
    public void solveExamplesTests()
    {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 400; i++)
        {
            long start2 = System.nanoTime();
            Solver solver = new Solver(Examples.getExample(i));
            solver.solve();
            long timeTaken2 = System.nanoTime() - start2;
            System.out.println(i + " Complete. It took " + (timeTaken2/1e6) + " ms " + "and has "
                    + Examples.getGapCount(i) + " gaps");
        }
        long timeTaken = System.currentTimeMillis() - start;
        System.out.println("Total Time : " + timeTaken + "ms");
    }


    /**
     * Main function that runs the code
     * @param args - puzzle
     */

    public static void main(String[] args)
    {
        IGrid generatedGrid = new Grid();
        Generator generator = new Generator(generatedGrid);
        generator.createPuzzleFromScratch();
    }
}