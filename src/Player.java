public class Player {
    private String name;
    private String representation;

    /**
     * Constructor of the player
     * @param name
     * @param representation X or O
     */
    public Player(String name, String representation) {
        this.name = name;
        this.representation = representation;
    }

    public String getName() {
        return name;
    }

    public String getRepresentation() {
        return representation;
    }
}
