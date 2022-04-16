package baseball.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class NextStepBallGeneratorTest {

    @Test
    @DisplayName("생성된 ball의 길이가 3인지 확인한다.")
    void checkNumberLength(){
        BallGenerator ballGenerator = new NextStepBallGenerator();

        List<Integer> balls = ballGenerator.generateBalls();

        assertEquals(3, balls.size(), "생성된 ball의 길이가 3이 아닙니다.");
    }

    @Test
    @DisplayName("생성된 ball의 값이 1~9의 범위인지 확인한다.")
    void checkNumberFormat(){
        BallGenerator ballGenerator = new NextStepBallGenerator();

        List<Integer> balls = ballGenerator.generateBalls();

        balls.forEach(ball -> assertFalse((ball > 9 || ball < 1), "생성된 ball의 값이 1~9의 범위가 아닙니다."));

    }

    @Test
    @DisplayName("중복이 없는 ball을 생성하는지 확인한다.")
    void checkNumberDuplicate(){
        BallGenerator ballGenerator = new NextStepBallGenerator();

        List<Integer> balls = ballGenerator.generateBalls();
        Set<Integer> ballsSet = new HashSet<>(balls);

        assertEquals(balls.size(), ballsSet.size(), "생성된 ball은 중복이 없어야 합니다.");
        assertEquals(3, ballsSet.size(), "생성된 ball은 중복이 없어야 합니다.");
    }
}