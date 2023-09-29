package assignment2;
import java.util.ArrayList;

public class ItemBag {

    private ArrayList<Item> items;
    private final double maxWeight;
    private double currentWeight;

    public ItemBag(double maxWeight) {
        this.maxWeight = maxWeight;
        this.currentWeight = 0.0;
        this.items = new ArrayList<Item>();
    }

    // getters
    public double getMaxWeight() {
        return this.maxWeight;
    }

    public double getCurrentWeight() {
        return this.currentWeight;
    }

    public int getNumOfItems() {
        return this.items.size();
    }


    public int addItem(Item newItem) {
        double newWeight = newItem.getItemWeight() + this.currentWeight;
        if (newWeight > this.maxWeight){
            return -1;
        }

        this.currentWeight = newWeight;

        int index = 0;
        // go through the array until we find an item in the array that is lighter than the new item, keep that index
        while (index < items.size() && items.get(index).getItemWeight() > newItem.getItemWeight()) {
            index++;
        }

        items.add(index, newItem); // allows adding to index 0 even if the list is empty (size 0)
        return index;
    }

    public Item removeItemAt(int index) {
        if ((items.isEmpty()) || (index < 0) || (index >= items.size())){
            return null;
        }

        Item removedItem = items.remove(index);
        this.currentWeight = this.currentWeight - removedItem.getItemWeight();
        return removedItem;
    }

    public String peekItemAt(int index) {
        if ((items.isEmpty()) || (index < 0) || (index >= items.size())){
            return "";
        }

        return items.get(index).toString();
    }

    public Item popItem() {
        if (items.isEmpty()) {
            return null;
        }

        Item poppedItem = items.remove(0);
        this.currentWeight = this.currentWeight - poppedItem.getItemWeight();
        return poppedItem;
    }
}
