public class EmptyCell extends Cell {
    private String representation;

    public String setRepresentation() {
        this.representation = "   ";
        return this.representation;
    }

    public String getRepresentation() {
        return this.setRepresentation();
    }

    public String toString() {
        return this.getRepresentation();
    }
}
