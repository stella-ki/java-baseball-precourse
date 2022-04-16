package baseball.controller;

import baseball.Util.Util;
import baseball.constants.GameMessage;
import baseball.constants.ResultType;
import baseball.domain.player.Player;
import baseball.domain.player.User;
import baseball.generator.BallGenerator;
import baseball.generator.NextStepBallGenerator;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.MockedStatic;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class BaseballGameTest {

    private static final Duration RANDOM_TEST_TIMEOUT = Duration.ofSeconds(10L);

    @Test
    @DisplayName("게임 시작을 위해 computer 값이 초기화 되는지 확인한다")
    void start() {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.start();
        Set<Integer> balls = baseballGame.computer.getBalls();

        assertEquals(3, balls.size(), "Computer 값의 길이가 3이여야 합니다.");

        ArrayList<Integer> ballsArray = new ArrayList<>();
        balls.forEach(b -> ballsArray.add(baseballGame.computer.getIndex(b), b));

        assertEquals(3, balls.size(), "Computer 값이 중복 없는 값으로 생성되어야 합니다.");
    }

    @Test
    @DisplayName("게임 재시작을 위해 game result 값이 초기화 되는지 확인한다.")
    void init() {
        Player player = new User();
        player.generateBalls("135");

        assertRandomTest(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
                () -> {
                    BaseballGame baseballGame = new BaseballGame();
                    baseballGame.start();
                    baseballGame.play(player);

                    baseballGame.init();

                    assertEquals(0, baseballGame.gameResult.getBallCount(), "ball count가 0으로 초기화되어야 합니다.");
                    assertEquals(0, baseballGame.gameResult.getStrikeCount(), "strike count가 0으로 초기화되어야 합니다.");
                },
                1,3,5
        );
    }

    @Test
    @DisplayName("게임 종료 여부를 정상적으로 반환하는지 확인한다.")
    void isFinished() {
        Player player = new User();
        player.generateBalls("135");

        assertRandomTest(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
                () -> {
                    BaseballGame baseballGame = new BaseballGame();
                    baseballGame.start();
                    baseballGame.play(player);

                    assertTrue(baseballGame.isFinished(), "strike count가 3일 때, isFinished는 true를 반환해야 합니다.");
                },
                1,3,5
        );
    }

    @Test
    @DisplayName("game score가 정상적으로 출력되는지 확인한다.")
    void printGameScore() {
        StringBuffer sb = new StringBuffer();
        Player player = new User();
        player.generateBalls("245");

        assertRandomTest(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
                () -> {
                    BaseballGame baseballGame = new BaseballGame();
                    baseballGame.start();
                    baseballGame.play(player);

                    assertEquals(baseballGame.gameResult.toString(),
                            sb.append(baseballGame.gameResult.getStrikeCount()).append(ResultType.STRIKE.getValue()).toString(),
                            "결과 값이 '1스트라이크'여야 합니다.");

                    sb.setLength(0);

                    baseballGame.init();

                    player.generateBalls("215");
                    baseballGame.play(player);

                    assertEquals(baseballGame.gameResult.toString(),
                            sb.append(baseballGame.gameResult.getBallCount()).append(ResultType.BALL.getValue()).append(GameMessage.SPACE)
                                    .append(baseballGame.gameResult.getStrikeCount()).append(ResultType.STRIKE.getValue()).toString(),
                            "결과 값이 '1볼 1스트라이크'여야 합니다.");
                },
                1,3,5
        );
    }

    @Test
    @DisplayName("game score의 결과가 정상적으로 저장되는지 확인한다.")
    void play() {
        Player player = new User();
        player.generateBalls("245");

        assertRandomTest(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
                () -> {
                    BaseballGame baseballGame = new BaseballGame();
                    baseballGame.start();
                    baseballGame.play(player);

                    assertEquals(1, baseballGame.gameResult.getStrikeCount(),"strike count가 1이여야 합니다.");

                    baseballGame.init();

                    player.generateBalls("215");
                    baseballGame.play(player);

                    assertEquals(1, baseballGame.gameResult.getStrikeCount(),"strike count가 1이여야 합니다.");
                    assertEquals(1, baseballGame.gameResult.getBallCount(),"ball count가 1이여야 합니다.");
                },
                1,3,5
        );
    }

    @Test
    @DisplayName("game 단일 값의 스코어가 정상적으로 저장되는지 확인한다.")
    void score() {
        Player player = new User();
        player.generateBalls("215");

        assertRandomTest(
                () -> Randoms.pickNumberInRange(anyInt(), anyInt()),
                () -> {
                    BaseballGame baseballGame = new BaseballGame();
                    baseballGame.start();
                    baseballGame.score(player, 1);

                    assertEquals(1, baseballGame.gameResult.getBallCount(),"ball count가 1이여야 합니다.");

                    baseballGame.score(player, 5);

                    assertEquals(1, baseballGame.gameResult.getStrikeCount(),"strike count가 1이여야 합니다.");
                },
                1,3,5
        );
    }


    private static <T> void assertRandomTest(
            final MockedStatic.Verification verification,
            final Executable executable,
            final Integer value,
            final Integer... values
    ) {
        assertTimeoutPreemptively(RANDOM_TEST_TIMEOUT, () -> {
            try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
                mock.when(verification).thenReturn(value, Arrays.stream(values).toArray());
                executable.execute();
            }
        });
    }
}