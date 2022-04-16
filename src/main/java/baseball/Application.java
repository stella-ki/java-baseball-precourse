package baseball;

import baseball.view.GameMachine;

public class Application {
    public static void main(String[] args) {
        GameMachine processGame = new GameMachine();
        processGame.run();
    }
}
