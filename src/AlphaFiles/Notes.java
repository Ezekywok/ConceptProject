package AlphaFiles;

import java.awt.*;

public class Notes {
    private String tag;
    private int location;
    private double sig1, sig2;

    private int x, y, width, height;

    public Notes() {
        tag = "hitnote";
        location = -1;
        sig1 = -1;
        sig2 = -1;
    }

    public Notes(int loc, double times1, double times2) {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = screen.height;
        int noteLen = 0;
        if (times1 == times2) {
            tag = "hitnote";
            noteLen = 1;
        } else {
            tag = "slider";
            noteLen = (int)(times2-times1);
        }
        location = loc; //possibly deprecated
        sig1 = times1;
        sig2 = times2;

        if (loc == 0) {
            x = (int) (screen.width * .25);
        } else if (loc == 1) {
            x = (int) (screen.width * .25 + (screen.width * .05) + 5);
        } else if (loc == 2) {
            x = (int) (screen.width * .25 + (screen.width * .05) * 2 + 5);
        } else if (loc == 3) {
            x = (int) (screen.width * .25 + (screen.width * .05) * 3 + 5);
        }else
            x = 0;

        y = -(int) (noteLen * 60 + screenHeight);//multiply by scrollSpeed in DisplayAlpha

        width = (int) (screen.width * .05);
        height = (int) ( noteLen * 60 + screenHeight);//multiply by scrollSpeed in DisplayAlpha
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
        g.fillRect(x, y, width, height);
    }

    public void scrollNote(){
        y = y+4;
    }
    public String toString() {
        return "tag: " + tag + "\nlocation: " + location + "\nsig1: " + sig1 + "\nsig2: " + sig2;
    }
}
