package dominoes;

import java.util.List;

public class DominoTest_Burke {

    public static void main(String[] args) {

        System.out.println("DominoLowDifferenceStringImpl_Burke...");
        DominoLowDifferenceStringImpl_Burke lowDiff = new DominoLowDifferenceStringImpl_Burke( List.of(5, 8));
        System.out.println(lowDiff.getHighPipCount() == 5);
        System.out.println(lowDiff.getLowPipCount() == 3);
        lowDiff = new DominoLowDifferenceStringImpl_Burke( (3+8)*5);
        System.out.println(lowDiff.getHighPipCount() == 5);
        System.out.println(lowDiff.getLowPipCount() == 3);


        System.out.println("DominoHighLowImpl_Burke...");
        DominoHighLowImpl_Burke highLow = new DominoHighLowImpl_Burke(5, 3);
        System.out.println(highLow.getHighPipCount() == 5);
        System.out.println(highLow.getLowPipCount() == 3);
        highLow = new DominoHighLowImpl_Burke(new int[]{8, 2});
        System.out.println(highLow.getHighPipCount() == 5);
        System.out.println(highLow.getLowPipCount() == 3);

        System.out.println("DominoHighLowSetImpl_Burke...");
        DominoHighLowSetImpl_Burke highLowSet = new DominoHighLowSetImpl_Burke(5, 3);
        System.out.println(highLowSet.getHighPipCount() == 5);
        System.out.println(highLowSet.getLowPipCount() == 3);



    }
}
