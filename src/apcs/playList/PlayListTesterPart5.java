package apcs.playList;

public class PlayListTesterPart5 {
    public static void main(String[] args) {

        java.lang.System.setErr(java.lang.System.out);  // this synchronizes regular output and error messages

        System.out.println ("Testing Constructor");
        PlayList eighties = new PlayList (20);
        System.out.println ("size: " + eighties.size());
        System.out.println ("max size: " + eighties.capacity());


        System.out.println ("Testing add and toString");
        System.out.println ("List is:\n" + eighties);
        eighties.add ("The Final Countdown");
        eighties.add ("Livin' on a Prayer");
        System.out.println ("Your list has " + eighties.size() + " items.");
        System.out.println ("List is:\n" + eighties);
        for (int i = 2; i<20; i++) {
            System.out.println("Adding a song named: Song "+i);
            eighties.add ("Song " + i);
        }
        try {
            System.out.println("\nAttempt to add a song that will exceed the capacity of the list (will expand list):");
            eighties.add ("Song 20");
        } catch (Exception e) {
            System.out.println("Error: ");
            e.printStackTrace();
        }
        System.out.println ("\nYour list has " + eighties.size() + " items.");
        System.out.println ("Your list has a capacity of " + eighties.capacity() + " items.");
        System.out.println ("List is:\n" + eighties);

        System.out.println("\nAdding more to the middle to test a second expand:\n");
        for (int i = 21; i<32; i++) {
            System.out.println("Adding a song named: Song "+i);
            eighties.add (10, "Song " + i);
        }
        System.out.println ("\nYour list has " + eighties.size() + " items.");
        System.out.println ("Your list has a capacity of " + eighties.capacity() + " items.");
        System.out.println ("List is:\n" + eighties);

    }
}
