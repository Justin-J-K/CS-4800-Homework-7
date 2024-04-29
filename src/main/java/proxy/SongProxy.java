package proxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongProxy implements SongService {
    private SongServer songServer = new SongServer();
    private Map<Integer, Song> songsById = new HashMap<>();
    private Map<String, List<Song>> songsByTitle = new HashMap<>();
    private Map<String, List<Song>> songsByAlbum = new HashMap<>();

    @Override
    public Song searchById(int songID) {
        Song song = songsById.get(songID);

        if (song == null) {
            song = songServer.searchById(songID);
            songsById.put(songID, song);
        }

        return song;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        List<Song> song = songsByTitle.get(title);

        if (song == null) {
            song = songServer.searchByTitle(title);
            songsByTitle.put(title, song);
        }

        return song;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        List<Song> song = songsByAlbum.get(album);

        if (song == null) {
            song = songServer.searchByAlbum(album);
            songsByAlbum.put(album, song);
        }

        return song;
    }
}
