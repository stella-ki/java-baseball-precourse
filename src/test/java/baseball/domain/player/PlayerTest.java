package baseball.domain.player;

import baseball.domain.ball.NextStepBalls;
import baseball.generator.BallGenerator;
import baseball.generator.NextStepBallGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    @DisplayName("computer 객체가 주어진 ball generator에 맞게 ball을 생성하고 가지고 있는지 확인한다.")
    void computerGenerateBalls() {
        BallGenerator ballGenerator = new NextStepBallGenerator();
        Computer player = new Computer(ballGenerator);
        player.generateBalls();
        assertTrue(player.balls instanceof NextStepBalls,"");
    }


    @Test
    @DisplayName("User 객체가 input으로 넣어준 ball을 가지고 있는지 확인한다.")
    void userSetBalls() {
        String ballStr = "542";
        User player = new User();
        player.generateBalls(ballStr);

        assertTrue(player.balls.isBallThere(5), "Ball이 비정상적으로 parsing되어 5의 값이 포함되지 않았습니다.");
        assertTrue(player.balls.isBallThere(4), "Ball이 비정상적으로 parsing되어 4의 값이 포함되지 않았습니다.");
        assertTrue(player.balls.isBallThere(2), "Ball이 비정상적으로 parsing되어 2의 값이 포함되지 않았습니다.");

         assertEquals(0, player.balls.getIndex(5), "Ball 5값의 index는 0이여야 합니다.");
        assertEquals(1, player.balls.getIndex(4),"Ball 4값의 index는 1이여야 합니다.");
        assertEquals(2, player.balls.getIndex(2),"Ball 2값의 index는 2이여야 합니다.");
    }
}