import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** this class builds two towers such that the heights of the towers are as close as possible. Provides other relevant
 * information.
 */
public class TwoTowers {
    private final ArrayList<Double> blockLengthList = new ArrayList<>();

    public TwoTowers(int numOfBlocks) {
        for (int n = 1; n <= numOfBlocks; n++) {
            blockLengthList.add(Math.sqrt(n));
        }
    }

    //Returns the ideal height of the two towers, if they were both the same height.
    public Double getTargetHeight() {
        double sum = 0;
        for (Double blockLength : blockLengthList) {
            sum += blockLength;
        }
        return sum / 2;
    }

    //Returns the subset of lengths that provides the closest height to the other tower.
    public List<Double> getBestLengthSubset() {
        SubsetIterator<Double> myIterator = new SubsetIterator<>(blockLengthList);
        double bestHeightDifference = this.getTargetHeight();
        List<Double> bestLengthSubset = null;
        while (myIterator.hasNext()) {
            double sum = 0;
            List<Double> subset = myIterator.next();
            for (Double num : subset) {
                sum += Math.sqrt(num);
            }
            if (sum <= this.getTargetHeight()) {
                if ((this.getTargetHeight() - sum) < bestHeightDifference) {
                    bestHeightDifference = this.getTargetHeight() - sum;
                    bestLengthSubset = subset;
                }
            }
        }
        return bestLengthSubset;
    }

    //Returns the subset of n-values that provides the closest height to the other tower.
    public List<Long> getBestSubset() {
        ArrayList<Long> bestSubset = new ArrayList<>();
        for (Double num : this.getBestLengthSubset()) {
            bestSubset.add(Math.round(num * num));
        }
        return bestSubset;
    }

    //Returns the subset of n-values that provides the closest height to the other tower as a string.
    public String getBestSubsetStr() {
        String bestSubsetStr = "";
        for (Long num : this.getBestSubset()) {
            bestSubsetStr = bestSubsetStr.concat(num.toString() + " ");
        }
        return bestSubsetStr;
    }

    //Returns the height of the tower that provides the closest height to the other tower.
    public Double getBestHeight() {
        double sum = 0;
        for (Double num : this.getBestLengthSubset()) {
            sum += Math.sqrt(num);
        }
        return sum;
    }

    //Returns the height difference of the towers when they are closest.
    public Double getBestHeightDifference() {
        return this.getTargetHeight() - this.getBestHeight();
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of blocks: ");
        int num = scan.nextInt();
        TwoTowers myTowers = new TwoTowers(num);
        System.out.println("Target (optimal) height: " + myTowers.getTargetHeight());
        System.out.println("Best subset: " + myTowers.getBestSubsetStr());
        System.out.println("Best height: " + myTowers.getBestHeight());
        System.out.println("Distance from optimal: " + myTowers.getBestHeightDifference());
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Solve duration: " + duration + " ms");
    }
}
