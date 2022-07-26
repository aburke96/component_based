package dominoes;

import java.util.List;

public class DominoLowDifferenceStringImpl_Burke implements Domino {

    private static final char LOW_DIFFERENCE_DELIMITER = '*';

    public static final int INDEX_OF_HIGH = 0;
    public static final int INDEX_OF_SUM = 1;

    private String lowDifferenceString;

    // 
    // CONSTRUCTORS
    // 
    //pre: left to student
    //post: left to student
    public DominoLowDifferenceStringImpl_Burke(int lowPlus8TimesHigh) {
        assert(lowPlus8TimesHigh > 0);
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
        lowDifferenceString  = String.valueOf(low) +
                LOW_DIFFERENCE_DELIMITER + String.valueOf(high-low);
    }

    //pre: left to student
    //post: left to student
    public DominoLowDifferenceStringImpl_Burke( List<Integer> highSum) {
        assert(highSum.size() == 2);
        assert(highSum.get(INDEX_OF_SUM) > highSum.get(INDEX_OF_HIGH));
        int low = highSum.get(INDEX_OF_SUM) - highSum.get(INDEX_OF_HIGH);
        int high = highSum.get(INDEX_OF_HIGH);
        lowDifferenceString  = String.valueOf(low) + LOW_DIFFERENCE_DELIMITER +
                                String.valueOf(high-low);
    }

    //
    // public
    
    @Override
    public int getHighPipCount() {
        String regex = String.format("\\%s", String.valueOf(LOW_DIFFERENCE_DELIMITER));
        String[] arr = lowDifferenceString.split(regex);
        int low = Integer.parseInt(arr[0]);
        int diff = Integer.parseInt(arr[1]);
        return diff+low;
    }

    @Override
    public int getLowPipCount() {
        String regex = String.format("\\%s", String.valueOf(LOW_DIFFERENCE_DELIMITER));
        String[] arr = lowDifferenceString.split(regex);
        int low = Integer.parseInt(arr[0]);
        return low;
    }
}