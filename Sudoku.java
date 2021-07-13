package sudoko.game;
/**
 *
 * @Aneeqa
 */
//Main Class
public class SudokuGame {
        //n is the size of grid that n*n
       static int n=9;
       /*This method takes partially filled grid and then try to assign number
       un assigned locations in way that fulfill sudoko solution requirements also*/
        static boolean SudokuSolver(int grid[][],int Row ,int Col){
            /*if we have at the 8th row and 9th column
           we avoid further backtracking   */
           if(Row==n-1 && Col==n){
               return true;
           }
           // Check if column value  becomes 9,we move to next row
           //and column start from 0
           if (Col == n) {
            Row++;
            Col = 0;
        }
            //if the current position of the grid already
           //contains value >0, we iterate for next column
           if (grid[Row][Col] != 0)
            return SudokuSolver(grid, Row, Col + 1);
           for (int Num = 1; Num < 10; Num++) {
 
            // Check if it is correct to place the num (1-9)
            //in the given row ,col-->we move to next column
            if (isCorrect(grid, Row, Col,Num)) {
                /*Assigning the num in the current
                (row,col)  position of the grid and
                assuming our assigned num in the position
                is correct */
                grid[Row][Col] = Num;
                // Checking for next possibility with next column
                if (SudokuSolver(grid, Row, Col + 1))
                    return true;
            }
            /* Remove the number as our assumption was wrong
            and move to the next assumption
            */
            grid[Row][Col] = 0;
        }
        return false;
    }
 
    // function to print the grid of sudoku Game
    static void print(int[][] grid){
        System.out.println("'Sudoku  Game  Solver'");
        System.out.println("--------------------------");   
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                System.out.print(grid[i][j] + "  ");
            }
            System.out.println("");
        }
        System.out.println("--------------------------");
    }
 
    // Check is it legal to assign number to the given row and column
    static boolean isCorrect(int[][] grid, int Row, int Col,
                          int num)
    {
 
        // if we find the same num in the similar row,we return false
        for (int x = 0; x <= n-1; x++)
            if (grid[Row][x] == num)
                return false;
 
        // Check if we find the same num in the similar col,we return false
        for (int x = 0; x <= n-1; x++)
        {
            if (grid[x][Col] == num){
              return false;
            }
        }
 
        /* Check if we find the same num in the particular 3*3
        matrix, we return false*/
        int startRow = Row - Row % 3, startCol
                                      = Col - Col % 3;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (grid[i + startRow][j + startCol] == num){
                    return false;
                }
            }
        return true;
    }
           return false;
    }
}
package sudoko.game;
import static sudoko.game.SudokuGame.SudokuSolver;
import static sudoko.game.SudokuGame.print;
/**
 *
 * @Aneeqa
 */
//Driver Class
public class SudokuTest {
    // Driver Code
    public static void main(String[] args)
    {
        int grid[][] = { { 0, 0, 0, 2, 6, 0, 7, 0, 1 },
                         { 6, 8, 0, 0, 7, 0, 0, 9, 0 },
                         { 1, 9, 0, 0, 0, 4, 5, 0, 0 },
                         { 8, 2, 0, 1, 0, 0, 0, 4, 0 },
                         { 0, 0, 4, 6, 0, 2, 9, 0, 0 },
                         { 0, 5, 0, 0, 0, 3, 0, 2, 8 },
                         { 0, 0, 9, 3, 0, 0, 0, 7, 4 },
                         { 0, 4, 0, 0, 5, 0, 0, 3, 6 },
                         { 7, 0, 3, 0, 1, 8, 0, 0, 0 } 
        };
 
        if (SudokuSolver(grid, 0, 0)){
            print(grid);
        }
        else{
            System.out.println("Sorry! No Solution ");
        }
    }
    // Reference use in this code:https://www.geeksforgeeks.org/sudoku-backtracking-7//
}




