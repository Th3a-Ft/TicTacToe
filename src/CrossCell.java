public class CrossCell extends Cell {
    private String representation;

    public String setRepresentation() {
        this.representation = " X ";
        return this.representation;
    }

    public String getRepresentation() {
        return this.setRepresentation();
    }

    public String toString() {
        return this.getRepresentation();
    }
}
