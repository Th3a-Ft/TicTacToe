public class Cell {
    private String representation;

    /**
     * Constructor by default with the representation of an empty cell
     */
    public Cell() {
        this("   ");
    }

    /**
     * Constructor according the owner of the cell
     * @param representation can be " X " or " O " if a player is the new owner of the cell
     */
    public Cell(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return this.representation;
    }

    public String setRepresentation(String representation) {
        this.representation = representation;
        return representation;
    }
}
