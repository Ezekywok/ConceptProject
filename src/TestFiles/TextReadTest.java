package TestFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TextReadTest {

    public static void main(String[] args) throws Exception {
        final String fileName = "src/TestFiles/songs notes and timings-test.txt";

        File file = new File(fileName);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st = br.readLine();

        System.out.println(st);

        st = br.readLine();

        System.out.println(st);
    }
}
