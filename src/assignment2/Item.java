package assignment2;

public class Item {
    private final String name;
    private final int healingPower;
    private final double itemWeight;

    public Item(String name, int power, double weight) {
        this.name = name;
        this.healingPower = power;
        this.itemWeight = weight;
    }

    // getters
    public String getName() {
        return this.name;
    }

    public double getItemWeight() {
        return this.itemWeight;
    }

    public int getHealingPower() {
        return this.healingPower;
    }

    // overrides
    public String toString() {
        // truncate to 2 decimal points
        int weightInt = (int)(this.itemWeight * 100);
        double truncatedWeight = weightInt / 100.0;

        // <item name> heals <heal power> HP. (<weight>)
        return String.format("%s heals %d HP. (%.2f)",
                             this.name, this.healingPower, truncatedWeight);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof Item)){
            return false;
        }

        Item other = (Item)object;

        // Two items are equals if they have the same name, healing power and weight values.
        return (this.name.equals(other.getName())) &&
               (this.healingPower == other.getHealingPower()) &&
               (this.itemWeight == other.getItemWeight());
    }
}
