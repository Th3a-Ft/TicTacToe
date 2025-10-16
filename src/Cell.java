public class Cell {
    private String representation;

    public Cell() {
        this("   ");
    }

    public Cell(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return this.representation;
    }

    //m
    public void setRepresentation(String representation) {
        this.representation = representation;
    }
}
