package fr.syncrase.kata;

public class Coordonnees {
    private final int x;
    private final int y;

    public Coordonnees(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordonnees(Coordonnees position, Direction direction, int sens) {
        this.x = position.getX() + sens * direction.getX();
        this.y = position.getY() + sens * direction.getY();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordonnees that)) return false;

        if (x != that.x) return false;
        return y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public int getY() {
        return this.y;
    }

    public int getX() {
        return x;
    }

}
