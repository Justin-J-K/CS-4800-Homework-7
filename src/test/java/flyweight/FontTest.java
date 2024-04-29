package flyweight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FontTest {
    @Test
    public void canCreateFontUsingFactory() {
        Font font = Font.FontFactory.getFont("Test");
        assertNotNull(font);
    }

    @Test
    public void fontIsFlyweight() {
        Font font1 = Font.FontFactory.getFont("Test1");
        Font font2 = Font.FontFactory.getFont("Test1");
        assertSame(font1, font2);
    }

    @Test
    public void canGetFontName() {
        Font font = Font.FontFactory.getFont("Test");
        assertEquals("Test", font.getFontName());
    }

    @Test
    public void canGetSanitizedFontName() {
        Font font = Font.FontFactory.getFont(":");
        assertEquals("\\:", font.getSanitizedFontName());
    }
}
