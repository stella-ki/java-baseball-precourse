package baseball.domain;

import baseball.config.Config;
import baseball.constants.GameMessage;
import baseball.constants.ResultType;

public class GameResult {
    private int strikeCount = 0;
    private int ballCount = 0;

    public void init(){
        strikeCount = 0;
        ballCount = 0;
    }

    public int getBallCount(){
        return ballCount;
    }

    public int getStrikeCount(){
        return strikeCount;
    }

    public void increaseBallCount(){
        ballCount++;
    }

    public void increaseStrikeCount(){
        strikeCount++;
    }

    @Override
    public String toString(){
        if(strikeCount == 0 && ballCount == 0){
            return ResultType.NOTHING.getValue();
        }
        if(strikeCount == 0){
            return String.format("%d" + ResultType.BALL.getValue(), ballCount);
        }
        if(ballCount == 0){
            return String.format("%d" + ResultType.STRIKE.getValue(), strikeCount);
        }
        return String.format("%d" + ResultType.BALL.getValue() + " %d" + ResultType.STRIKE.getValue(), ballCount, strikeCount);
    }

    public boolean isFinished(){
        return (strikeCount == Config.STRIKE_INT_VALUE);
    }
}
