package fr.syncrase.kata;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
