package apcs.playList2;

import java.util.ArrayList;

public class PlayListTester {
    public static void main(String[] args) {

        java.lang.System.setErr(java.lang.System.out);  // this synchronizes regular output and error messages

        System.out.println("Testing Default Constructor");
        PlayList eighties = new PlayList();

        System.out.print("size (0): ");
        try {
            System.out.println(eighties.size());
        } catch (Exception e) {
            System.out.println("Error: ");
            e.printStackTrace();
        }

        System.out.print("List is (Empty List): ");
        try {
            System.out.println(eighties);
        } catch (Exception e) {
            System.out.println("Error: ");
            e.printStackTrace();
        }
        System.out.println("\nTesting add (to the end): add 20 Songs");

        try {
            eighties.add("Take on Me");
            eighties.add("Girls Just Want to Have Fun");
            eighties.add("When Doves Cry");
            eighties.add("Every Breath You Take");
            eighties.add("Livin' on a Prayer");
            eighties.add("Push It");
            eighties.add("Sweet Child o' Mine");
            eighties.add("Wake Me Up Before You Go-Go");
            eighties.add("Call Me");
            eighties.add("What's Love Got to Do With It");
            eighties.add("Bust a Move");
            eighties.add("We Got the Beat");
            eighties.add("Don't Stop Believin'");
            eighties.add("It's Tricky");
            eighties.add("Love Is a Battlefield");
            eighties.add("Like a Prayer");
            eighties.add("Dancing in the Dark");
            eighties.add("Another One Bites the Dust");
            eighties.add("Eye of the Tiger");
            eighties.add("Sweet Dreams (Are Made of This)");

            System.out.println("\nTesting toString: prints 20 Songs + plays\n");

            System.out.println(eighties);
        } catch (Exception e) {
            System.out.println("Error: ");
            e.printStackTrace();
        }

        System.out.println("\nTesting getSong and getPlays - print 20 songs using loop\n");

        try {
            for (int i = 0; i < eighties.size(); i++) {
                System.out.println(i + ": Title: " + eighties.getSong(i) + "; Plays: " + eighties.getPlays(i));
            }
        } catch (Exception e) {
            System.out.println("Error: ");
            e.printStackTrace();
        }

        System.out.println("\nTesting play - play all songs once and last song 3 times and print\n");

        try {
            for (int i = 0; i < eighties.size(); i++) {
                eighties.play(i);
            }
            eighties.play(eighties.size() - 1);
            eighties.play(eighties.size() - 1);

        } catch (Exception e) {
            System.out.println("Error: ");
            e.printStackTrace();
        }
        System.out.println(eighties);

        // test indexOf

        System.out.println("\nTesting indexOf");
        try {
            System.out.println("Locating item 0:" + eighties.indexOf("Take on Me"));
            System.out.println("Locating item 9:" + eighties.indexOf("What's Love Got to Do With It"));
            System.out.println("Locating item 19:" + eighties.indexOf("Sweet Dreams (Are Made of This)"));
            System.out.println("Locating an item that doesn't exist (-1):" + eighties.indexOf("Thriller"));

        } catch (Exception e) {
            System.out.println("Error: ");
            e.printStackTrace();
        }

        // test remove

        System.out.print("\nTesting remove\n");
        try {

            System.out.println("Remove last song: "+eighties.getSong(19));
            eighties.remove(19);
            System.out.println("List now has "+eighties.size() + " items:");
            System.out.println(eighties);

            System.out.println("\nRemove first song: "+eighties.getSong(0));
            eighties.remove(0);
            System.out.println("List now has "+eighties.size() + " items:");
            System.out.println(eighties);

        } catch (Exception e) {
            System.out.println("Error: ");
            e.printStackTrace();
        }
        System.out.println("\nAttempt to remove from an invalid index (19) (will throw an Exception)\n");
        try {
            eighties.remove(19);
        } catch (Exception e) {
            System.out.println("Error: ");
            e.printStackTrace();
        }
        System.out.println("\nRemove remaining items in random order\n");
        try {
            while (eighties.size() > 0) {
                int index = (int) (Math.random() * eighties.size());
                System.out.println("Removing item " + index + " (" + eighties.getSong(index) + ")");
                eighties.remove(index);
                System.out.println("List now has "+eighties.size() + " items:");
                System.out.println(eighties);
            }
        } catch (Exception e) {
            System.out.println("Error: ");
            e.printStackTrace();
        }
        System.out.println("\nAttempt to remove from an empty list (will throw an Exception)\n");
        try {
            eighties.remove(0);
        } catch (Exception e) {
            System.out.println("Error: ");
            e.printStackTrace();
        }

        System.out.println("\nTesting add (by index)");

        try {
            eighties.add(0, "Take on Me");
            eighties.add(0, "Girls Just Want to Have Fun");
            eighties.add(1, "When Doves Cry");
            eighties.add(2, "Every Breath You Take");
            eighties.add(4, "Livin' on a Prayer");
            eighties.add(0, "Push It");
            eighties.add(3, "Sweet Child o' Mine");
            eighties.add(5, "Wake Me Up Before You Go-Go");
            eighties.add(2, "Call Me");
            eighties.add(1, "What's Love Got to Do With It");
            eighties.add(10, "Bust a Move");
            eighties.add(0, "We Got the Beat");
            eighties.add(9, "Don't Stop Believin'");
            eighties.add(10, "It's Tricky");
            eighties.add(12, "Love Is a Battlefield");
            eighties.add(7, "Like a Prayer");
            eighties.add(3, "Dancing in the Dark");
            eighties.add(17, "Another One Bites the Dust");
            eighties.add(17, "Eye of the Tiger");
            eighties.add(19, "Sweet Dreams (Are Made of This)");
            eighties.play(0);
            eighties.play(eighties.size() - 1);

        } catch (Exception e) {
            System.out.println("Error: ");
            e.printStackTrace();
        }
        System.out.println("\nNew List is (list of songs, only songs 0 and 19 are played): \n" + eighties);

        System.out.println("\nAttempt to add to an invalid index (will throw an Exception)\n");
        try {
            eighties.add(22, "With or Without You");
        } catch (Exception e) {
            System.out.println("Error: ");
            e.printStackTrace();
        }

        System.out.println("\nTesting get/set");

        try {

            String tempFirstSong = eighties.getSong(0);
            String tempLastSong = eighties.getSong(eighties.size() - 1);

            eighties.set(0, tempLastSong);
            eighties.set(eighties.size() - 1, tempFirstSong);

            System.out.println("\nList should now have the first and last items swapped (no plays)\n" + eighties);
        } catch (Exception e) {
            System.out.println("Error: ");
            e.printStackTrace();
        }
        System.out.println("\nAttempt to get from an invalid index (will throw an Exception)\n");
        try {
            eighties.getSong(22);
        } catch (Exception e) {
            System.out.println("Error: ");
            e.printStackTrace();
        }
        System.out.println("\nAttempt to set an invalid index (will throw an Exception)\n");
        try {
            eighties.set(22, "With or Without You");
        } catch (Exception e) {
            System.out.println("Error: ");
            e.printStackTrace();
        }

        //test get favorites

        try {
            for (int i = 0; i < eighties.size(); i++) {
                eighties.rate(i, (int) (Math.random() * 5 + 1));
            }
            System.out.println("\nList:\n" + eighties);

            ArrayList<Song> fav = eighties.getFavorite();
            System.out.println("\nThe Favorite songs are:\n" + fav);
        } catch (Exception e) {
            System.out.println("Error: ");
            e.printStackTrace();
        }

        //test get most-played

        try {
            for (int i = 0; i < 100; i++) {
                eighties.play((int) (Math.random() * eighties.size()));
            }
            System.out.println("\nList:\n" + eighties);

            ArrayList<Song> most = eighties.getMostPlayed();
            System.out.println("\nThe most-played songs are:\n" + most);
        } catch (Exception e) {
            System.out.println("Error: ");
            e.printStackTrace();
        }

        // Testing artist

        System.out.println("Adding a song with an artist");

        PlayList artistTester = new PlayList();
        artistTester.add("Song", "Artist");

        System.out.println("Adding a song with an artist at a specified index");

        artistTester.add(1, "Song", "Artist");

        System.out.println(artistTester);

        System.out.println("Creating new playlist with 10 songs.");

        PlayList favoriteArtistTester = new PlayList();
        favoriteArtistTester.add("It's Everyday Bro", "Jake Paul");
        favoriteArtistTester.add("my future", "Billie Eilish");
        favoriteArtistTester.add("F2020", "Avenue Beat");
        favoriteArtistTester.add("Your New Boyfriend", "Wilbur Soot");
        favoriteArtistTester.add("Your Sister Was Right", "Wilbur Soot");
        favoriteArtistTester.add("Fresh Outta London", "Jake Paul");
        favoriteArtistTester.add("Since I Saw Vienna", "Wilbur Soot");
        favoriteArtistTester.add("Maniac", "Conan Gray");
        favoriteArtistTester.add("Champion", "Jake Paul");
        favoriteArtistTester.add("drivers license", "Olivia Rodrigo");

        System.out.println(favoriteArtistTester);

        System.out.println("Finding favorite artists.");

        System.out.println(favoriteArtistTester.favoriteArtists());


    }

}