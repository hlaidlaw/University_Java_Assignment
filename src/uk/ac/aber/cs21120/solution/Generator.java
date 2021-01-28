package uk.ac.aber.cs21120.solution;

import java.util.Scanner;
import uk.ac.aber.cs21120.interfaces.IGrid;

/**
 *  Generator Class
 *  Generates the puzzles and prints the menu
 *  @author Hannah Laidlaw
 *  @version 1.0
 */

public class Generator
{

    private final Grid grid;
    String response;
    int amountOfNumbersToEnter;
    Grid sudokuGrid = new Grid();
    int[] numberArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    Main main = new Main();


    /**
     * Constructor for Generator class
     * @param grid - A member variable
     */
    public Generator(IGrid grid)
    {
        this.grid = (Grid) grid;
    }

    
    /**
     * Generates a random number (integer) between a limit set by the parameters
     * @param min - minimum of the limit
     * @param max - maximum of the limit
     * @return - random number
     */
    public int generateRandomNumber(int min, int max)
    {
        return ((int) ((Math.random() * ((max - min) + 1)) + min));
    }


    /**
     * Generates the grid ensuring it is valid
     * @param amountOfNumbersToEnter - amount of Numbers set earlier by the user to
     *      have in the grid (how difficulty is chosen), in this version this is the
     *      number of empty gaps needed in the grid
     * @return - true if grid has worked
     */
    public boolean makeAndTest(int amountOfNumbersToEnter)
    {
        sudokuGrid = new Grid();
        Solver solver;
        do
        {
            sudokuGrid = new Grid();
            solver = new Solver(sudokuGrid);
            int index;
            int variable = 0;
            int xAxis = 0;
            numberArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
            do
            {
                index = generateRandomNumber(0, 8);

                if (numberArray[index] != 0)
                {
                    int digit = numberArray[index];
                    numberArray[index] = 0;
                    sudokuGrid.set(xAxis, 0, digit);
                    variable++;
                    xAxis++;
                }
            } while (variable != 9);

            int yAxis = 0;
            variable = 0;
            numberArray = new int[]{1,2, 3, 4, 5, 6, 7, 8, 9};
            do
            {
                index = generateRandomNumber(0, 8);

                if (numberArray[index] != 0)
                {
                    int digit = numberArray[index];
                    numberArray[index] = 0;
                    sudokuGrid.set(0, yAxis, digit);
                    variable++;
                    yAxis++;
                }
            } while (variable != 9);
        } while (!solver.solve());
        int yAxis;
        int xAxis;
        int i = 0;
        do
        {
            do
            {
                xAxis = generateRandomNumber(0, 8);
                yAxis = generateRandomNumber(0, 8);

                if (sudokuGrid.get(xAxis, yAxis) != 0)
                {
                    sudokuGrid.set(xAxis, yAxis, 0);
                    i++;
                }
            } while ((sudokuGrid.get(xAxis, yAxis) != 0));
        } while (i < amountOfNumbersToEnter);
        return true;
    }

    /**
     * Prints menu for user to choose the option they want to do
     */
    public void createPuzzleFromScratch()
    {
        do
        {
            System.out.println("\n Please choose what you would like");
            System.out.println("1 - Easy Level");
            System.out.println("2 - Medium Level");
            System.out.println("3 - Hard Level ");
            System.out.println("4 - Custom (Enter the amount of filled spaces you would like later)");
            System.out.println("5 - Solve the examples class tests ");
            System.out.println("Q - Quit");
            System.out.println("Pick an option: ");
            Scanner scan = new Scanner(System.in);
            response = scan.nextLine().toUpperCase();
            switch (response)
            {
                case "1":
                    System.out.println("You have chosen Easy Level");
                    amountOfNumbersToEnter = 66;
                    generateTheGrid();
                    break;

                case "2":
                    System.out.println("You have chosen Medium Level");
                    amountOfNumbersToEnter = 56;
                    generateTheGrid();
                    break;

                case "3":
                    System.out.println("You have chosen Hard Level");
                    amountOfNumbersToEnter = 46;
                    generateTheGrid();
                    break;

                case "4":
                    System.out.println("You have chosen custom Level");
                    System.out.println("Please enter the amount of filled spaces you would like");
                    int amount = scan.nextInt();
                    amountOfNumbersToEnter = 81 - amount;
                    generateTheGrid();
                    break;

                case "5":
                    System.out.println("You have chosen to solve the Examples class tests");
                    main.solveExamplesTests();
                    break;

                case "Q":
                    System.exit(0);

                default:
                    System.out.println("Try again");
            }

        } while (!(response.equals("Q")));
    }

    /**
     * Repeats the  makeAndTest function above to make
     *      the grid until the grid is valid
     */

    public void generateTheGrid()
    {
        do
        {
            sudokuGrid = new Grid();
            makeAndTest(amountOfNumbersToEnter);
        }
        while (!makeAndTest(amountOfNumbersToEnter));
        System.out.println(sudokuGrid.toString());
    }

}
