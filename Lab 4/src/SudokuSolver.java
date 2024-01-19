import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/** This class solves sudoku puzzles, that are then compared to given solutions **/
public class SudokuSolver {
    private final Deque<SudokuMove> moves = new ArrayDeque<>();
    private static final Integer PUZZLE_SQUARE_LENGTH = 9;

    //solves a given sudoku puzzle
    public void solve(SudokuPuzzle myPuzzle) {
        for (int row = 0; row < PUZZLE_SQUARE_LENGTH; row++) { //for each row
            for (int column = 0; column < PUZZLE_SQUARE_LENGTH; column++) { //for each column in the row
                if (myPuzzle.getPuzzleValue(row, column) == 0) { //if the specified value box is empty
                    boolean noSolution = true; //assume there is no solution until proven otherwise
                    for (int i = 1; i <= PUZZLE_SQUARE_LENGTH; i++) { //try out each number in ascending order
                        if (myPuzzle.isValidMove(row, column, i) && noSolution) { //if the number is valid
                            myPuzzle.setPuzzleValue(row, column, i);
                            SudokuMove myMove = new SudokuMove(row, column, i);
                            moves.push(myMove);
                            noSolution = false; //there is a solution in this case
                        }
                    }
                    while (noSolution) { //if there wasn't a solution... keep doing this
                        SudokuMove lastMove = moves.pop(); //pop the last move
                        while (Objects.equals(lastMove.getInputNum(), PUZZLE_SQUARE_LENGTH)) {
                            //makes sure the move you're on still has possible answers
                            myPuzzle.setPuzzleValue(lastMove.getRow(), lastMove.getColumn(), 0);
                            lastMove = moves.pop();
                        }
                        myPuzzle.setPuzzleValue(lastMove.getRow(), lastMove.getColumn(), 0);
                        row = lastMove.getRow();
                        column = lastMove.getColumn();
                        for (int i = lastMove.getInputNum() + 1; i <= PUZZLE_SQUARE_LENGTH; i++) {
                            //checks to see if possible answers work
                            if (myPuzzle.isValidMove(row, column, i) && noSolution) {
                                myPuzzle.setPuzzleValue(row, column, i);
                                SudokuMove myMove = new SudokuMove(row, column, i);
                                moves.push(myMove);
                                noSolution = false;
                            }
                        }
                    }
                }
            }
        }
    }
}
