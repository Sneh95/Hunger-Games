/**
 * Represents a Rabbit: an Animal that is an endangered species
 * @author Sneh Munshi
 * @version 6.0
 */
public class Rabbit extends Animal implements EndangeredSpecies {
    private final int wantedLevel = Nature.RAND.nextInt(2) + 1;
    private final int id = Nature.RAND.nextInt(Integer.MAX_VALUE);
    /**
     * Constructs a new Rabbit object (a type of Animal)
     * @param home the Rabbit's birthplace and residence
     */
    public Rabbit(Home home) {
        super("rabbit-100.png", home);
    }
    /**
     * Returns the value of the instance variable,
     * getWantedLevel, which is of type int
     * @return the integer value getWantedLevel
     */
    public int getWantedLevel() {
        return this.wantedLevel;
    }

    @Override
    /**
     * Determines if this Rabbit is equal to a specified Object
     * @param o the Object being tested for equality
     * @return {@literal true} if this Rabbit is equal to the Object
     */
    public boolean equals(Object o) {
        return super.equals(o) && this.id == ((Rabbit) o).id;
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
