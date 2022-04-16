package baseball.domain.player;

import baseball.generator.BallGenerator;
import baseball.generator.NextStepBallGenerator;

import java.util.List;

public class Computer extends Player{

    public void generateBalls(String ballStr){
        BallGenerator ballGenerator = new NextStepBallGenerator();
        balls.setBallMap(
                Computer.integerListToString(
                        ballGenerator.generateBalls()
                )
        );
    }

    public static String integerListToString(List<Integer> list){
        return list.toString()
                .replaceAll("[^0-9]","");
    }

}
