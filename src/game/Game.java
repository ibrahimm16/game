package game;

import game.display.Display;

import java.awt.*;

public class Game {

    boolean running;
    Display display;
    InputListener inputListener;
    Player player;

    private Game() {}

    private void init() {
        running = true;
        display = new Display();
        inputListener = new InputListener();
        display.addListeners(inputListener);
        player = new Player(inputListener);

        loop();
    }

    private void update() {
        player.update();
        render();
    }

    private void render() {
        Graphics2D g = display.render();
        if (g != null) {
            player.render(g);
            display.show();
        }
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
