package AlphaFiles;

import java.awt.*;

public class Notes {
    private String tag;
    private int location;
    private double sig1, sig2;

    private int x, y, width, height;

    private int scrollSpeed = 4;

    public Notes() {
        tag = "hitnote";
        location = -1;
        sig1 = -1;
        sig2 = -1;
    }

    public Notes(int loc, double times1, double times2) {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = screen.height;
        double noteLen = 0;
        if (times1 == times2) {
            tag = "hitnote";
            noteLen = 0.1;
        } else {
            tag = "slider";
            noteLen = times2 - times1;
        }
        location = loc; //possibly deprecated
        sig1 = times1; //possibly deprecated
        sig2 = times2; //possibly deprecated

        if (loc == 0) {
            x = (int) (screen.width * .25);
        } else if (loc == 1) {
            x = (int) (screen.width * .25 + (int)(screen.width * .05) + 5);
        } else if (loc == 2) {
            x = (int) (screen.width * .25 + (int)(screen.width * .05) * 2 + 10);
        } else if (loc == 3) {
            x = (int) (screen.width * .25 + (int)(screen.width * .05) * 3 + 15);
        } else
            x = 0;

        y = -(int) (times1 * 60) - (2 * scrollSpeed * 60);

        width = (int) (screen.width * .05);
        height = (int) (noteLen * scrollSpeed * 60);
    }

    public void drawSelf(Graphics g) {
        if (location == 0) {
            g.setColor(Color.RED);
        } else if (location == 1) {
            g.setColor(Color.ORANGE);
        } else if (location == 2) {
            g.setColor(Color.YELLOW);
        } else if (location == 3) {
            g.setColor(Color.GREEN);
        }
        g.fillRect(x, y-height, width, height);
    }

    public void scrollNote() {
        y = y + scrollSpeed;
    }

    public int getY(){
        return y;
    }

    public int getHeight(){
        return height;
    }

    public String toString() {
        return "tag: " + tag + "\nlocation: " + location + "\nsig1: " + sig1 + "\nsig2: " + sig2;
    }
}
