 package baseball.domain.ball;

import baseball.config.Config;
import baseball.constants.ErrorMessage;

import java.util.regex.Pattern;

public class NextStepBalls extends Balls<Integer, Integer> {

    @Override
    public boolean isValidValue(String value){

        if(value.length() != 3){
            throw new IllegalArgumentException(ErrorMessage.ILLEGAL_FORMAT_PARAMETER_LENGTH);
        }

        if(!Pattern.matches(Config.PATTERN_NEXTCAMP, value)){
            throw new IllegalArgumentException(ErrorMessage.ILLEGAL_FORMAT_PARAMETER_RANGE);
        }

        return true;
    }

    @Override
    public void parseBallMap(String ballStr){

        char[] chars = ballStr.toCharArray();
        for (int i = 0; i < chars.length; i++){
            ballMap.put(Character.getNumericValue(chars[i]), i);
        }

    }

}
