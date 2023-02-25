package fr.syncrase.kata;

import java.util.ArrayList;
import java.util.Objects;

public class Rover {
    private Direction direction;
    private Coordonnees coordonnees;
    private ArrayList<Command> commands;

    public Rover(Coordonnees coordonnees, Direction direction) {
        this.coordonnees = coordonnees;
        this.direction = direction;
    }

    public void move() {
        for (Command next : commands) {
            next.move(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rover rover)) return false;

        if (direction != rover.direction) return false;
        if (!coordonnees.equals(rover.coordonnees)) return false;
        return Objects.equals(commands, rover.commands);
    }

    @Override
    public int hashCode() {
        int result = direction.hashCode();
        result = 31 * result + coordonnees.hashCode();
        result = 31 * result + (commands != null ? commands.hashCode() : 0);
        return result;
    }

    public void setCommands(ArrayList<Command> commands) {
        this.commands = commands;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Coordonnees getPosition() {
        return this.coordonnees;
    }

    public void setPosition(Coordonnees go) {
        this.coordonnees = go;
    }
}
