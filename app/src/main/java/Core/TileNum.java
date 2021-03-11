package Core;

public enum TileNum {

    ONE("one", 0),
    TWO("two", 1),
    THREE("three", 2),
    FOUR("four", 3),
    FIVE("five", 4),
    SIX("six", 5),
    SEVEN("seven", 6),
    EIGHT("eight", 7),
    NINE("nine", 8);

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
