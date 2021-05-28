package apcs.gridWorld;

import info.gridworld.actor.Bug;

import java.awt.*;

public class LeftyBug extends Bug {
    public LeftyBug() {
        this.setColor(Color.ORANGE);
    }

    @Override
    public void turn() {
        this.setDirection(this.getDirection() - 45);
    }

}
