package game.display;

import game.InputListener;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

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

    public void addListeners(InputListener listener) {
        frame.addKeyListener(listener);
    }

    public Graphics2D render() {
        return renderer.render();
    }

    public void show() {
        renderer.show();
    }

    private class Renderer {
        Graphics2D g;
        BufferStrategy bufferStrategy;

        Renderer() {
        }

        Graphics2D render() {
            bufferStrategy = canvas.getBufferStrategy();
            if (bufferStrategy == null) {
                canvas.createBufferStrategy(3);
                return null;
            }

            g = (Graphics2D) bufferStrategy.getDrawGraphics();
            g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            g.setColor(Color.black);
            g.fillRect(0, 0, 1280, 720);

            return g;
        }

        void show() {
//            bufferStrategy = canvas.getBufferStrategy();
//            if (bufferStrategy == null) {
//                canvas.createBufferStrategy(3);
//                return;
//            }
//
//            g = (Graphics2D) bufferStrategy.getDrawGraphics();
//            g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
//
//            g.setColor(Color.black);
//            g.fillRect(0, 0, 1280, 720);
//
//            player.render(g);

            bufferStrategy.show();
            g.dispose();
        }
    }
}
