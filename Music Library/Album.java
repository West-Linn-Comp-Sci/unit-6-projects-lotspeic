public class Album {

    private final String name;
    private final String artist;
    private final int numTracks;
    private final double playTime;

    public Album(String name, String artist, int numTracks, double playTime) {
        this.name = name;
        this.artist = artist;
        this.numTracks = numTracks;
        this.playTime = playTime;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public int getNumTracks() {
        return numTracks;
    }

    public double getPlayTime() {
        return playTime;
    }

    public String toString() {
        return String.format("%s - %s | %s tracks, %s minutes.", artist, name, numTracks, playTime);
    }
}
