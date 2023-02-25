package fr.syncrase.kata;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RoverTest {

    @Nested
    @DisplayName("Given the initial")
    class CreationTest {

        Rover rover;

        public CreationTest() {
            Coordonnees coordonnees = new Coordonnees(0, 0);
            Direction direction = Direction.NORTH;
            this.rover = new Rover(coordonnees, direction);
        }

        @Test
        @DisplayName("starting point (x,y) of a rover")
        void testInitialCoordonnees() {
            assertEquals(new Coordonnees(0, 0), this.rover.getPosition());
        }

        @Test
        @DisplayName("direction (N,S,E,W) it is facing")
        void testInitialDirection() {
            assertEquals(Direction.NORTH, this.rover.getDirection());
        }
    }

    @Test
    void roverReceivesACharacterArrayOfCommand() {
        Rover rover = new Rover(new Coordonnees(0, 0), Direction.NORTH);
        ArrayList<Command> commands = new ArrayList<>();
        rover.setCommands(commands);
        assertNotNull(rover);
    }

    @Nested
    @DisplayName("Commands that move the rover")
    class MoveTest {

        private final Rover rover;

        public MoveTest() {
            this.rover = new Rover(new Coordonnees(0, 0), Direction.NORTH);
        }

        @Test
        void forward() {
            ArrayList<Command> commands = new ArrayList<>();
            commands.add(Command.FORWARD);
            rover.setCommands(commands);
            rover.move();
            assertEquals(new Coordonnees(0, 1), rover.getPosition());
        }

        @Test
        void backward() {
            ArrayList<Command> commands = new ArrayList<>();
            commands.add(Command.BACKWARD);
            rover.setCommands(commands);
            rover.move();
            assertEquals(new Coordonnees(0, -1), rover.getPosition());
        }
    }

    @Nested
    @DisplayName("Commands that turn the rover")
    class TurnTest {

        private final Rover rover;

        public TurnTest() {
            this.rover = new Rover(new Coordonnees(0, 0), Direction.NORTH);
        }

        @Test
        void left() {
            ArrayList<Command> commands = new ArrayList<>();
            commands.add(Command.TURN_LEFT);
            rover.setCommands(commands);
            rover.move();
            assertEquals(Direction.WEST, rover.getDirection());
        }

        @Test
        void rigth() {
            ArrayList<Command> commands = new ArrayList<>();
            commands.add(Command.TURN_RIGHT);
            rover.setCommands(commands);
            rover.move();
            assertEquals(Direction.EAST, rover.getDirection());
        }
    }

}
