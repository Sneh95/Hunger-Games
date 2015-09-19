/**
 * This class represents a wild Boar.  It is edible.
 * @author Daniel Hay
 * @version 1.0
 */
public class Boar extends Animal implements Edible {
    private static final int FOODPOINTS = Nature.RAND.nextInt(6) + 25;
    private final int id = Nature.RAND.nextInt(Integer.MAX_VALUE);
     /**
     * Constructs a new Boar object (a type of Animal)
     * @param home the Boar's birthplace and residence
     */
    public Boar(Home home) {
        super("boar-100.png", home);
    }
     /**
     * Returns the value of the instance variable,
     * FOODPOINTS, which is of type int
     * @return the integer value FOODPOINTS
     */
    public int getFoodPoints() {
        return FOODPOINTS;
    }

    @Override
    /**
     * Determines if this Boar is equal to a specified Object
     * @param o the Object being tested for equality
     * @return {@literal true} if this Boar is equal to the Object
     */
    public boolean equals(Object o) {
        return super.equals(o) && this.id == ((Boar) o).id;
    }
    /**
     * This method returns an int value that is based on this id
     * and uses the super call to access the super hashcode
     * @return An int value that represents the value of hashCode
     */
    public int hashCode() {
        return super.hashCode() + this.id;
    }
}
