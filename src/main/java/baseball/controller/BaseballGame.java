package baseball.controller;

import baseball.domain.player.Computer;
import baseball.domain.player.Player;
import baseball.generator.NextStepBallGenerator;
import baseball.domain.GameResult;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    Computer computer;
    GameResult gameResult;

    public BaseballGame(){
        computer = new Computer(new NextStepBallGenerator());
        gameResult = new GameResult();
    }

    public void start(){
        computer.generateBalls();
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
        List<Integer> balls = new ArrayList<>(player.getBalls());
        for (int ball : balls){
            score(player, ball);
        }
    }

    public void score(Player player, int ball){
        if(!computer.isBallThere(ball)){
            return;
        }
        if(computer.getIndex(ball) != player.getIndex(ball)){
            gameResult.increaseBallCount();
            return;
        }
        if(computer.getIndex(ball) == player.getIndex(ball)){
            gameResult.increaseStrikeCount();
        }
    }

}
