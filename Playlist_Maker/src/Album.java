import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String albumName;
    private String artist;
    //private ArrayList<Album> albums;
    private ArrayList<Song> songs;

    public Album(String albumName, String artist) {
        this.albumName = albumName;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getArtist() {
        return artist;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public boolean addSong(String title, int minsLength, int secsLength) {
        if (findSong(title) == null) {
            this.songs.add(new Song(title, minsLength, secsLength));
            return true;
        }
        return false;
    }

    private Song findSong(String title) {

        for (Song checkedSong : this.songs) {
            if (checkedSong.getTitle().equals(title)) {
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber - 1;
        if (index >= 0 && index <= this.songs.size()) {
            playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track number " + trackNumber);
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playlist) {
        Song checkedSong = findSong(title);
        if (checkedSong != null) {
            playlist.add(checkedSong);
            return true;
        }

        System.out.println("'" + title + "'" + " is not on this album.");
        return false;
    }

}
