/**
 * This interface represents an endangered species type
 * @author Daniel Hay
 * @version 1.0
 */
public interface EndangeredSpecies {
    /**
     * Returns the wanted level associated with the Endangered Species
     */
    int getWantedLevel();
    /**
     * Returns a boolean value based on whether this
     * Endangered Species is equal to a specified Object
     */
    boolean equals(Object o);
}
