package baseball.domain.player;

import baseball.domain.ball.*;
import java.util.Set;

public abstract class Player {

    Balls balls = new NextStepBalls();

    public abstract void generateBalls(String ballStr);

    public Set<Integer> getBalls(){
        return balls.getValues();
    }

    public int getBall(int key){
        return balls.getBall(key);
    }

    public boolean isBallThere(int key){
        return balls.isBallThere(key);
    }
}
