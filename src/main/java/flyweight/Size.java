package flyweight;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Size implements Serializable {
    private int sizeInPixels;

    private Size(int sizeInPixels) {
        this.sizeInPixels = sizeInPixels;
    }

    public int getSizeInPixels() {
        return sizeInPixels;
    }

    public static class SizeFactory {
        private static Map<Integer, Size> sizes = new HashMap<>();

        public static Size getSize(int sizeInPixels) {
            if (!sizes.containsKey(sizeInPixels)) {
                sizes.put(sizeInPixels, new Size(sizeInPixels));
            }

            return sizes.get(sizeInPixels);
        }
    }
}
