package fr.syncrase.kata;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Rover {
    private final Direction direction;
    private Coordonnees coordonnees;
    private ArrayList<Command> commands;

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

    public Direction getDirection() {
        return this.direction;
    }

    public void setCommands(ArrayList<Command> commands) {
        this.commands = commands;
    }

    public void move() {
        Iterator<Command> iterator = commands.iterator();
        while (iterator.hasNext()) {
            Command next = iterator.next();
            this.applyCommand(next);
        }
    }

    private void applyCommand(Command next) {
        next.apply(this);
    }

    public void setPosition(Coordonnees go) {
        this.coordonnees = go;
    }
}
