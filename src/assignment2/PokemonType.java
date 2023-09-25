package assignment2;

public enum PokemonType {
    FIRE("Fire"), WATER("Water"), GRASS("Grass"), NORMAL("Normal");

    final String TYPE_NAME;

    PokemonType(String typeName) {
        this.TYPE_NAME = typeName;
    }

    public String toString() {
        return TYPE_NAME;
    }
}
