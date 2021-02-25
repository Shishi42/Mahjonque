package Core;

public enum TileType {

    BAMBOU("Bamboo", 2),
    FEU("Character", 0),
    PIECE("Circle", 1),
    VENT("Wind", 3),
    DRAGON("Dragon", 3);

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
