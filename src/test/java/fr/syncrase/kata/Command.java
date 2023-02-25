package fr.syncrase.kata;

public enum Command {

    FORWARD {
        public void move(Rover rover) {
            rover.setPosition(new Coordonnees(rover.getPosition(), rover.getDirection(), 1));
        }
    },
    TURN_LEFT {
        public void move(Rover rover) {
            rover.setDirection(rover.getDirection().turn(-1));
        }
    },
    TURN_RIGHT {
        public void move(Rover rover) {
            rover.setDirection(rover.getDirection().turn(1));
        }
    },
    BACKWARD {
        public void move(Rover rover) {
            rover.setPosition(new Coordonnees(rover.getPosition(), rover.getDirection(), -1));
        }
    };

    public abstract void move(Rover rover);
}
