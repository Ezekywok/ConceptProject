package AlphaFiles;

import java.io.*;
import java.util.ArrayList;

public class SongAssignAlpha {
    private File file = new File("src/AlphaFiles/songstuff.txt");
    private BufferedReader br = new BufferedReader(new FileReader(file));
    private String title;
    private int songlength;
    private ArrayList<Notes> timings = new ArrayList<Notes>();


    //default constructor (throws IOException exception)
    public SongAssignAlpha() throws IOException {
        title = br.readLine();
        songlength = Integer.parseInt(br.readLine());
        int counter = 0, loc = -1;
        double times1 = -1, times2 = -1;
        String str;
        while ((str = br.readLine()) != null) {
            if (counter % 3 == 0) {
                loc = Integer.parseInt(str);
            }
            if (counter % 3 == 1) {
                times1 = Double.parseDouble(str);
            }
            if (counter % 3 == 2) {
                times2 = Double.parseDouble(str);
                timings.add(new Notes(loc, times1, times2));
            }
            counter++;
        }
    }

    //get methods
    public ArrayList<Notes> getTimings() {
        return timings;
    }

    public String toString() {
        String output = "title: " + title + "\nsonglength: " + songlength + "\n\n";
        output += timings.size()+"\n\n";
        for (Notes n : timings) {
            output += n.toString() + "\n\n";
        }
        return output;
    }
}
