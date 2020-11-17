package apcs.gridWorld;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;

public class BugRunner {
    public static void main(String[] args) {
        Grid<Actor> grid = new BoundedGrid<>(20, 40);
        ActorWorld world = new ActorWorld(grid);

        world.add(new Bug());
        world.add(new Rock());
        world.add(new Actor());
        world.add(new MyActor());
        world.add(new LeftyBug());

        world.show();
    }
}
