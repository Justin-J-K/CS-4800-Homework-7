package flyweight;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Font implements Serializable {
    private String fontName;

    private Font(String fontName) {
        this.fontName = fontName;
    }

    public String getFontName() {
        return fontName;
    }

    public String getSanitizedFontName() {
        return fontName.replace(":", "\\:");
    }

    public static class FontFactory {
        private static Map<String, Font> fonts = new HashMap<>();

        public static Font getFont(String fontName) {
            if (!fonts.containsKey(fontName)) {
                fonts.put(fontName, new Font(fontName));
            }

            return fonts.get(fontName);
        }
    }

}
