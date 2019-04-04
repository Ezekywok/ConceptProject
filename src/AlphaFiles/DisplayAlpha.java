package AlphaFiles;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class DisplayAlpha extends JComponent implements KeyListener, MouseListener, MouseMotionListener {
    //instance variables
    private final int ticks = 60;

    private int WIDTH;
    private int HEIGHT;

    private boolean[] keyPress = new boolean[4];

    private int[] hitzoneX;
    Hitzone hitzones = new Hitzone();

    private SongAssignAlpha notes = new SongAssignAlpha();

    //delete this later (test global vars)
    int[] x, y, width, height;

    private int currentRuntime = 0;

    //Default Constructor
    public DisplayAlpha() throws IOException {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //initializing instance variables
        WIDTH = screenSize.width;
        HEIGHT = screenSize.height;

        //Setting up the GUI
        JFrame gui = new JFrame(); //This makes the gui box
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Makes sure program can close
        gui.setTitle("force boot srry"); //This is the title of the game, you can change it
        gui.setPreferredSize(new Dimension(WIDTH, HEIGHT)); //Setting the size for gui
        gui.setResizable(false); //Makes it so the gui cant be resized
        gui.getContentPane().add(this); //Adding this class to the gui
        gui.setUndecorated(true);
        /*If after you finish everything, you can declare your buttons or other things
         *at this spot. AFTER gui.getContentPane().add(this) and BEFORE gui.pack();
         */
        gui.pack(); //Packs everything together
        gui.setLocationRelativeTo(null); //Makes so the gui opens in the center of screen
        gui.setVisible(true); //Makes the gui visible
        gui.addKeyListener(this);//stating that this object will listen to the keyboard
        gui.addMouseListener(this);//stating that this object will listen to the Mouse
        gui.addMouseMotionListener(this);//stating that this object will acknowledge when the Mouse moves

    }

    //This method will acknowledge user input
    public void keyPressed(KeyEvent e) {
        //getting the key pressed
        //moving the rectangle
        int key = e.getKeyCode();
        if (key == 68) { //d
            keyPress[0] = true;
        }
        if (key == 70) { //f
            keyPress[1] = true;
        }
        if (key == 74) { //j
            keyPress[2] = true;
        }
        if (key == 75) { //k
            keyPress[3] = true;
        }

    }

    //All your UI drawing goes in here
    public void paintComponent(Graphics g) {
        for (int i = 0; i < notes.noteArraySize(); i++) {
            if (notes.getNote(i).getY() - notes.getNote(i).getHeight() <= HEIGHT) {
                notes.getNote(i).drawSelf(g);
            }
        }
        Font timeFont = new Font("Comic Sans MS", Font.PLAIN, 20);
        g.setFont(timeFont);
        g.setColor(Color.BLACK);
        g.drawString("" + (currentRuntime), 5, (int) (HEIGHT * .95));

        hitzoneX = new int[]{
                (int) (WIDTH * .25),
                (int) (WIDTH * .25 + (int) (WIDTH * .05) + 5),
                (int) (WIDTH * .25 + (int) (WIDTH * .05) * 2 + 10),
                (int) (WIDTH * .25 + (int) (WIDTH * .05) * 3 + 15)
        };

        //area where you hit notes
        for (int i = 0; i < hitzoneX.length; i++) {
            g.setColor(Color.CYAN);
            g.drawRect(hitzoneX[i], (int) (HEIGHT * .80), (int) (WIDTH * .05), (int) (HEIGHT * .125));

            if (keyPress[i]) {
                g.setColor(new Color(0, 255, 255, 130));
            } else {
                g.setColor(new Color(0, 255, 255, 50));
            }

            g.fillRect(hitzoneX[i], (int) (HEIGHT * .80), (int) (WIDTH * .05), (int) (HEIGHT * .125));
        }

        hitzones.setAlpha(0);//comment this out to make it visible again
        hitzones.drawSelf(g);

    }


    public void loop() {
        //making the autonomous circle move
        //handling when the circle collides with the edges
        //handling the collision of the circle with the rectangle
        //Do not write below this
        for (int i = 0; i < notes.noteArraySize(); i++) {
            notes.getNote(i).scrollNote();
        }
        currentRuntime = currentRuntime + 1000 / 60;
        repaint();
    }

    //These methods are required by the compiler.
    //You might write code in these methods depending on your goal.
    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == 68) {
            keyPress[0] = false;
        }
        if (key == 70) {
            keyPress[1] = false;
        }
        if (key == 74) {
            keyPress[2] = false;
        }
        if (key == 75) {
            keyPress[3] = false;
        }

    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void start() {
        Thread gameThread = new Thread() {
            public void run() {
                while (true) {
                    loop();
                    try {
                        Thread.sleep(1000 / ticks);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        gameThread.start();
    }

    public static void main(String[] args) throws java.io.IOException {
        DisplayAlpha g = new DisplayAlpha();
        g.start();
    }
}
