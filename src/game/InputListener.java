package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class InputListener implements KeyListener {

    Map<Character, Boolean> keysPressed;

    public InputListener() {
        keysPressed = new HashMap<>();
        keysPressed.put('w', false);
        keysPressed.put('a', false);
        keysPressed.put('s', false);
        keysPressed.put('d', false);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_0)
            System.exit(0);

        keysPressed.put(e.getKeyChar(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keysPressed.put(e.getKeyChar(), false);
    }

    public HashMap<Character, Boolean> getKeyMap() {
        return (HashMap<Character, Boolean>) keysPressed;
    }
}
