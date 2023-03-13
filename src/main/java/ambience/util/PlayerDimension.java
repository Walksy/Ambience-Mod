package ambience.util;

public enum PlayerDimension {
    Overworld,
    Nether,
    End;

    public PlayerDimension opposite() {
        return switch (this) {
            case Overworld -> Nether;
            case Nether -> Overworld;
            default -> this;
        };
    }
}
