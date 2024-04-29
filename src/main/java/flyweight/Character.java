package flyweight;

import java.io.Serializable;

public class Character implements Serializable {
    private char character;
    private Color color;
    private Font font;
    private Size size;

    public Character(char character, Color color, Font font, Size size) {
        this.character = character;
        this.color = color;
        this.font = font;
        this.size = size;
    }

    public char getCharacter() {
        return character;
    }

    public Color getColor() {
        return color;
    }

    public Font getFont() {
        return font;
    }

    public Size getSize() {
        return size;
    }

    @Override
    public String toString() {
        return color.getSanitizedColorName() + ":"
                + font.getSanitizedFontName() + ":"
                + size.getSizeInPixels() + ":"
                + character;
    }

    public static class CharacterFactory {
        public static Character getCharacter(char character, String colorName, String fontName, int sizeInPixels) {
            Color color = Color.ColorFactory.getColor(colorName);
            Font font = Font.FontFactory.getFont(fontName);
            Size size = Size.SizeFactory.getSize(sizeInPixels);

            return new Character(character, color, font, size);
        }
    }
}
