package data;

import java.util.ArrayList;

public class NumberGenerator {
    
    public static int[] getSortedNumbers() {
        ArrayList<Integer> numberList = new ArrayList<>();
        for (int i = 1; i <= 100000000; i++) {
            numberList.add(i);
        }
        return numberList.stream().mapToInt(Integer::intValue).toArray();
    }

}
