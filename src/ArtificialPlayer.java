public class ArtificialPlayer extends Player {
    private String name;
    private String representation;

    public ArtificialPlayer(String name, String representation) {
        this.name = name;
        this.representation = representation;
    }

    /**
     * Method that retrieves the player name attributes
     * @return (string) the name of the player
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Method that retrieves the player representation attributes
     * @return (string) representation of the player "X" or "O"
     */
    @Override
    public String getRepresentation() {
        return representation;
    }

}
