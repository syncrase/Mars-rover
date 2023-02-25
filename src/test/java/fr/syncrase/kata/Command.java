package fr.syncrase.kata;

public enum Command {
    FORWARD {
        public void apply(Rover rover) {
            Coordonnees initialPosition = rover.getPosition();
            rover.setPosition(go(rover.getPosition(), rover.getDirection()));
        }

        public Coordonnees go(Coordonnees position, Direction direction) {

            if (direction == Direction.NORTH) {
                return new Coordonnees(position.getX(), position.getY() + 1);
            } else if (direction == Direction.EAST) {
                return new Coordonnees(position.getX() + 1, position.getY());
            } else if (direction == Direction.SOUTH) {
                return new Coordonnees(position.getX(), position.getY() - 1);
            } else if (direction == Direction.WEST) {
                return new Coordonnees(position.getX() - 1, position.getY());
            }
            return null;
        }
    }, BACKWARD {
        @Override
        public void apply(Rover rover) {
            Coordonnees initialPosition = rover.getPosition();
            rover.setPosition(go(rover.getPosition(), rover.getDirection()));

        }

        public Coordonnees go(Coordonnees position, Direction direction) {

            if (direction == Direction.NORTH) {
                return new Coordonnees(position.getX(), position.getY() - 1);
            } else if (direction == Direction.EAST) {
                return new Coordonnees(position.getX() - 1, position.getY());
            } else if (direction == Direction.SOUTH) {
                return new Coordonnees(position.getX(), position.getY() + 1);
            } else if (direction == Direction.WEST) {
                return new Coordonnees(position.getX() + 1, position.getY());
            }
            return null;
        }
    };

    public abstract void apply(Rover rover);
}
