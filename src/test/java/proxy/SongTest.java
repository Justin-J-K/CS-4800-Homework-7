package proxy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SongTest {
    private static Song song = new Song("Title", "Artist", "Album", 10);

    @Test
    public void canGetTitle() {
        assertEquals("Title", song.getTitle());
    }

    @Test
    public void canGetAlbum() {
        assertEquals("Album", song.getAlbum());
    }

    @Test
    public void canGetArtist() {
        assertEquals("Artist", song.getArtist());
    }

    @Test
    public void canGetDuration() {
        assertEquals(10, song.getDurationInSeconds());
    }

    @Test
    public void canGetToStringOfSong() {
        assertEquals("Title by Artist in Album is 10 seconds", song.toString());
    }

    @Test
    public void canSongsBeEqual() {
        assertTrue(song.equals(new Song("Title", "Artist", "Album", 10)));
    }
}
