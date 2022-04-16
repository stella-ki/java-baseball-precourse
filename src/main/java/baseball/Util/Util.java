package baseball.Util;

import java.util.List;

public class Util {

    public static String integerListToString(List<Integer> list){
        return list.toString()
                .replaceAll("[^0-9]","");
    }
}
