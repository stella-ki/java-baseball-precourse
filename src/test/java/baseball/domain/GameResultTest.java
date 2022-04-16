package baseball.domain;

import baseball.constants.GameMessage;
import baseball.constants.ResultType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {

    @Test
    @DisplayName("GameResult 를 초기화 시키는지 확인한다.")
    void init() {
        GameResult gameResult = new GameResult();
        gameResult.increaseBallCount();
        gameResult.increaseStrikeCount();
        gameResult.increaseStrikeCount();
        gameResult.init();

        assertEquals(ResultType.NOTHING.getValue(),
                gameResult.toString(),
                "ball count 값과 strike count 값이 0으로 초기화 되어야 합니다.");
    }

    @Test
    @DisplayName("Ball count를 증가시키는지 확인한다.")
    void increaseBallCount() {
        GameResult gameResult = new GameResult();

        gameResult.increaseBallCount();

        assertEquals(String.format("%d" + ResultType.BALL.getValue(), 1),
                gameResult.toString(),
                "ball count 값이 1이여야 합니다.");

        gameResult.increaseBallCount();

        assertEquals(String.format("%d" + ResultType.BALL.getValue(), 2),
                gameResult.toString(),
                "ball count 값이 2이여야 합니다.");
    }

    @Test
    @DisplayName("strike count를 증가시키는지 확인한다.")
    void increaseStrikeCount() {
        GameResult gameResult = new GameResult();

        gameResult.increaseStrikeCount();

        assertEquals(String.format("%d" + ResultType.STRIKE.getValue(), 1),
                gameResult.toString(),
                "strike count 값이 1이여야 합니다.");

        gameResult.increaseStrikeCount();

        assertEquals(String.format("%d" + ResultType.STRIKE.getValue(), 2),
                gameResult.toString(),
                "strike count 값이 2이여야 합니다.");
    }

    @Test
    @DisplayName("strike count와 ball count를 포맷에 맞춰 출력하는지 확인한다.")
    void testToString() {
        GameResult gameResult = new GameResult();
        gameResult.increaseBallCount();
        gameResult.increaseStrikeCount();
        gameResult.increaseStrikeCount();

        assertEquals(String.format("%d" + ResultType.BALL.getValue() + " %d" + ResultType.STRIKE.getValue(), 1, 2),
                gameResult.toString(),
                "ball count 값은 1, strike count 값은 2로 설정되어야 합니다.");

        gameResult.increaseBallCount();
        gameResult.increaseStrikeCount();

        assertEquals(String.format("%d" + ResultType.BALL.getValue() + " %d" + ResultType.STRIKE.getValue(), 2, 3),
                gameResult.toString(),
                "ball count 값은 2, strike count 값은 3로 설정되어야 합니다.");
    }

    @Test
    @DisplayName("strike 값에 따라 결과값을 정상적으로 반환하는지 확인한다.")
    void isFinished() {
        GameResult gameResult = new GameResult();

        gameResult.increaseBallCount();
        gameResult.increaseStrikeCount();
        gameResult.increaseStrikeCount();

        assertFalse(gameResult.isFinished(), "strike count가 2이므로 false를 반환해야 합니다.");

        gameResult.increaseStrikeCount();

        assertTrue(gameResult.isFinished(),  "strike count가 3이므로 true를 반환해야 합니다.");
        
    }
}