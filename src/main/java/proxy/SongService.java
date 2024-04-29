package proxy;

import java.util.List;

public interface SongService {
    Song searchById(int songID);
    List<Song> searchByTitle(String title);
    List<Song> searchByAlbum(String album);
}
