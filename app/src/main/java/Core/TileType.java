package Core;

public enum TileType {

    CHARACTER("man", 0),
    CIRCLE("pin", 1),
    BAMBOO("sou", 2),
    WIND("wind", 3),
    DRAGON("dragon", 4);

    private int num;
    private String name;

    private TileType(String name, int num) {

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
