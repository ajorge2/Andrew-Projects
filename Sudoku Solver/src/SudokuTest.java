import java.io.File;
import java.util.Scanner;

/** This class tests out the SudokuSolver class by solving a given incomplete SudokuPuzzle and comparing it to a
 * given solution.
 */
public class SudokuTest {

    public static void main(String[] args) {
        Scanner puzzleScanner = new Scanner(System.in);
        System.out.print("Enter filename of puzzle: ");
        String puzzle = puzzleScanner.nextLine();
        SudokuPuzzle myPuzzle = new SudokuPuzzle(readSudokuFile(puzzle));
        Scanner solutionScanner = new Scanner(System.in);
        System.out.print("Enter filename of solution (optional): ");
        String solution = solutionScanner.nextLine();
        SudokuSolver mySolver = new SudokuSolver();
        System.out.println("\nStarting Puzzle:");
        String startingPuzzle = myPuzzle.toString().replace("0", "_");
        System.out.println(startingPuzzle);
        mySolver.solve(myPuzzle);
        System.out.println("\nSolved Puzzle:");
        System.out.println(myPuzzle);
        if (!solution.equals("")) {
            SudokuPuzzle myPuzzle2 = new SudokuPuzzle(readSudokuFile(solution));
            boolean isSolutionCorrect = myPuzzle.equals(myPuzzle2);
            if (isSolutionCorrect) {
                System.out.println("Solution is correct!");
            }
            else {
                System.out.println("Solution is NOT correct!");
            }
        }
    }

    //takes the name of a file and finds it in your folder to read
    public static String readSudokuFile(String someFilename) {
        Scanner scan;
        try {
            scan = new Scanner(new File(someFilename));
        } catch (Exception e) {
            return "Unable to read file.";
        }
        StringBuilder numString = new StringBuilder();
        while (scan.hasNext()) {// while there’s more of the file to read
            String line = scan.nextLine();// read the next line
            line = line.replace(" ", "");
            numString.append(line);
        }
        scan.close();// done reading the file, close the Scanner
        return numString.toString();
    }
}
