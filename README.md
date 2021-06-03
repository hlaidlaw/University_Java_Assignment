# University_Java_Assignment
An assignment that was submitted for a second-year university module named "Algorithm Design and Data Structures". The project was coded in Java and achieved a first.

The brief was to solve a 9 by 9 sudoku. The code should pass all of the test provided (found in the tests folder) which are all solving pre generated grids. The program should also generate solvable sudokus for the user to solve, difficulty depending on the users choice.

-------------------What the project contains----------------------------------------------

This project is split into 3 folders, 3 interface files and 7 Java files
Their should be:
  
  interfaces folder which contains :
             
             IGrid interface and ISolver interface, these were both provided by the university.
             
  
  solution folder which contains :
  
             Generatator.java - Java class that generates the puzzles and prints the menu
             
             Grid.java - Java class that contains functions to generate the grid and checking if the grid is valid
             
             Main.java - Java class that runs the code, has the function to solve the examples test
             
             Solver.java - Java class that attempts to solve the grid
             
             
  tests folder which contains :
  
             Examples class, GridTests class and SolverTests class. These were all provided by the university.
                        
 

-------------------What you need to run the project---------------------------------------

Nothing more is needed than the files provided.

-------------------Expected Output--------------------------------------------------------

The user is prompted to choose an option from the menu:

Please choose what you would like
1 - Easy Level
2 - Medium Level
3 - Hard Level 
4 - Custom (Enter the amount of filled spaces you would like later)
5 - Solve the examples class tests 
Q - Quit
Pick an option: 

If the user enters any option other than 1-5 or Q Try again and the menu will be printed.

If 1 is entered 

      - "You have chosen Easy Level" is printed and a sudoku is printed
      - This sudoku has 15 numbers filled in and 66 gaps such as
      
      004005000
      100060070
      007000000
      000020700
      000000000
      000504000
      040050960
      000000000
      700000000
      
      - The menu is then printed again
      
If 2 is entered 

      - "You have chosen Medium Level" is printed and a sudoku is printed
      - This sudoku has 25 numbers filled in and 56 gaps such as
      
      000007039
      012300000
      000000100
      300450000
      004008306
      609700000
      060070000
      000000760
      178060000
      
      - The menu is then printed again      
     
If 3 is entered 

      - "You have chosen Hard Level" is printed and a sudoku is printed
      - This sudoku has 35 numbers filled in and 46 gaps such as
      
      381062400
      500030209
      270050000
      000375600
      060009500
      800004000
      900000000
      058723901
      004890702
      
      - The menu is then printed again    
      
If 4 is entered

      - "You have chosen custom level" is printed
      - "Please enter the amount of filled spaces you would like"
      - The user is then prompted to enter a number
      - A grid is generated with the same amount of number as the user entered 
      
      such as user enters 9
      
      000000000
      000000300
      000000050
      000000080
      000800000
      000000003
      030600000
      000100000
      006000000
      
If Q is entered

      - The program is exited
      
-------------------Where to find the comments in the code---------------------------------

The majority of the comments in this code are found before the function definition in the Java files.
There is also a comment at the top of each class describing the class.
