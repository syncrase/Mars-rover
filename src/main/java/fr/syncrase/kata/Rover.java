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

    public void applyCommands() {
        for (Command next : commands) {
            next.move(this);
        }
    }

    public void turn(int sens) {
        direction = direction.turn(sens);
    }

    public void go(int sens) {
        coordonnees = new Coordonnees(coordonnees, direction, sens);
    }

    public void setCommands(ArrayList<Command> commands) {
        this.commands = commands;
    }

    public Direction getDirection() {
        return this.direction;
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
}
