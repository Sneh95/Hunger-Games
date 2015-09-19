/**
 * Represents a Panda: an Animal that is an endangered species
 * @author Daniel Hay
 * @version 1.0
 */
public class Panda extends Animal implements EndangeredSpecies {
    private final int wantedLevel = Nature.RAND.nextInt(2) + 1;
    private final int id = Nature.RAND.nextInt(Integer.MAX_VALUE);
    /**
     * Constructs a new Panda object (a type of Animal)
     * @param home the Panda's birthplace and residence
     */
    public Panda(Home home) {
        super("panda-100.png", home);
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
     * Determines if this Panda is equal to a specified Object
     * @param o the Object being tested for equality
     * @return {@literal true} if this Panda is equal to the Object
     */
    public boolean equals(Object o) {
        return super.equals(o) && this.id == ((Panda) o).id;
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
