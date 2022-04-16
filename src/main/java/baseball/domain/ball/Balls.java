package baseball.domain.ball;

import java.util.*;

public abstract class Balls<K, V> {

    //value , index
    Map<K, V> ballMap = new HashMap<>();

    public boolean isBallThere(K key){
        return getBall(key) != null;
    }

    public V getBall(K key) {
        return ballMap.get(key);
    }

    public Set<K> getValues(){
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
