import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** This iterator class takes a list and makes a list of all possible subsets of the list. **/
public class SubsetIterator<T> implements Iterator<List<T>> {

    private long iteratorNum;
    private final ArrayList<List<T>> subsetList = new ArrayList<>();


    public SubsetIterator(List<T> elementList) {
        this.iteratorNum = 0;

        //adds each individual subset by the pattern of ascending binary numbers.
        for (long m = 0; m <= (1L << elementList.size()) - 1; m++) {
            ArrayList<T> subset = new ArrayList<>();
            for (int i = 0; i < elementList.size(); i++) {
                if ((m & (1L << i)) > 0) {
                    subset.add(elementList.get(i));
                }
            }
            subsetList.add(subset);
        }
    }

    @Override
    //Checks if there is a next value to iterate. Returns true if yes.
    public boolean hasNext() {
        return iteratorNum < subsetList.size();
    }

    //Goes to that next value.
    public List<T> next() {
        long oldNum = iteratorNum;
        iteratorNum ++;
        return subsetList.get((int) oldNum);
    }

    //Returns the list of all possible subsets.
    public ArrayList<List<T>> getSubsetList() {
        return subsetList;
    }

}
