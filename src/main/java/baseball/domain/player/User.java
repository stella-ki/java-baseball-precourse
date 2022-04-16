package baseball.domain.player;

public class User extends Player{

    @Override
    public void generateBalls(String ballStr) {
        balls.setBallMap(ballStr);
    }

}
