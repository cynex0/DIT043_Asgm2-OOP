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

    public String getName() {
        return name;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getEnergyCost() {
        return energyCost;
    }

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
        return (this.name.equals(other.name)) &&
               (this.attackPower == other.attackPower) &&
               (this.energyCost == other.energyCost);
    }

    public String toString() {
        return String.format("%s - AP: %d EC: %d", this.name, this.attackPower, this.energyCost);
    }
}