package balenPoilu;

import java.awt.Point;

import balenPoilu.events.Running;
import balenPoilu.win.WinLoader;

public class Main {
    
    public static void main(String[] args) {
        
        WinLoader win = new WinLoader("a", true);
        WinLoader win2 = new WinLoader("b", false);
        win2.setLocation(new Point(400,400));

        
        new Running(win);

    }

}
