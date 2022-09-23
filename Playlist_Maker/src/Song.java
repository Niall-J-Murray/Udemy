public class Song {

    private String title;
    private int minsLength;
    private int secLength;

    public Song(String title, int minsLength, int secLength) {
        this.title = title;
        this.minsLength = minsLength;
        this.secLength = secLength;
    }

    public String getTitle() {
        return title;
    }

    public int getMinsLength() {
        return minsLength;
    }

    public int getSecLength() {
        return secLength;
    }

    @Override
    public String toString() {
        if (secLength < 10) {
            return this.title + " - " + minsLength + ":0" + secLength;
        } else {
            return this.title + " - " + minsLength + ":" + secLength;
        }
    }

//    private static String durationFormatter(int durationInSecs){
//        int mins=durationInSecs/60;
//        int remainingSecs = durationInSecs%60;
//
//        return (mins +":"+remainingSecs);
//    }

}
