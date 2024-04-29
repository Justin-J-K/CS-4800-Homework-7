package proxy;

import java.util.ArrayList;
import java.util.List;

public class SongServer implements SongService {
    private static final Song[] SONGS = {
            new Song("title 1", "artist 1", "album 1", 120),
            new Song("title 2", "artist 1", "album 1", 150),
            new Song("title 3", "artist 1", "album 2", 60),
            new Song("title 4", "artist 2", "album 3", 70),
            new Song("title 5", "artist 2", "album 4", 200),
            new Song("title 6", "artist 3", "album 5", 203),
            new Song("title 7", "artist 4", "album 6", 120)
    };

    @Override
    public Song searchById(int songID) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}

        if (songID >= 0 && songID < SONGS.length) {
            return SONGS[songID];
        }

        return null;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}

        List<Song> songs = new ArrayList<>();
        for (Song song : SONGS) {
            if (song.getTitle().equals(title)) {
                songs.add(song);
            }
        }

        return songs;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}

        List<Song> songs = new ArrayList<>();
        for (Song song : SONGS) {
            if (song.getAlbum().equals(album)) {
                songs.add(song);
            }
        }

        return songs;
    }
}
