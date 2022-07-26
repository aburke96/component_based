package dominoes;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static java.util.Comparator.naturalOrder;

public class DominoHighLowImpl_Burke implements Domino {

    // STATICS
    public static final char HIGH_LOW_STRING_SEPARATOR = ':';
    public static final int INDEX_OF_SUM = 0;
    public static final int INDEX_OF_DIFFERENCE = 1;

    public static boolean isHighLowString(String str) {
        return str.contains(String.valueOf(HIGH_LOW_STRING_SEPARATOR));
    }

    // FIELDS
    private int highPipCount;
    private int lowPipCount;

    // 
    // CONSTRUCTORS
    // _____
    public DominoHighLowImpl_Burke (int highPipCount, int lowPipCount) {
        assert(highPipCount <= MAXIMUM_PIP_COUNT);
        assert(lowPipCount >= MINIMUM_PIP_COUNT);
        assert(highPipCount > lowPipCount);
        this.highPipCount = highPipCount;
        this.lowPipCount = lowPipCount;
    }

    public DominoHighLowImpl_Burke(int[] sumDifference) {
        assert(sumDifference.length == 2);
        assert(sumDifference[INDEX_OF_SUM] >= sumDifference[INDEX_OF_DIFFERENCE]);
        int A = sumDifference[INDEX_OF_SUM];
        int B = sumDifference[INDEX_OF_DIFFERENCE];
        highPipCount = (A + B) / 2;
        lowPipCount = (A - B) / 2;
    }

    public DominoHighLowImpl_Burke(Set<Integer> highLowSet) {
        assert( highLowSet.size() == 2);
        assert (highLowSet.contains(null) == false);
        List<Integer> arr = new ArrayList<>(highLowSet);
        arr.sort(naturalOrder());
        lowPipCount = arr.get(0);
        highPipCount = arr.get(1);
    }


    public DominoHighLowImpl_Burke(String highLowString) {
        assert (isHighLowString(highLowString));
        String[] arr = highLowString.split(String.valueOf(HIGH_LOW_STRING_SEPARATOR));
        Arrays.sort(arr);
        lowPipCount = Integer.parseInt(arr[0]);
        highPipCount = Integer.parseInt(arr[1]);
    }


    // ________________________________________________________________________________
    // PUBLIC
    // ________________________________________________________________________________
    @Override
    public int getHighPipCount() {
        return highPipCount;
    }

    @Override
    public int getLowPipCount() {
        return lowPipCount;
    }

}