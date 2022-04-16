package baseball.controller;

import baseball.constants.GameMessage;
import baseball.constants.ResultType;
import baseball.domain.player.Computer;
import baseball.domain.player.Player;
import baseball.generator.NextStepBallGenerator;
import baseball.domain.GameResult;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    Player computer;
    GameResult gameResult;

    public BaseballGame(){
        computer = new Computer(new NextStepBallGenerator());
        gameResult = new GameResult();
    }

    public void start(){
        computer.generateBalls(null);
    }

    public void init(){
        gameResult.init();
    }

    public boolean isFinished(){
        return gameResult.isFinished();
    }

    public void printGameScore(){
        System.out.println(gameResult.toString());
        System.out.println();
    }

    public void play(Player player){
        List<Integer> keys = new ArrayList<>(player.getBalls());
        for (int key : keys){
            score(player, key);
        }
    }

    public void score(Player player, int key){
        if(!computer.isBallThere(key)){
            //nothing
            return;
        }
        if(computer.isBallThere(key) &&
                computer.getBall(key) != player.getBall(key)){
            //ball
            gameResult.increaseBallCount();
            return;
        }
        if(computer.isBallThere(key) &&
                computer.getBall(key) == player.getBall(key)){
            //strike
            gameResult.increaseStrikeCount();
        }
    }

}
