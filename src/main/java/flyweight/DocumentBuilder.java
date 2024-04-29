package flyweight;

import java.util.ArrayList;
import java.util.List;

public class DocumentBuilder {
    private List<Character> characters = new ArrayList<>();
    private String currentColorName;
    private String currentFontName;
    private int currentSizeInPixels;

    public DocumentBuilder(String initialColorName, String initialFontName, int initialSizeInPixels) {
        this.currentColorName = initialColorName;
        this.currentFontName = initialFontName;
        this.currentSizeInPixels = initialSizeInPixels;
    }

    public DocumentBuilder appendText(String text) {
        for (char character : text.toCharArray()) {
            appendCharacter(character);
        }

        return this;
    }

    public DocumentBuilder appendCharacter(char character) {
        characters.add(Character.CharacterFactory
                .getCharacter(character, currentColorName, currentFontName, currentSizeInPixels)
        );

        return this;
    }

    public DocumentBuilder setCurrentColorName(String colorName) {
        currentColorName = colorName;

        return this;
    }

    public DocumentBuilder setCurrentFontName(String fontName) {
        currentFontName = fontName;

        return this;
    }

    public DocumentBuilder setCurrentSizeInPixels(int sizeInPixels) {
        currentSizeInPixels = sizeInPixels;

        return this;
    }

    public Document build() {
        return new Document(characters);
    }
}
