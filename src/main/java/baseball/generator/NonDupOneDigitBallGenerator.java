package baseball.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public abstract class NonDupOneDigitBallGenerator implements BallGenerator{

    @Override
    public List<Integer> generateBalls(int min, int max, int length) {
        Set<Integer> s = new HashSet<>();

        while(s.size() < length){
            s.add(Randoms.pickNumberInRange(min,max));
        }

        return new ArrayList<>(s);
    }
}
