package fr.syncrase.kata;

public class Rover {
    private final Direction direction;
    private final Coordonnees coordonnees;

    public Rover(Coordonnees coordonnees, Direction direction) {
        this.coordonnees = coordonnees;
        this.direction = direction;
    }

    public Coordonnees getPosition() {
        return this.coordonnees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rover rover)) return false;

        return coordonnees.equals(rover.coordonnees);
    }

    @Override
    public int hashCode() {
        return coordonnees.hashCode();
    }

    public Direction getDirection() {
        return this.direction;
    }
}
