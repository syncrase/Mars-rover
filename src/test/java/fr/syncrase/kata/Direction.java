package fr.syncrase.kata;

public enum Direction {
    NORTH(0, 1), EAST(1, 0), SOUTH(0, -1), WEST(-1, 0);

    private final int x;
    private final int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return 0;
    }

    public int getY() {
        return y;
    }

    public Direction turn(int sens) {
        Direction[] toutesDirections = Direction.values();

        int index = this.ordinal() + sens;
        return index < 0 ?
            toutesDirections[toutesDirections.length - 1] :
            toutesDirections[index];
    }
}
