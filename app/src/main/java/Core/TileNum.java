package Core;

public enum TileNum {

    ONE("One", 0),
    TWO("Two", 1),
    THREE("Three", 2),
    FOUR("Four", 3),
    FIVE("Five", 4),
    SIX("Six", 5),
    SEVEN("Seven", 6),
    EIGHT("Eight", 7),
    NINE("Nine", 8);

    private String name;
    private int num;

    private TileNum(String name, int num) {

        this.name = name;
        this.num = num;

    }

    public int getNum() {
        return this.num;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
