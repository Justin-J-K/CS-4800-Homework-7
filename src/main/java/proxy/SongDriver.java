package proxy;

import java.util.List;

public class SongDriver {
    public static void main(String[] args) {
        SongService songService = new SongProxy();

        System.out.println("Search by ID 0");
        printQuery(songService.searchById(0));
        System.out.println("Search by ID 0 Again");
        printQuery(songService.searchById(0));

        System.out.println();

        System.out.println("Search by Album 1");
        printQuery(songService.searchByAlbum("album 1"));
        System.out.println("Search by Album 1 Again");
        printQuery(songService.searchByAlbum("album 1"));

        System.out.println();

        System.out.println("Search by Title 6");
        printQuery(songService.searchByTitle("title 6"));
        System.out.println("Search by Title 6 Again");
        printQuery(songService.searchByTitle("title 6"));

        System.out.println();

        System.out.println("Search by ID 5");
        printQuery(songService.searchById(5));
        System.out.println("Search by ID 5 Again");
        printQuery(songService.searchById(5));

        System.out.println();

        System.out.println("Search by Album 4");
        printQuery(songService.searchByAlbum("album 4"));
        System.out.println("Search by Album 4 Again");
        printQuery(songService.searchByAlbum("album 4"));

        System.out.println();

        System.out.println("Search by Title 7");
        printQuery(songService.searchByTitle("title 7"));
        System.out.println("Search by Title 7 Again");
        printQuery(songService.searchByTitle("title 7"));
    }

    private static void printQuery(Song song) {
        System.out.println("Query Result: " + song);
    }

    private static void printQuery(List<Song> songs) {
        System.out.println("Query Results: " + songs);
    }
}
