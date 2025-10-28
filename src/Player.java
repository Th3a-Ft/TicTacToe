public class Player {
    private String name;
    private String representation;

    public Player(){

    }

    /**
     * Constructor of the player
     * @param name
     * @param representation X or O
     */
    public Player(String name, String representation) {
        this.name = name;
        this.representation = representation;
    }

    /**
     * Method that retrieves the player name attributes
     * @return (string) the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Method that retrieves the player representation attributes
     * @return (string) representation of the player "X" or "O"
     */
    public String getRepresentation() {
        return representation;
    }
}
