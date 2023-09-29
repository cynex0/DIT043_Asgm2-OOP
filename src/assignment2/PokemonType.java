package assignment2;

public enum PokemonType {
    // types are in the same order as in the specified multiplier table, to allow getting multipliers using ordinals
    BUG("Bug"), DRAGON("Dragon"), ELECTRIC("Electric"), FIRE("Fire"),
    GRASS("Grass"), ICE("Ice"), WATER("Water"), NORMAL("Normal");

    // this implementation was chosen as the best, as it avoids comparisons when getting the multiplier,
    // is more readable (avoids nested comparisons) and more maintainable (values can be changed easily in the table)
    private static final double[][] MULTIPLIER_TABLE = {     // first index - attacker, second index - defender
             //                      DEF
             // BUG   DRG   EL    FIR   GR    ICE   WTR   NRM
/*     BUG */  {1.0,  1.0,  1.0,  0.5,  2.0,  1.0,  1.0,  1.0},
/*     DRG */  {1.0,  2.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0},
/*     EL  */  {1.0,  0.5,  0.5,  1.0,  0.5,  1.0,  2.0,  1.0},
/* A   FIR */  {2.0,  0.5,  1.0,  0.5,  2.0,  2.0,  0.5,  1.0},
/* T   GR  */  {0.5,  0.5,  1.0,  0.5,  0.5,  1.0,  2.0,  1.0},
/* K   ICE */  {1.0,  2.0,  1.0,  0.5,  2.0,  0.5,  0.5,  1.0},
/*     WTR */  {1.0,  0.5,  1.0,  2.0,  0.5,  1.0,  0.5,  1.0},
/*     NRM */  {1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0,  1.0}
    };

    final String TYPE_NAME; // constant to allow toString

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
