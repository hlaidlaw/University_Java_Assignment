package uk.ac.aber.cs21120.solution;

import uk.ac.aber.cs21120.interfaces.IGrid;
import uk.ac.aber.cs21120.interfaces.ISolver;

/**
 * Solver Class
 *  Attempts to solve the grid
 *  @author Hannah Laidlaw
 *  @version 1.0
 */
public class Solver implements ISolver
{

    private final Grid grid;

    /**
     * Constructor for class Solver
     *
     * @param g - a member variable that has grid in, solve modifies this as it runs
     */
    public Solver(IGrid g)
    {
        this.grid = (Grid) g;
    }


    /**
     * Attempts to solve the grid passed into the constructor.
     * Will modify the grid as it does so, and will call itself recursively to solve simpler versions
     * of the grid.
     *
     * @return true if grid succeeds / false if grid cannot be solved - solver must backtrack
     */
    public boolean solve()
    {
        for (int yAxis = 0; yAxis < 9; yAxis++)
        {
            for (int xAxis = 0; xAxis < 9; xAxis++)
            {
                if (grid.get(xAxis, yAxis) == 0)
                {
                    for (int digit = 1; digit < 10; digit++)
                    {
                        grid.set(xAxis, yAxis, digit);
                        if (grid.isValid())
                        {
                            boolean result = solve();
                            if (result)
                            {
                                return true;
                            }
                        }
                    }
                    grid.set(xAxis, yAxis, 0);
                    return false;
                }
            }
        }
        return true;
    }
}
