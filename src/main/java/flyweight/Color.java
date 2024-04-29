package flyweight;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Color implements Serializable {
    private String colorName;

    private Color(String colorName) {
        this.colorName = colorName;
    }

    public String getColorName() {
        return colorName;
    }

    public String getSanitizedColorName() {
        return colorName.replace(":", "\\:");
    }

    public static class ColorFactory {
        private static Map<String, Color> colors = new HashMap<>();

        public static Color getColor(String colorName) {
            if (!colors.containsKey(colorName)) {
                colors.put(colorName, new Color(colorName));
            }

            return colors.get(colorName);
        }
    }

}
