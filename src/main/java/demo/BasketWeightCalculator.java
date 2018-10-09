package demo;

/**
 * @author Dhanendra Kumar
 */
public class BasketWeightCalculator {

    private int totalWeight = 0;

    public void addItem(int itemWeight) {

        if (itemWeight > 0) {
            totalWeight = totalWeight + itemWeight;
        }
    }


    public int getTotalWeight() {
        return totalWeight;
    }
}

//    public boolean greater(){
//        if(totalWeight>0){
//            return true;
//        }
//        else{
//            return false;
//        }
//    }
//}
