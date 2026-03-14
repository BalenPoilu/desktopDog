package balenPoilu.events;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;
import balenPoilu.win.WinLoader;

public class Running {

    public Running(WinLoader win) {
        Runnable task = new Runnable() {
            public void run() {
                Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
                int screenW = screen.width;
                int screenH = screen.height;
                int pW = win.getWidth();
                int pH = win.getHeight();

                Random rand = new Random();

                while (true) {
                    int targetX = rand.nextInt(screenW - pW);
                    int targetY = rand.nextInt(screenH - pH);
                    int currentX = win.getX();
                    int currentY = win.getY();
                    int steps = 100; 

                    for (int i = 0; i < steps; i++) {
                        int nextX = currentX + (targetX - currentX) * i / steps;
                        int nextY = currentY + (targetY - currentY) * i / steps;

                        win.setLocation(nextX, nextY);

                        try {
                            Thread.sleep(20); 
                        } catch (InterruptedException e) {
                            return;
                        }
                    }
                    try {
                        Thread.sleep(rand.nextInt(2000) + 500);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            }
        };

        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
    }
}