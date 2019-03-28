package AlphaFiles;

import java.io.IOException;
import java.util.ArrayList;

public class MainDriver {
    public static void main(String[]args){
        SongAssignAlpha song1;
        {
            try {
                song1 = new SongAssignAlpha();
                System.out.println(song1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
