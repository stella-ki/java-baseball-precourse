package baseball.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class NonDupOneDigitBallGeneratorTest {

    int minValue = 2;
    int maxValue = 8;
    int length = 4;


    @Test
    @DisplayName("주어진 length에 맞는 길이의 ball을 생성하는지 확인한다.")
    void checkNumberLength(){
        BallGenerator ballGenerator = Mockito.mock(NonDupOneDigitBallGenerator.class, Mockito.CALLS_REAL_METHODS);

        List<Integer> balls = ballGenerator.generateBalls(minValue, maxValue, length);

        assertEquals(length, balls.size(), "생성된 ball의 길이와 기대하는 길이와 다릅니다.");
    }

    @Test
    @DisplayName("주어진 범위에 맞는 값으로 ball을 생성하는지 확인한다.")
    void checkNumberFormat(){
        BallGenerator ballGenerator = Mockito.mock(NonDupOneDigitBallGenerator.class, Mockito.CALLS_REAL_METHODS);

        List<Integer> balls = ballGenerator.generateBalls(minValue, maxValue, length);

        balls.forEach(ball -> assertFalse((ball > maxValue || ball < minValue), "생성된 ball의 값이 input값의 범위에 해당되지 않습니다."));

    }

    @Test
    @DisplayName("중복이 없는 ball을 생성하는지 확인한다.")
    void checkNumberDuplicate(){
        BallGenerator ballGenerator = Mockito.mock(NonDupOneDigitBallGenerator.class, Mockito.CALLS_REAL_METHODS);

        List<Integer> balls = ballGenerator.generateBalls(minValue, maxValue, length);
        Set<Integer> ballsSet = new HashSet<>(balls);

        assertEquals(balls.size(), ballsSet.size(), "생성된 ball은 중복이 없어야 합니다.");

        assertEquals(length, ballsSet.size(), "생성된 ball은 중복이 없어야 합니다.");
    }



}