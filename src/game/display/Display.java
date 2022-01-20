package game.display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.EventListener;

public class Display {

    private final JFrame frame;
    private final Canvas canvas;
    private final Renderer renderer;

    public Display() {
        Dimension dimension = new Dimension(1280, 720);
        canvas = new Canvas();
        canvas.setSize(dimension);
        canvas.setFocusable(false);

        frame = new JFrame();
        frame.setSize(dimension);
        frame.add(canvas);
        frame.setLocation(300, 100);
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        renderer = new Renderer();
    }

    public void addListeners(EventListener listener) {
        frame.addKeyListener((KeyListener) listener);
    }

    public void render() {
        renderer.render(canvas);
    }

    private static class Renderer {
        Graphics2D g;
        BufferStrategy bufferStrategy;

        Renderer() {
        }

        void render(Canvas canvas) {
            bufferStrategy = canvas.getBufferStrategy();
            if (bufferStrategy == null) {
                canvas.createBufferStrategy(3);
                return;
            }

            g = (Graphics2D) bufferStrategy.getDrawGraphics();
            g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

            g.setColor(Color.black);
            g.fillRect(0, 0, 1280, 720);


            g.setColor(Color.green);
            g.fillRect(200, 200, 32, 32);

            bufferStrategy.show();
            g.dispose();
        }
    }
}
