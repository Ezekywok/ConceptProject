package AlphaFiles;

public class Notes {
    private String tag;
    private int location;
    private double sig1, sig2;

    public Notes() {
        tag = "hitnote";
        location = -1;
        sig1 = -1;
        sig2 = -1;
    }

    public Notes(int loc, double times1, double times2) {
        if (times1 == times2) {
            tag = "hitnote";
        } else {
            tag = "slider";
        }
        location = loc;
        sig1 = times1;
        sig2 = times2;
    }

    public String toString() {
        return "tag: " + tag + "\nlocation: " + location +"\nsig1: " + sig1 + "\nsig2: " + sig2;
    }
}
