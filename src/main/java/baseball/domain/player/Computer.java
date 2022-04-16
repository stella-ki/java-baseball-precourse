package baseball.domain.player;

import baseball.Util.Util;
import baseball.generator.BallGenerator;
import baseball.generator.NextStepBallGenerator;

import java.util.List;

public class Computer extends Player{

    public Computer(BallGenerator ballGenerator){
        this.ballGenerator = ballGenerator;
    }

    public void generateBalls(){
        balls.setBallMap(
                Util.integerListToString(
                        ballGenerator.generateBalls()
                )
        );
    }

}
