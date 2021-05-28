package apcs.gridWorld;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Grid;
import info.gridworld.grid.UnboundedGrid;

public class Exercises {
    public static void main(String[] args) {
        Grid<Actor> grid = new UnboundedGrid<>();
        ActorWorld world = new ActorWorld(grid);

        world.add(new CircleBug(4));
        world.add(new SpiralBug());
        world.add(new ZBug(4));

        world.show();
    }
}
