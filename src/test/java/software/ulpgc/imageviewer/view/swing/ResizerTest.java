package software.ulpgc.imageviewer.view.swing;

import org.junit.Test;
import java.awt.Rectangle;
import static org.junit.Assert.assertEquals;

public class ResizerTest {

    private final Resizer resizer = new Resizer();

    @Test
    public void image_smaller_than_window_scales_up_and_centers() {
        Rectangle result = resizer.resize(800, 600, 400, 300);

        assertEquals(800, result.width);
        assertEquals(600, result.height);
        assertEquals(0, result.x);
        assertEquals(0, result.y);
    }

    @Test
    public void panoramic_image_fits_width_and_centers_vertically() {
        Rectangle result = resizer.resize(800, 600, 1600, 400);

        assertEquals(800, result.width);
        assertEquals(200, result.height);
        assertEquals(0, result.x);
        assertEquals(200, result.y);
    }

    @Test
    public void portrait_image_fits_height_and_centers_horizontally() {
        Rectangle result = resizer.resize(800, 600, 300, 1200);

        assertEquals(150, result.width);
        assertEquals(600, result.height);
        assertEquals(325, result.x);
        assertEquals(0, result.y);
    }

    @Test
    public void image_exactly_matches_window() {
        Rectangle result = resizer.resize(800, 600, 800, 600);

        assertEquals(800, result.width);
        assertEquals(600, result.height);
        assertEquals(0, result.x);
        assertEquals(0, result.y);
    }
}