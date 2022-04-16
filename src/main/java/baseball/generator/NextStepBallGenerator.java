 package baseball.generator;

import baseball.config.Config;
import java.util.List;

public class NextStepBallGenerator extends NonDupOneDigitBallGenerator {

    @Override
    public List<Integer> generateBalls() {
        return super.generateBalls(Config.MIN_INPUT_VALUE, Config.MAX_INPUT_VALUE, Config.LENGTH_INPUT_VALUE);
    }
}
