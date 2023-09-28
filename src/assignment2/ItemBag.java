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
        for(int i = 0; i <= items.size(); i++){
            if(item.getItemWeight() >= items.get(i).getItemWeight()){
                index = i;
                break;
            }
        }

        items.add(index, item);
        this.currentWeight = this.currentWeight + item.getItemWeight();
        return index;
    }

    public Item removeItemAt(int index){
        if(index >= items.size()){
            return null;
        }

        return items.remove(index);


    }
    public String peekItemAt(int index){
        if(index >= items.size()){
            return null;
        }
        return items.get(index).toString();
    }
    public Item popItem(){
        return items.remove(0);
    }
}
