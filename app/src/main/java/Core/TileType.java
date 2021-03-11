package Core;

public enum TileType {

    BAMBOO("bamboo", 2),
    CHARACTER("character", 0),
    CIRCLE("circle", 1),
    WIND("wind", 3),
    DRAGON("dragon", 3);

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
