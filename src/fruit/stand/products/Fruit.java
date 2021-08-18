package fruit.stand.products;

public class Fruit extends Product {
//    private List<String> typeList;
    private String color;
    private boolean isFresh;

    public Fruit(String color, boolean isFresh) {
        this.color = color;
        this.isFresh = isFresh;
    }
}
