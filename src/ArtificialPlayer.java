public class ArtificialPlayer extends Player {
    private String name;
    private String representation;

    public ArtificialPlayer(String name, String representation) {
        this.name = name;
        this.representation = representation;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getRepresentation() {
        return representation;
    }

}
