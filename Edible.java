/**
 * This type is given to anything that can be eated for nutrition
 * @author Daniel Hay
 * @version 1.0
 */
public interface Edible {
    /**
     * Returns the nutritional value of the Edible
     */
    int getFoodPoints();
    /**
     * Returns a boolean value based on whether this
     * Edible Species is equal to a specified Object
     */
    boolean equals(Object o);
}
