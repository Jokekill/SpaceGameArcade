package Display;

import javax.swing.*;
import java.awt.*;

public class Display {
    private JFrame fr;

    public Canvas getCanvas() {
        return canvas;
    }

    private Canvas canvas;
    private String title;
    private int width,height;

    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        createDisplay();
    }

    private void createDisplay(){
        fr = new JFrame(title);
        fr.setSize(width,height);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setResizable(false);
        fr.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        fr.add(canvas);
        fr.pack();
    }
}
