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
        StringBuilder sb = new StringBuilder();
        if(strikeCount == 0 && ballCount == 0){
            return ResultType.NOTHING.getValue();
        }
        if(strikeCount == 0){
            return sb.append(ballCount).append(ResultType.BALL.getValue()).toString();
        }
        if(ballCount == 0){
            return sb.append(strikeCount).append(ResultType.STRIKE.getValue()).toString();
        }

        return sb.append(ballCount).append(ResultType.BALL.getValue()).append(GameMessage.SPACE)
                .append(strikeCount).append(ResultType.STRIKE.getValue()).toString();
    }

    public boolean isFinished(){
        return (strikeCount == Config.STRIKE_INT_VALUE);
    }
}
