package game;

import game.display.Display;

public class Game {

    boolean running;
    Display display;

    private Game() {}

    private void init() {
        running = true;
        display = new Display();

        loop();
    }

    private void update() {
        display.render();
    }

    private void loop() {
        double timePerTick = Constants.TICK_RATE;
        double delta = 0.0;
        long now;
        long lastTime = System.currentTimeMillis();

        while (running) {
            now = System.currentTimeMillis();
            delta += (now - lastTime) / timePerTick;
            lastTime = now;
            if (delta >= 1) {
                delta--;
                update();
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.init();
    }
}
