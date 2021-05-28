package apcs.gridWorld;

import info.gridworld.actor.Bug;

import java.awt.*;
import java.util.Random;

public class ZBug extends Bug {
    private int steps;
    private int side;
    private final int sideLength;
    private boolean done = false;

    public ZBug(int length) {
        steps = 0;
        sideLength = length;
        side = 0;
    }

    public void act() {
        Random rand = new Random();
        this.setColor(new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat()));
            if(steps == sideLength || side == 0) {
                switch(side) {
                    case 3:
                        done = true;
                        break;
                    case 2:
                        turn();
                        turn();
                    case 1:
                        turn();
                    case 0:
                        turn();
                        turn();
                    default:
                        steps = 0;
                        side++;
                }
            }
        if(!done) {
            move();
            steps++;
        }
    }
}