import java.awt.Graphics;
/**
 * This interface represents a pure type given to every drawable class
 * @author Daniel Hay
 * @version 1.0
 */
public interface Drawable {
    /**
     * This method draws the required objects
     * @param g the component object on which to draw
     */
    void draw(Graphics g);
}
