package baseball.domain.ball;

import java.util.*;

public abstract class Balls {

    //value , index
    Map<Integer, Integer> ballMap = new HashMap<>();

    public boolean isBallThere(int key){
        return ballMap.containsKey(key);
    }

    public int getBall(int key) {
        return ballMap.get(key);
    }

    public Set<Integer> getValues(){
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
