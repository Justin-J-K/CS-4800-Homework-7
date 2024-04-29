package flyweight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ColorTest {
    @Test
    public void canCreateColorUsingFactory() {
        Color color = Color.ColorFactory.getColor("Color");
        assertNotNull(color);
    }

    @Test
    public void colorIsFlyweight() {
        Color color1 = Color.ColorFactory.getColor("Color1");
        Color color2 = Color.ColorFactory.getColor("Color1");
        assertSame(color2, color1);
    }

    @Test
    public void canGetColorName() {
        Color color = Color.ColorFactory.getColor("Color");
        assertEquals("Color", color.getColorName());
    }

    @Test
    public void canGetSanitizedColorName() {
        Color color = Color.ColorFactory.getColor(":");
        assertEquals("\\:", color.getSanitizedColorName());
    }
}
