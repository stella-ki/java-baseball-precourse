package baseball.domain.ball;

import java.util.*;

public abstract class Balls {

    //ball , index
    Map<Integer, Integer> ballMap = new HashMap<>();

    public boolean isBallThere(int ball){
        return ballMap.containsKey(ball);
    }

    public int getIndex(int ball) {
        return ballMap.get(ball);
    }

    public Set<Integer> getBalls(){
        return ballMap.keySet();
    }

    public void setBallMap(String ballStr){
        if(isValidValue(ballStr)){
            parseBallMap(ballStr);
        }
    }

    public abstract boolean isValidValue(String ballStr);
    public abstract void parseBallMap(String ballStr);
}
