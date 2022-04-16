package baseball.domain.ball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class NextStepBallsTest {

    @Test
    @DisplayName("길이가 3이 아닌값에 대한 검증결과가 정상인지 확인한다.")
    void isValidValueLength() {
        Balls balls = new NextStepBalls();

        assertThatThrownBy(() -> balls.isValidValue("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("범위가 1-9가 아닌 값에 대한 검증결과가 정상인지 확인한다.")
    void isValidValueRange() {
        Balls balls = new NextStepBalls();

        assertThatThrownBy(() -> balls.isValidValue("FFF"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Value, index를 정상적으로 parsing하는 지 확인한다.")
    void parseBallMap() {
        Balls balls = new NextStepBalls();
        balls.parseBallMap("645");
        Map<Integer, Integer> map = balls.ballMap;

        assertTrue(map.containsKey(6), "Ball이 비정상적으로 parsing되어 6의 값이 포함되지 않았습니다.");
        assertTrue(map.containsKey(4), "Ball이 비정상적으로 parsing되어 4의 값이 포함되지 않았습니다.");
        assertTrue(map.containsKey(5), "Ball이 비정상적으로 parsing되어 5의 값이 포함되지 않았습니다.");

        assertEquals(0, map.get(6), "Ball 6값의 index는 0이여야 합니다.");
        assertEquals(1, map.get(4),"Ball 4값의 index는 1이여야 합니다.");
        assertEquals(2, map.get(5),"Ball 5값의 index는 2이여야 합니다.");

    }
}