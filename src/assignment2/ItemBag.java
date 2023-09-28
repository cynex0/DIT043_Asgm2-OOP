package assignment2;
import java.util.ArrayList;

public class ItemBag {

    private ArrayList<Item> items;
    private final double maxWeight;
    private double currentWeight;

    public ItemBag(double maxWeight){
        this.maxWeight = maxWeight;
        this.currentWeight = 0.0;
        this.items = new ArrayList<Item>();
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public int getNumOfItems() {
        return items.size();
    }

    public int addItem(Item item){
        if( item.getItemWeight() + currentWeight > maxWeight){
            return -1;
        }

        if (items.isEmpty()) {
            items.add(item);
            this.currentWeight = this.currentWeight + item.getItemWeight();
            return 0;
        }

        int index = 0;
        // go through the array until we find an item in the array that is lighter than the new item
        while (index < items.size() && items.get(index).getItemWeight() > item.getItemWeight()) {
            index++;
        }

        items.add(index, item);
        this.currentWeight = this.currentWeight + item.getItemWeight();
        return index;
    }

    public Item removeItemAt(int index){
        if(index >= items.size()){
            return null;
        }

        this.currentWeight = this.currentWeight - items.get(index).getItemWeight();
        return items.remove(index);
    }

    public String peekItemAt(int index){
        if((items.isEmpty()) || (index < 0) || (index >= items.size())){
            return "";
        }
        return items.get(index).toString();
    }

    public Item popItem(){
        if (items.isEmpty()) {
            return null;
        }

        Item item = items.remove(0);
        this.currentWeight = this.currentWeight - item.getItemWeight();
        return item;
    }
}
