package proxy;

public class Song {
    private String title;
    private String artist;
    private String album;
    private int durationInSeconds;

    public Song(String title, String artist, String album, int durationInSeconds) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.durationInSeconds = durationInSeconds;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    @Override
    public String toString() {
        return String.format("%s by %s in %s is %d seconds",
                title,
                artist,
                album,
                durationInSeconds
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Song other)) {
            return false;
        }

        return title.equals(other.title) && artist.equals(other.artist)
                && album.equals(other.album) && durationInSeconds == other.durationInSeconds;
    }
}
