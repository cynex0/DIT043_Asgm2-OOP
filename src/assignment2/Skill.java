package assignment2;

import java.util.Objects;

public class Skill {
    private final String name;
    private final int attackPower;
    private final int energyCost;

    Skill(String name, int attackPower, int energyCost){
        this.name = name;
        this.attackPower = attackPower;
        this.energyCost = energyCost;
    }

    // getters
    public String getName() {
        return this.name;
    }

    public int getAttackPower() {
        return this.attackPower;
    }

    public int getEnergyCost() {
        return this.energyCost;
    }

    // overrides
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof Skill)) {
            return false;
        }

        Skill other = (Skill)object;

        // Two skills are equal if they have the same names, APs and energy costs.
        return (this.name.equals(other.name)) &&
               (this.attackPower == other.attackPower) &&
               (this.energyCost == other.energyCost);
    }

    public String toString() {
        // <skill name> - AP: <ap> EC: <ec>
        return String.format("%s - AP: %d EC: %d", this.name, this.attackPower, this.energyCost);
    }
}