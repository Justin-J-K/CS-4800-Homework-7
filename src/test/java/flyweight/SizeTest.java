package flyweight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SizeTest {
    @Test
    public void canCreateSizeUsingFactory() {
        Size size = Size.SizeFactory.getSize(0);
        assertNotNull(size);
    }

    @Test
    public void sizeIsFlyweight() {
        Size size1 = Size.SizeFactory.getSize(1);
        Size size2 = Size.SizeFactory.getSize(1);
        assertSame(size1, size2);
    }

    @Test
    public void canGetSizeInPixels() {
        Size size = Size.SizeFactory.getSize(10);
        assertEquals(10, size.getSizeInPixels());
    }
}
