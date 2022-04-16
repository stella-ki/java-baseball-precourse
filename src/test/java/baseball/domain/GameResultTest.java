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

        assertEquals(gameResult.toString(), ResultType.NOTHING.getValue(), "ball count 값과 strike count 값이 0으로 초기화 되어야 합니다.");
    }

    @Test
    @DisplayName("Ball count를 증가시키는지 확인한다.")
    void increaseBallCount() {
        StringBuilder sb = new StringBuilder();
        GameResult gameResult = new GameResult();

        gameResult.increaseBallCount();

        assertEquals(gameResult.toString(),
                sb.append(1).append(ResultType.BALL.getValue()).toString()
                , "ball count 값이 1이여야 합니다.");

        sb.setLength(0);

        gameResult.increaseBallCount();

        assertEquals(gameResult.toString(),
                sb.append(2).append(ResultType.BALL.getValue()).toString()
                , "ball count 값이 2이여야 합니다.");
    }

    @Test
    @DisplayName("strike count를 증가시키는지 확인한다.")
    void increaseStrikeCount() {
        StringBuilder sb = new StringBuilder();
        GameResult gameResult = new GameResult();

        gameResult.increaseStrikeCount();

        assertEquals(gameResult.toString(),
                sb.append(1).append(ResultType.STRIKE.getValue()).toString()
                , "strike count 값이 1이여야 합니다.");

        sb.setLength(0);

        gameResult.increaseStrikeCount();

        assertEquals(gameResult.toString(),
                sb.append(2).append(ResultType.STRIKE.getValue()).toString()
                , "strike count 값이 2이여야 합니다.");

    }

    @Test
    @DisplayName("strike count와 ball count를 포맷에 맞춰 출력하는지 확인한다.")
    void testToString() {
        StringBuilder sb = new StringBuilder();
        GameResult gameResult = new GameResult();
        gameResult.increaseBallCount();
        gameResult.increaseStrikeCount();
        gameResult.increaseStrikeCount();

        assertEquals(gameResult.toString(),
                sb.append(1).append(ResultType.BALL.getValue()).append(GameMessage.SPACE)
                        .append(2).append(ResultType.STRIKE.getValue()).toString()
                , "ball count 값은 1, strike count 값은 2로 설정되어야 합니다.");

        sb.setLength(0);

        gameResult.increaseBallCount();
        gameResult.increaseStrikeCount();

        assertEquals(gameResult.toString(),
                sb.append(2).append(ResultType.BALL.getValue()).append(GameMessage.SPACE)
                        .append(3).append(ResultType.STRIKE.getValue()).toString()
                , "ball count 값은 2, strike count 값은 3로 설정되어야 합니다.");
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