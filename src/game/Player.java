package game;

import java.awt.*;
import java.util.HashMap;

public class Player {

    HashMap<Character, Boolean> keyMap;
    float x = 20, y = 20;
    float speed = 1f;
    Color color;

    public Player(InputListener inputListener) {
        keyMap = inputListener.getKeyMap();
        int r = (int) (Math.random() * 256.0);
        int g = (int) (Math.random() * 256.0);
        int b = (int) (Math.random() * 256.0);
        color = new Color(r, g, b);
    }

    public void update() {
        move();
    }

    public void render(Graphics2D g) {
        g.setColor(color);
        g.fillRect((int) x, (int) y, 20, 20);
    }

    void move() {
        for (Character key : keyMap.keySet()) {
            if (keyMap.get(key)) {
                switch (key) {
                    case 'w' -> y -= speed;
                    case 'a' -> x -= speed;
                    case 's' -> y += speed;
                    case 'd' -> x += speed;
                }
            }
        }
    }
}
