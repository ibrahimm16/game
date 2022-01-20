package game;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Player {

    Map<Character, Boolean> keyMap;
    float x = 20, y = 20;
    float speed = .33f;

    public Player(InputListener inputListener) {
        keyMap = inputListener.getKeyMap();
    }

    public void update() {
        for (Character key : keyMap.keySet()) {
            if (keyMap.get(key))
                switch (key) {
                    case 'w' -> {
                        y -= speed;
                    }
                    case 'a' -> {
                        x -= speed;
                    }
                    case 's' -> {
                        y += speed;
                    }
                    case 'd' -> {
                        x += speed;
                    }
                }
        }
    }

    public Point getLocation() {
        return new Point((int) x, (int) y);
    }
}
