package flyweight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class DocumentTest {
    private Document document;

    @BeforeEach
    public void setupDocument() {
        document = new DocumentBuilder("Color", "Font", 10)
                .appendCharacter('a')
                .appendCharacter('b')
                .appendCharacter('c')
                .build();
    }

    @Test
    public void canCreateDocumentFromBuilder() {
        assertNotNull(document);
    }

    @Test
    public void canSaveDocument() throws IOException {
        document.saveToFile("testfile.doc");
        File file = new File("testfile.doc");
        assertTrue(file.exists());
        file.delete();
    }

    @Test
    public void canLoadDocument() throws IOException {
        document.saveToFile("testfile.doc");
        Document newDocument = new Document("testfile.doc");
        assertEquals(document.toString(), newDocument.toString());
        new File("testfile.doc").delete();
    }

    @Test
    public void canGetToStringOfDocument() {
        assertEquals("Color:Font:10:a\n" +
                "Color:Font:10:b\n" +
                "Color:Font:10:c",
                document.toString());
    }
}
