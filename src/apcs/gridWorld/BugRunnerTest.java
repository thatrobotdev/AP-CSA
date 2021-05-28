package apcs.gridWorld;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class BugRunnerTest {
    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        Bug buggy = new Bug();
        world.add(buggy);
        world.add(new Rock());



        world.show();
        buggy.moveTo(new Location(1, 3));
    }
}
