package proxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class SongServiceTest {
    private SongService songService;

    public SongServiceTest(SongService songService) {
        this.songService = songService;
    }

    @Parameters
    public static Iterable<Object[]> parameters() {
        return Arrays.asList(new Object[][] {
                { new SongProxy() },
                { new SongServer() }
        });
    }

    @Test
    public void canSearchById() {
        assertEquals(new Song("title 1", "artist 1", "album 1", 120), songService.searchById(0))    ;
    }

    @Test
    public void canSearchByTitle() {
        List<Song> songs = songService.searchByTitle("title 1");
        assertEquals(1, songs.size());
        assertEquals(new Song("title 1", "artist 1", "album 1", 120), songs.get(0));
    }

    @Test
    public void canSearchByAlbum() {
        List<Song> songs = songService.searchByAlbum("album 1");
        assertEquals(2, songs.size());
        assertEquals(new Song("title 1", "artist 1", "album 1", 120), songs.get(0));
        assertEquals(new Song("title 2", "artist 1", "album 1", 150), songs.get(1));
    }
}
