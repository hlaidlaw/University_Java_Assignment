package uk.ac.aber.cs21120.solution;

import uk.ac.aber.cs21120.interfaces.IGrid;
import java.util.Arrays;

public class Grid implements IGrid
{
    private final int[][] sudokuGrid;

    /**
     * Constructor for grid class
     */
    public Grid()
    {
        this.sudokuGrid = new int[9][9];
    }

    /**
     * Returns value of the cell at x,y in the grid as an integer from 1-9, or 0 if the cell is empty.
     *
     * @param x - first value
     * @param y - second value
     * @throws IGrid.BadCellException  - If x or y are out of range
     * @return sudokuGridValue - int value 1-9 or 0 if empty
     */

    @Override
    public int get(int x, int y) throws IGrid.BadCellException
    {
        if (x >= 9 || x <= -1 || y >= 9 || y <= -1)
        {
            throw new IGrid.BadCellException(x, y);
        }
        else
        {
            return sudokuGrid[x][y];
        }

    }

    /**
     * Sets cell at x,y in the grid to an integer from 1-9, or 0 for empty.
     *
     * @param x     - x Axis
     * @param y     - y Axis
     * @param digit - Integer from 1-9
     * @throws IGrid.BadCellException  - If x or y are out of range
     * @throws IGrid.BadDigitException - If the value itself is not in the range 0-9,
     */

    @Override
    public void set(int x, int y, int digit) throws IGrid.BadCellException, IGrid.BadDigitException
    {
        if (x >= 9 || x < 0 || y >= 9 || y < 0)
        {
            throw new IGrid.BadCellException(x, y);
        }
        else if (digit > 9 || digit < 0)
        {
            throw new IGrid.BadDigitException(digit);
        }
        else
        {
            sudokuGrid[x][y] = digit;
        }
    }

    /**
     * Return true if the grid is valid. This means that all non-empty cells meet the following conditions:
     * 1) each digit appears only once in each row
     * 2) each digit appears only once in each column
     * 3) each digit appears only once in each 3x3 subgrid
     * Note that empty cells are not counted.
     *
     * @return true if the grid is valid or false if not
     */

    @Override
    public boolean isValid()
    {
        if (isValidRows())
        {
            if (isValidColumns())
            {
                return isValidSubGrids();
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }


    /**
     * Function to check if the rows are valid
     * @return true if the grid is valid or false if not
     */
    public boolean isValidRows()
    {
        for (int xAxis = 0; xAxis < 9; xAxis++)
        {
            Boolean[] arrayOfBool = new Boolean[9];
            Arrays.fill(arrayOfBool, Boolean.FALSE);
            for (int yAxis = 0; yAxis < 9; yAxis++)
            {
                if (get(xAxis, yAxis) != 0)
                {
                    int valueToBeChecked = get(xAxis, yAxis);
                    if (arrayOfBool[valueToBeChecked - 1])
                    {
                        return false;
                    }
                    else
                    {
                        arrayOfBool[valueToBeChecked - 1] = true;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Function to check if the columns are valid
     * @return true if the grid is valid or false if not
     */
    public boolean isValidColumns()
    {
        for (int yAxis = 0; yAxis < 9; yAxis++)
        {
            Boolean[] arrayOfBool = new Boolean[9];
            Arrays.fill(arrayOfBool, Boolean.FALSE);

            for (int xAxis = 0; xAxis < 9; xAxis++)
            {
                if (get(xAxis, yAxis) != 0)
                {
                    int valueToBeChecked = get(xAxis, yAxis);
                    if (arrayOfBool[valueToBeChecked - 1])
                    {
                        return false;
                    }
                    else
                    {
                        arrayOfBool[valueToBeChecked - 1] = true;
                    }
                }
            }
        }
        return true;
    }


    /**
     * Function to check if the sub-grids are valid
     * @return true if the grid is valid or false if not
     */
    public boolean isValidSubGrids()
    {
        for (int beginningValesForX = 0; beginningValesForX < 3; beginningValesForX++)
        {
            for (int beginningValesForY = 0; beginningValesForY < 3; beginningValesForY++)
            {
                Boolean[] arrayOfBool = new Boolean[10];
                Arrays.fill(arrayOfBool, Boolean.FALSE);

                for (int limitForX = 0; limitForX < 3; limitForX++)
                {
                    for (int limitForY = 0; limitForY < 3; limitForY++)
                    {
                        int first = beginningValesForX * 3 + limitForX;
                        int second = beginningValesForY * 3 + limitForY;

                        if (get(first, second) != 0)
                        {
                            if (arrayOfBool[(get(first, second)) - 1])
                            {
                                return false;
                            }
                            else
                            {
                                arrayOfBool[(get(first, second)) - 1] = true;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     *Formats the grid to be printed
     * @return Grid in correct format
     */
    public String toString()
    {
        StringBuilder b = new StringBuilder();
        for (int y = 0; y < 9; y++)
        {
            for (int x = 0; x < 9; x++)
            {
                b.append(get(x, y));
            }
            b.append('\n');
        }
        return b.toString();
    }
}