package baseball.generator;

import java.util.List;

public interface BallGenerator {
    List<Integer> generateBalls();
    List<Integer> generateBalls(int min, int max, int length);
}
