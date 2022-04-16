package baseball.view;

import baseball.constants.ErrorMessage;
import baseball.constants.GameMessage;
import baseball.controller.BaseballGame;
import baseball.domain.player.Player;
import baseball.domain.player.User;
import camp.nextstep.edu.missionutils.Console;

public class GameMachine {

    BaseballGame game = new BaseballGame();
    User user = new User();

    public void run(){
        boolean isGameFinished = false;

        game.start();

        while (!isGameFinished){
            isGameFinished = game();
        }
    }

    private boolean game(){
        game.init();
        System.out.print(GameMessage.MSG_INPUT_BALLS_VALUE);

        String userBalls = Console.readLine();
        user.generateBalls(userBalls);
        game.play(user);

        game.printGameScore();

        if(game.isFinished()){
            return gameClose();
        }

        return false;
    }

    private boolean gameClose(){

        System.out.println(GameMessage.MSG_GAME_FINISHED);
        if(askUser()){
            game.start();
            return false;
        }
        return true;
    }

    private boolean askUser(){
        System.out.println(GameMessage.MSG_ASK_QUESTION_GAME_FINISH);
        String answer = Console.readLine();

        if(answer.equals(GameMessage.MSG_ASK_ANSWER_YES)){
            return true;
        }

        if(answer.equals(GameMessage.MSG_ASK_ANSWER_NO)){
            return false;
        }

        System.out.println(ErrorMessage.ILLEGAL_ANSWER);
        return askUser();
    }
}
