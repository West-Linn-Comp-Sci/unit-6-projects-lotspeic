import java.util.function.Function;

public class MusicLibrary {

    private Album[] albums;

    public MusicLibrary() {
        albums = new Album[10];
    }

    public void add(Album album) {
        for(int i = 0; i < albums.length; i++) {
            if(albums[i] != null) continue;
            albums[i] = album;
            return;
        }
    }

    public void doubleSize() {
        int length = albums.length;
        Album[] newAlbums = new Album[length * 2];
        for(int i = 0; i < length; i++) {
            newAlbums[i] = albums[i];
        }
        albums = newAlbums;
    }


    public void remove(int index) {
        for(int i = index - 1; i < albums.length - 1; i++) {
            albums[i] = albums[i + 1];
        }
        albums[albums.length - 1] = null;
    }

    public String toString() {
        String out = "Current Library\n<------------->\n";
        int tracks = 0;
        double playtime = 0;
        for(int i = 0; i < albums.length; i++) {
            Album album = albums[i];
            if(album == null) {
                out += (i + 1) + ": Empty.\n";
                continue;
            }
            tracks += album.getNumTracks();
            playtime += album.getPlayTime();
            out += String.format("%s: %s\n", (i + 1), album);
        }
        out += "<------------->\nSummary Statistics:\n";
        out += String.format("Total Tracks: %s.\nTotal Playtime: %s minutes.", tracks, playtime);
        return out;
    }

    public Album getFromTitleLinear(String title) {
        for(Album album : albums) {
            if(album == null) continue;
            if(album.getName().equals(title)) return album;
        }
        return null;
    }

    public Album getFromArtistLinear(String artist) {
        for(Album album : albums) {
            if(album == null) continue;
            if(album.getArtist().equals(artist)) return album;
        }
        return null;
    }

    public Album getFromTitleBinary(String title) {
        sortByTitle();
        return getFromBinarySearch((album) -> album.getName(), title);
    }

    public Album getFromArtistBinary(String artist) {
        sortByArtist();
        return getFromBinarySearch((album) -> album.getArtist(), artist);
    }

    private Album getFromBinarySearch(Function<Album, String> getKeyVal, String target) {
        int length = 0;
        for(Album album : albums) if(album != null) length++;
        int low = 0;
        int high = length - 1;
        int middle = (low + high) / 2;

        while(!(getKeyVal.apply(albums[middle]).equals(target)) && low <= high) {
            if(target.compareTo(getKeyVal.apply(albums[middle])) < 0) high = middle - 1;
            else low = middle + 1;
            middle = (low + high) / 2;
        }

        if(getKeyVal.apply(albums[middle]).equals(target)) return albums[middle];
        return null;
    }

    private void sortByTitle() {
        int length = 0;
        for(Album album : albums) if(album != null) length++;
        for(int i = 0; i < length - 1; i++) {
            int min = i;
            for(int scan = i + 1; scan < length; scan++) {
                if(albums[scan] == null) continue;
                if(albums[scan].getName().compareTo(albums[min].getName()) < 0) min = scan;
            }

            Album temp = albums[min];
            albums[min] = albums[i];
            albums[i] = temp;
        }
    }

    private void sortByArtist() {
        int length = 0;
        for(Album album : albums) if(album != null) length++;
        for(int i = 1; i < length; i++) {
            Album key = albums[i];
            int position = i;

            while(position > 0 && (albums[position - 1].getArtist().compareTo(key.getArtist()) > 0)) {
                if(albums[position] == null) continue;
                albums[position] = albums[position - 1];
                position--;
            }
            albums[position] = key;
        }
    }

}
