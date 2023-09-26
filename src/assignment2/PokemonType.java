package assignment2;

public enum PokemonType {
    BUG("Bug"), DRAGON("Dragon"), ELECTRIC("Electric"), FIRE("Fire"),
    GRASS("Grass"), ICE("Ice"), WATER("Water"), NORMAL("Normal");

    // types are in the same order as in the specified multiplier table,
    // to allow easy multiplier calculations using ordinals

    // this implementation was chosen as the best, as it avoids comparisons when getting the multiplier,
    // is more readable (avoids nested comparisons), and is more maintainable (value changes in the table)
    private static final double[][] MULTIPLIER_TABLE = {
            // rows - attacker types, columns - defender types
            //              ATK
            // B  DRG  EL   F    GR   ICE  WTR  NRM
/*    B  */ {1.0, 1.0, 1.0, 0.5, 2.0, 1.0, 1.0, 1.0},
/*    DRG*/ {1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0},
/*    EL */ {1.0, 0.5, 0.5, 1.0, 0.5, 1.0, 2.0, 1.0},
/*D   F  */ {2.0, 0.5, 1.0, 0.5, 2.0, 2.0, 0.5, 1.0},
/*E   GR */ {0.5, 0.5, 1.0, 0.5, 0.5, 1.0, 2.0, 1.0},
/*F   ICE*/ {1.0, 2.0, 1.0, 0.5, 2.0, 0.5, 0.5, 1.0},
/*    WTR*/ {1.0, 0.5, 1.0, 2.0, 0.5, 1.0, 0.5, 1.0},
/*    NRM*/ {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0}
    };

    final String TYPE_NAME;

    PokemonType(String typeName) {
        this.TYPE_NAME = typeName;
    }

    public String toString() {
        return TYPE_NAME;
    }

    public static double getDamageMultiplier(String attackerType, String defenderType) {
        PokemonType attacker = PokemonType.valueOf(attackerType.toUpperCase());
        PokemonType defender = PokemonType.valueOf(defenderType.toUpperCase());

        return MULTIPLIER_TABLE[attacker.ordinal()][defender.ordinal()];
    }
}
