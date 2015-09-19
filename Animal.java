import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

/**
 * The Animal class is the abstract base class for all animals
 * Animals have a Home where they are born and always come back to
 * Their center is their actual (graphical) location
 * their upperLeft is the point at the upperleft of the image.
 * They have a confort distance maxDist.  They don't like being farther
 * from home than that.
 * @author Daniel Hay
 * @version 1.0
 */
public abstract class Animal implements Drawable {
    private BufferedImage icon;
    private Point centre;
    private Point upperLeft;
    private int width, height;
    private Direction dir = Direction.OUT;
    private final double maxDist;
    private Home home;
    private boolean isDead = false;
    private boolean isHidden = true, isMoving = false;
    /**
     * Constructs a new Animal object
     * @param imageName the filename of the Animal's icon
     * @param home the Animal's birthplace and residence
     */
    public Animal(String imageName, Home home) {
        this.icon = GamePanel.getIcon(imageName);
        this.home = home;
        this.centre = new Point(home.getCenter());
        this.width = icon.getWidth();
        this.height = icon.getHeight();
        this.upperLeft = GamePanel.upperLeft(centre, width, height);
        this.maxDist = Nature.RAND.nextInt(351) + 150;
    }
    /**
     * Returns true if the Animal is moving
     * @return {@literal true} if the Animal is moving
     */
    public boolean isMoving() {
        return isMoving;
    }
    /**
     * Sets the isMoving instance variable to true or false
     * @param isMoving if the Animal is moving or not
     */
    public void setMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }
    /**
     * Teleports the Animal back to its home
     */
    public void teleport() {
        setLocation(home.getCenter());
    }
    /**
     * Updates the location
     */
    private void updateLocation() {
        upperLeft = GamePanel.upperLeft(centre, width, height);
    }
    /**
     * Sets the location of the Animal
     * @param p the location of the animal
     */
    public void setLocation(Point p) {
        centre = new Point(p);
        updateLocation();
    }
    /**
     * Tranlates the location of the Animal
     * @param x the x-coordinate
     * @param y the y-coordinate
     */
    public void translate(int x, int y) {
        centre.translate(x, y);
        updateLocation();
    }
    /**
     * Returns the value of the instance variable,
     * centre, which is of type Pointa and gives
     * the location of the Animal
     * @return the centre point coordinates
     */
    public Point getLoc() {
        return centre;
    }
    /**
     * Returns the value of the instance variable,
     * upper left, of type Point
     * @return the upperLeft point coordinates
     */
    public Point getUpperLeft() {
        return upperLeft;
    }
    /**
     * Returns the int value, width, of the icon
     * @return the width of the icon
     */
    public int getWidth() {
        return width;
    }
    /**
     * Returns the int value, height, of the icon
     * @return the height of the icon
     */
    public int getHeight() {
        return height;
    }
    /**
     * Returns the value of the instance variable, home,
     * which is of type Home and is the home of the Animal
     * @return the home of the Animal
     */
    public Home getHome() {
        return home;
    }
    /**
     * Sets the home of the Animal
     * @param home The home of the Animal
     */
    public void setHome(Home home) {
        this.home = home;
    }
    /**
     * Returns the boolean value of the instance variable, isDead
     * (true if the animal is dead, otherwise false)
     * @return whether the Animal is dead or not
     */
    public boolean isDead() {
        return isDead;
    }
    /**
     * Hides the Animal
     */
    public void hide() {
        isHidden = true;
    }
    /**
     * Shows the Animal (it stops hiding)
     */
    public void show() {
        isHidden = false;
    }
    /**
     * Returns the boolean value of the instance variable, isHidden
     * (true if the Animal is hidden, otherwise false)
     * @return whether the Animal is hidden or not
     */
    public boolean isHidden() {
        return isHidden;
    }
    /**
     * Returns the value of the instance variable,
     * maxDist, which is of type double
     * @return the maximum distance the Animal can move
     */
    public double getMaxDist() {
        return maxDist;
    }
    /**
     * Returns the value of the instance variable,
     * dir, which is of type Direction
     * @return the direction
     */
    public Direction getDir() {
        return dir;
    }
    /**
     * Sets the direction of the Animal
     * @param dir the direction
     */
    public void setDir(Direction dir) {
        this.dir = dir;
    }
    /**
     * Determines whether this Animal is hit by a shot
     * If this Animal is indeed hit, the Animal dies
     * @param scope the scope of the shot
     * @return {@literal true} if the Animal is hit
     */
    public boolean isHit(Rectangle scope) {
        Rectangle body = new Rectangle(upperLeft, new Dimension(width, height));
        if (!body.intersects(scope)) {
            return false;
        }
        Rectangle rect = scope.intersection(body);
        rect.translate(-upperLeft.x, -upperLeft.y);
        int[] img = icon.getRGB(rect.getLocation().x, rect.getLocation().y,
                                (int) rect.getWidth(), (int) rect.getHeight(),
                                null, 0, width);
        int count = 0;
        for (int i : img) {
            if (i != 0) {
                ++count;
            }
            if (count > 3) {
                isDead = true;
                return true;
            }
        }
        return false;
    }
    /**
     * Draws the icon needed to be drawn
     * @param g the component object on which to draw
     */
    public void draw(Graphics g) {
        g.drawImage(icon, upperLeft.x, upperLeft.y, null);
    }

    @Override
    /**
     * Determines if this Animal is equal to a specified Object
     * @param obj the Object being tested for equality
     * @return {@literal true} if this Animal is equal to the Object
     */
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Animal)) {
            return false;
        }
        return (this.centre.equals(((Animal) obj).centre)
                && this.getClass().equals(obj.getClass()));
    }
    /**
     * This method returns an int value by calling the hashCode on the
     * object's instance variable called centre
     * @return an int value that represents the value of hashCode
     */
    public int hashCode() {
        return this.centre.hashCode();
    }
}
