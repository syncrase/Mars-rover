package fr.syncrase.kata;

public record Coordonnees(int x, int y) {

    public Coordonnees(Coordonnees position, Direction direction, int sens) {
        this(
            position.x + sens * direction.getX(),
            position.y + sens * direction.getY()
        );
    }


}
