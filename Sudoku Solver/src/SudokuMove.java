/** this class represents moves on a sudoku puzzle, that are kept track of by SudokuSolver **/
public class SudokuMove {

    private final Integer row;
    private final Integer column;
    private final Integer num;

    public SudokuMove(Integer row, Integer column, Integer num) {
        this.row = row;
        this.column = column;
        this.num = num;
    }

    //obtains the row value of a move
    public Integer getRow() {
        return row;
    }

    //obtains the column value of a move
    public Integer getColumn() {
        return column;
    }

    //obtains the input value of a move
    public Integer getInputNum() {
        return num;
    }
}
