 package baseball.generator;

import baseball.config.Config;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NextStepBallGenerator extends NonDupOneDigitBallGenerator {

    @Override
    public List<Integer> generateBalls() {
        return super.generateBalls(Config.MIN_INPUT_VALUE, Config.MAX_INPUT_VALUE, Config.LENGTH_INPUT_VALUE);
    }
}
