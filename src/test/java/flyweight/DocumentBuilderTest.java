package flyweight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DocumentBuilderTest {
    private DocumentBuilder builder;

    @BeforeEach
    public void setupDocumentBuilder() {
        builder = new DocumentBuilder("Color", "Font", 10);
    }

    @Test
    public void canAppendText() {
        builder.appendText("ab");
        assertEquals("Color:Font:10:a\n" +
                "Color:Font:10:b",
                builder.build().toString());
    }

    @Test
    public void canAppendCharacter() {
        builder.appendCharacter('a');
        assertEquals("Color:Font:10:a", builder.build().toString());
    }

    @Test
    public void canSetCurrentColorName() {
        builder.setCurrentColorName("Color 2")
                .appendCharacter('a');
        assertEquals("Color 2:Font:10:a", builder.build().toString());
    }

    @Test
    public void canSetCurrentFontName() {
        builder.setCurrentFontName("Font 2")
                .appendCharacter('a');
        assertEquals("Color:Font 2:10:a", builder.build().toString());
    }

    @Test
    public void canSetCurrentSizeInPixels() {
        builder.setCurrentSizeInPixels(1)
                .appendCharacter('a');
        assertEquals("Color:Font:1:a", builder.build().toString());
    }
}
