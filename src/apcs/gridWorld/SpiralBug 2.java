package apcs.gridWorld;

import info.gridworld.actor.Bug;

import java.awt.*;
import java.util.Random;

public class SpiralBug extends Bug {
    private int steps;
    private int sideLength;

    public SpiralBug(int length) {
        steps = 0;
        sideLength = length;
    }

    public SpiralBug() {
        steps = 0;
        sideLength = 4;
    }

    public void act() {
        Random rand = new Random();
        this.setColor(new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat()));
        if (steps < sideLength && canMove()) {
            move();
            steps++;
        } else {
            turn();
            turn();
            sideLength++;
            steps = 0;
        }
    }
}

