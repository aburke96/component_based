package dominoes;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Comparator.naturalOrder;

public class DominoHighLowSetImpl_Burke implements Domino {

    public static final char SUM_DIFFERENCE_DELIMITER = ',';

    public static boolean isLowPlus8TimesHighInteger(int k) {
        assert(k > 0);
        int lowPlus8 = 0;
        int high = MAXIMUM_PIP_COUNT;
        while(high > MINIMUM_PIP_COUNT + 1) {
            lowPlus8 = k / high;
            if(k % high == 0 && lowPlus8 - 8 <= MAXIMUM_PIP_COUNT) {
                return true;
            }
            high -= 1;
        }
        return false;
    }

    public static boolean isSumDifferenceString(String str) {
        return str.contains(String.valueOf(SUM_DIFFERENCE_DELIMITER));
    }

    private Set<Integer> highLowSet;


    // ____
    // CONSTRUCTORS
    
   
    public DominoHighLowSetImpl_Burke(int highPipCount, int lowPipCount) {
        HashSet<Integer> highLowHashSet = new HashSet<>();
        highLowSet = highLowHashSet;
        highLowHashSet.add(highPipCount);
        highLowHashSet.add(lowPipCount);
    }


    public DominoHighLowSetImpl_Burke(String sumDifferenceString) {
        assert(isSumDifferenceString(sumDifferenceString));
        HashSet<Integer> highLowHashSet = new HashSet<>();
        highLowSet = highLowHashSet;
        String[] arr = sumDifferenceString.split(String.valueOf(SUM_DIFFERENCE_DELIMITER));
        Arrays.sort(arr);
        int A = Integer.parseInt(arr[0]);
        int B = Integer.parseInt(arr[1]);
        int highPipCount = A + B / 2;
        int lowPipCount = A - B / 2;
        highLowSet.add(highPipCount);
        highLowSet.add(lowPipCount);
    }


    public DominoHighLowSetImpl_Burke(int lowPlus8TimesHigh) {
        assert(isLowPlus8TimesHighInteger(lowPlus8TimesHigh));
        HashSet<Integer> highLowHashSet = new HashSet<>();
        highLowSet = highLowHashSet;
        int lowPlus8 = 0;
        int high = MAXIMUM_PIP_COUNT;
        while(high > MINIMUM_PIP_COUNT + 1) {
            lowPlus8 = lowPlus8TimesHigh / high;
            if(lowPlus8TimesHigh % high == 0 && lowPlus8 - 8 <= MAXIMUM_PIP_COUNT) {
                break;
            }
            high -= 1;
        }
        int low = lowPlus8 - 8;
        highLowHashSet.add(high);
        highLowHashSet.add(low);
        highLowSet = highLowHashSet;
    }

    @Override
    public int getHighPipCount() {
        List<Integer> arr = new ArrayList<>(highLowSet);
        arr.sort(naturalOrder());
        return arr.get(1);
    }

    @Override
    public int getLowPipCount() {
        List<Integer> arr = new ArrayList<>(highLowSet);
        arr.sort(naturalOrder());
        return arr.get(0);
    }
}