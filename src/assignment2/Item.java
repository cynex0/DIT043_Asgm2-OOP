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

    public String toString(){
        int weightInt = (int)(itemWeight*100);
        double truncatedWeight = weightInt / 100.0;
        return String.format("%s heals %d HP. (%.2f)", name, healingPower, truncatedWeight);
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
        return (this.name.equals(other.name)) &&
               (this.healingPower == other.healingPower)&&
               (this.itemWeight == other.itemWeight);
    }
}

// 213.126  *100
// 21312,6  (int)
// 21312    /100
// 213,12   (double)

