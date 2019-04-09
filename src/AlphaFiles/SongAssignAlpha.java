package AlphaFiles;

import java.io.*;
import java.util.ArrayList;

public class SongAssignAlpha {
    private File file = new File("src/AlphaFiles/songstuff.txt");
    private BufferedReader br = new BufferedReader(new FileReader(file));
    private String title;
    private int songLength;
    private int scrollingSpeed;
    private ArrayList<Notes> timings = new ArrayList<>();


    //default constructor (throws IOException exception)
    public SongAssignAlpha() throws IOException {
        title = br.readLine();
        songLength = Integer.parseInt(br.readLine());
        scrollingSpeed = Integer.parseInt(br.readLine());
        br.readLine();
        int counter = 0, loc = -1;
        double times1 = -1, times2 = -1;
        String str;
        while ((str = br.readLine()) != null) {
            if (counter % 4 == 0) {
                loc = Integer.parseInt(str);
            }
            if (counter % 4 == 1) {
                times1 = Double.parseDouble(str);
            }
            if (counter % 4 == 2) {
                times2 = Double.parseDouble(str);
                timings.add(new Notes(loc, times1, times2));
            }
            if (counter % 4 == 3) {
                //do nothing, supposed to be an empty line
            }
            counter++;
        }
    }

    //special methods
    public void begoneThot(Notes note){
        timings.remove(note);
    }

    //get methods
    public ArrayList<Notes> getTimings() {
        return timings;
    }

    public int noteArraySize() {
        return timings.size();
    }

    public Notes getNote(int ref) {
        return timings.get(ref);
    }

    public String toString() {
        String output = "title: " + title + "\nsongLength: " + songLength + "\nscrollingSpeed: " + scrollingSpeed + "\n\n";
        output += timings.size() + "\n\n";
        for (Notes n : timings) {
            output += n.toString() + "\n\n";
        }
        return output;
    }
}
