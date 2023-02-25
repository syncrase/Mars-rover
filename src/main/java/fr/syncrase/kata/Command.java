package fr.syncrase.kata;

public enum Command {

    FORWARD {
        public void move(Rover rover) {
            rover.go(1);
        }
    },
    TURN_LEFT {
        public void move(Rover rover) {
            rover.turn(-1);
        }
    },
    TURN_RIGHT {
        public void move(Rover rover) {
            rover.turn(1);
        }
    },
    BACKWARD {
        public void move(Rover rover) {
            rover.go(-1);
        }
    };

    public abstract void move(Rover rover);
}
