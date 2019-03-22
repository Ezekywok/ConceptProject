package AlphaFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
public class SongAssignAlpha {
    private File file = new File("src/AlphaFiles/songstuff.txt");
    private BufferedReader br = new BufferedReader(new FileReader(file));
    private String title;
    private int songlength;
    private ArrayList<Double> timings;


    //default constructor (throws FileReader exception)
    public SongAssignAlpha() throws FileNotFoundException {
        title = br.readLine();
    }

}
