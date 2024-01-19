import java.util.Objects;

/** This class represents a sudoku puzzle that can be modified in order to obtain a solved version of itself **/
public class SudokuPuzzle {

    private final Integer[][] puzzleArray;
    private static final Integer PUZZLE_SQUARE_LENGTH = 9;


    public SudokuPuzzle(String puzzleString) {
        puzzleArray = new Integer[PUZZLE_SQUARE_LENGTH][PUZZLE_SQUARE_LENGTH];
        int counter = 0;
        for (int row = 0; row < PUZZLE_SQUARE_LENGTH; row++) {
            for (int column = 0; column < PUZZLE_SQUARE_LENGTH; column++) {
                puzzleArray[row][column] = Character.getNumericValue(puzzleString.charAt(counter));
                counter++;
            }
        }
    }

    //uses row and column coordinates to obtain the input number.
    public Integer getPuzzleValue(Integer row, Integer column) {
        return puzzleArray[row][column];
    }

    //sets a number onto a given square using row and column coordinates
    public void setPuzzleValue(Integer row, Integer column, Integer num) {
        puzzleArray[row][column] = num;
    }

    //returns a string representation of the current puzzle
    public String toString() {
        StringBuilder numBox = new StringBuilder();
        for (int row = 0; row < PUZZLE_SQUARE_LENGTH; row++) {
            for (int column = 0; column < PUZZLE_SQUARE_LENGTH; column++) {
                numBox.append(getPuzzleValue(row, column).toString()).append(" ");
            }
            numBox.append("\n");
        }
        return numBox.toString();
    }

    //checks if a number is allowed in a row
    public Boolean checkRow(Integer row, Integer num) {
        if (num < 1 || num > 9 || row < 0 || row >= PUZZLE_SQUARE_LENGTH) {
            return false;
        }
        for (int column = 0; column < PUZZLE_SQUARE_LENGTH; column++) {
            if (Objects.equals(getPuzzleValue(row, column), num)) {
                return false;
            }
        }
        return true;
    }

    //checks if a number is allowed in a column
    public Boolean checkColumn(Integer column, Integer num) {
        if (num < 1 || num > PUZZLE_SQUARE_LENGTH || column < 0 || column >= PUZZLE_SQUARE_LENGTH) {
            return false;
        }
        for (int row = 0; row < PUZZLE_SQUARE_LENGTH; row++) {
            if (Objects.equals(getPuzzleValue(row, column), num)) {
                return false;
            }
        }
        return true;
    }

    //checks if a number is allowed in a 3x3 box
    public Boolean checkBox(Integer row, Integer column, Integer num) {
        if (num < 1 || num > PUZZLE_SQUARE_LENGTH || row < 0 || row >= PUZZLE_SQUARE_LENGTH || column < 0 ||
        column >= PUZZLE_SQUARE_LENGTH) {
            return false;
        }
        row = row / 3;
        column = column / 3;
        if (row == 1) { row = 3; }
        else if (row == 2) { row = 6; }
        if (column == 1) { column = 3; }
        else if (column == 2) { column = 6; }
        for (int i = row; i < row + 3; i++) {
            for (int j = column; j < column + 3; j++) {
                if (Objects.equals(getPuzzleValue(i, j), num)) {
                    return false;
                }
            }
        }
        return true;
    }

    //checks if a move is valid given row and column coordinates and the desired move
    public boolean isValidMove(Integer row, Integer column, Integer num) {
        return checkRow(row,num) && checkColumn(column, num) && checkBox(row, column, num);
    }

    //checks if another SudokuPuzzle class is equal to the current one.
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SudokuPuzzle) {
            SudokuPuzzle myPuzzle = (SudokuPuzzle) obj;
            for (int row = 0; row < PUZZLE_SQUARE_LENGTH; row++) {
                for (int column = 0; column < PUZZLE_SQUARE_LENGTH; column++) {
                    if (!Objects.equals(getPuzzleValue(row, column), myPuzzle.getPuzzleValue(row, column))){
                            return false;
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
