package balenPoilu.win;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRootPane;

public class WinLoader extends JFrame {

    private String id;

    public WinLoader(String id, boolean bool){
        this.id = id;
        
        if (bool) {
            this.setAlwaysOnTop(true);
            this.add(new JLabel(new ImageIcon("./res/doctor.gif")));
            this.setUndecorated(true);
            this.pack();
            this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            this.setBackground(new Color(0,0,0,0));
            this.getContentPane().setBackground(new Color(0,0,0,0));
            this.setVisible(true);            
        } else {
            this.setAlwaysOnTop(true);
            this.add(new JLabel(new ImageIcon("./res/walkBoard")));
            this.setVisible(true);

        }

        
    }

    public String getId(){
        return this.id;
    }

}
