package apcs.gridWorld;

import info.gridworld.actor.Bug;

import java.awt.*;
import java.util.Random;

public class CircleBug extends Bug {
    private int steps;
    private final int sideLength;

    public CircleBug(int length) {
        steps = 0;
        sideLength = length;
    }

    public void act() {
        Random rand = new Random();
        this.setColor(new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat()));
        if (steps < sideLength && canMove()) {
            move();
            steps++;
        } else {
            turn();
            steps = 0;
        }
    }
}

