package flyweight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CharacterTest {
    private static Character character = Character.CharacterFactory.getCharacter('a', "Color", "Font", 10);

    @Test
    public void canCreateCharacterFromFactory() {
        Character characterFromFactory = Character.CharacterFactory.getCharacter('a', "Color", "Font", 20);
        assertNotNull(characterFromFactory);
    }

    @Test
    public void canGetCharacter() {
        assertEquals('a', character.getCharacter());
    }

    @Test
    public void canGetColor() {
        assertEquals("Color", character.getColor().getColorName());
    }

    @Test
    public void canGetFont() {
        assertEquals("Font", character.getFont().getFontName());
    }

    @Test
    public void canGetSize() {
        assertEquals(10, character.getSize().getSizeInPixels());
    }

    @Test
    public void canGetToStringOfCharacter() {
        assertEquals("Color:Font:10:a", character.toString());
    }
}
