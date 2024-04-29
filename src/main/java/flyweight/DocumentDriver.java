package flyweight;

import java.io.File;
import java.io.IOException;

public class DocumentDriver {
    public static void main(String[] args) {
        DocumentBuilder builder = new DocumentBuilder("Black", "Arial", 12);
        Document document = builder.appendText("Hello")
                .setCurrentColorName("Blue")
                .setCurrentSizeInPixels(24)
                .appendText("World")
                .setCurrentFontName("Times New Roman")
                .setCurrentColorName("Orange")
                .appendText("CS")
                .setCurrentSizeInPixels(6)
                .setCurrentFontName("Courier")
                .appendText("5800")
                .build();

        System.out.println(document.toString() + "\n");

        try {
            document.saveToFile("document.doc");
            System.out.println("Saved document to document.doc");
        } catch (IOException e) {
            System.err.println("Could not save file: " + e.getMessage());
        }

        System.out.println();

        try {
            Document loadedFile = new Document("document.doc");
            System.out.println("Loaded document from document.doc\n");
            System.out.println(loadedFile);

            new File("document.doc").delete();
        } catch (IOException e) {
            System.err.println("Could not load file: " + e.getMessage());
        }

    }
}
