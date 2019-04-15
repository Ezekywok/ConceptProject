package AlphaFiles;

import java.awt.*;
import java.io.IOException;

public class Hitzone extends SongAssignAlpha{
    private int[] hitzoneX;
    private int[] hitzoneY;//hitzone Y has too many variations smh :/
    private int hitzoneWidth;
    private int hitzoneHeight;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int WIDTH = screenSize.width;
    private int HEIGHT = screenSize.height;

    //colors of zones
    Color Zone300 = new Color(255, 255, 0, 50);
    Color Zone200 = new Color(0, 255, 0, 50);
    Color Zone100 = new Color(0, 0, 255, 50);
    Color ZoneMiss = new Color(255, 0, 0, 50);

    public Hitzone () throws IOException{
        hitzoneX = new int[]{
                (int) (WIDTH * .25),
                (int) (WIDTH * .25 + (int) (WIDTH * .05) + 5),
                (int) (WIDTH * .25 + (int) (WIDTH * .05) * 2 + 10),
                (int) (WIDTH * .25 + (int) (WIDTH * .05) * 3 + 15)
        };
        int Yconstant = (int) (HEIGHT * .80);
        hitzoneY = new int[]{
                Yconstant - (int) (HEIGHT * .03125),
                Yconstant - (int) (HEIGHT * .0625),
                Yconstant,
                Yconstant - (int) (HEIGHT * .09375),
                Yconstant + (int) (HEIGHT * .03125),
                Yconstant - (int) (HEIGHT * .125)
        };
        hitzoneWidth = (int) (WIDTH * .05);
        hitzoneHeight = (int) (HEIGHT * .03125);
    }

    public void drawSelf(Graphics g){
        for(int i = 0;i<hitzoneX.length;i++){
            //zone for a 300
            g.setColor(Zone300);
            g.fillRect(hitzoneX[i], hitzoneY[0] , hitzoneWidth, hitzoneHeight);

            //zone for a 200
            g.setColor(Zone200);
            g.fillRect(hitzoneX[i], hitzoneY[1] , hitzoneWidth, hitzoneHeight);
            g.fillRect(hitzoneX[i], hitzoneY[2], hitzoneWidth, hitzoneHeight);

            //zone for a 100
            g.setColor(Zone100);
            g.fillRect(hitzoneX[i], hitzoneY[3], hitzoneWidth, hitzoneHeight);
            g.fillRect(hitzoneX[i], hitzoneY[4], hitzoneWidth, hitzoneHeight);

            //zone for a miss
            g.setColor(ZoneMiss);
            g.fillRect(hitzoneX[i], hitzoneY[5], hitzoneWidth, hitzoneHeight);
            //if it goes off the screen then miss dat boi
        }
    }

    public void setAlpha(int alpha){
        Zone300 = new Color(255, 255, 0, alpha);
        Zone200 = new Color(0, 255, 0, alpha);
        Zone100 = new Color(0, 0, 255, alpha);
        ZoneMiss = new Color(255, 0, 0, alpha);
    }

    public boolean inside300(int yCoord){
        return yCoord >= hitzoneY[0] && yCoord <= hitzoneY[0]+hitzoneHeight;
    }

    public boolean inside200(int yCoord){
        return (yCoord >= hitzoneY[1] && yCoord <= hitzoneY[1]+hitzoneHeight) || (yCoord >= hitzoneY[2] && yCoord <= hitzoneY[2]+hitzoneHeight);
    }

    public boolean inside100(int yCoord){
        return (yCoord >= hitzoneY[3] && yCoord <= hitzoneY[3]+hitzoneHeight) || (yCoord >= hitzoneY[4] && yCoord <= hitzoneY[4]+hitzoneHeight);
    }

    public boolean insideMiss(int yCoord){
        return (yCoord >= hitzoneY[5] && yCoord <= hitzoneY[5]+hitzoneHeight) || (yCoord > hitzoneY[4]+hitzoneHeight);
    }

    public int NoteRemove (int refZone){
        for(int i = 0;i<getTimings().size();i++){
            if(getNote(i).getLocation() == refZone){
                int bottomYCoord = getNote(i).getBottomCoord();
                System.out.println("Bottom Coord:" + bottomYCoord);
                if(inside300(bottomYCoord)){
                    return 300;
                }else if(inside200(bottomYCoord)){
                    return 200;
                }else if(inside100(bottomYCoord)){
                    return 100;
                }else
                    return 0;
            }
            break;
        }
        return -1;
    }
}
