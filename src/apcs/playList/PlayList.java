package apcs.playList;

/**
 * A Java class that manages a playlist of songs.
 * Each song has a title and records the number of times it has been played.
 * The class provides methods to add songs to a playlist,
 * retrieve/print the playlist, change songs, and remove songs (among other functions).
 *
 * By JP and Sidd
 */



public class PlayList {
    private String[] songs;
    private int[] plays;
    private int size;

    /**
     * Creates a new instance of PlayList with a specified capacity
     *
     * Precondition: capacity is greater than 0, and less than the max array size limit.
     * Postcondition: Initializes songs as a new array of Strings of size capacity, initializes plays as a new array of ints size capacity, sets size to 0.
     *
     * @param capacity the total capacity of the playlist
     */
    public PlayList(int capacity) {
        this.songs = new String[capacity];
        this.plays = new int[capacity];
        this.size = 0;
    }

    /**
     * Returns the current effective size (the value of the size instance variable)
     *
     * @return current effective size
     */
    public int size() {
        return this.size;
    }

    /**
     * Returns the current effective capacity based on the length of the songs Array
     *
     * @return current effective capacity
     */
    public int capacity() {
        return songs.length;
    }

    /**
     * Adds a song to the array, checking if there is room in the array for the new value (if not, expands the array).
     * Sets the appropriate element of the songs array to the passed song name parameter
     * so that the new song name is added to the "end" of the list.
     * Then increments size by 1 to reflect the new list size.
     *
     * Postcondition: Adds the song to the array, sets the corresponding plays to 0, and increments size by 1
     *
     * @param newSong name of the song to be added to the list
     */
    public void add(String newSong) {
        if(size() == capacity()) {
            expand();
        }
        songs[size] = newSong;
        plays[size] = 0;
        size++;

    }

    /**
     * Similar to the other add method, but accepts an index for where the requested song is to be added.
     *
     * Precondition: The index for where the requested song is to be added should be no more than the index of an array 1.5x the
     * original size of the array.
     * Postcondition: The new song is added to the requested index.
     *
     * @param indexOfRequestedSong the index of the requested song
     * @param newSong the string of the new song being added
     * @throws RuntimeException when the array index is {@literal <} 0 or {@literal >}= the list size
     */
    public void add(int indexOfRequestedSong, String newSong) {

        if(size() == capacity()) {
            expand();
        }
        if(size() < indexOfRequestedSong) {
            throw new RuntimeException("The requested index is out of bounds (less than 0 or greater than or equal to the list size)");
        }
        if (capacity() - 1 - indexOfRequestedSong >= 0) {
            System.arraycopy(songs, indexOfRequestedSong, songs, indexOfRequestedSong + 1, capacity() - 1 - indexOfRequestedSong);
        }

        plays[indexOfRequestedSong] = 0;

        songs[indexOfRequestedSong] = newSong;
        size++;

    }

    /**
     * Returns the song stored at the requested index
     *
     * Precondition: The requested index is in the playlist
     *
     * @param indexOfRequestedSong the index of the requested song
     * @return the song at the requested index
     * @throws RuntimeException when the array index is {@literal <} 0 or {@literal >}= the list size
     */
    public String getSong(int indexOfRequestedSong) {
        checkOutOfBounds(indexOfRequestedSong);

        return songs[indexOfRequestedSong];

    }

    /**
     * Gets the number of plays from the index of a requested song.
     *
     * @param indexOfRequestedSong the index of the requested song
     * @return number of plays from the index of a requested song
     * @throws RuntimeException when the array index is {@literal <} 0 or {@literal >}= the list size
     */
    public int getPlays(int indexOfRequestedSong) {
        checkOutOfBounds(indexOfRequestedSong);

        return plays[indexOfRequestedSong];
    }

    /**
     * "Plays" a song that is located at the requested index
     *
     * Preconditions: The requested index is in the playlist
     * Postconditions: Increments the number of plays for that song by 1
     *
     *
     * @param indexOfRequestedSong the index of the requested song
     * @return The song name of the song at the requested index
     * @throws RuntimeException when the array index is {@literal <} 0 or {@literal >}= the list size
     */
    public String play(int indexOfRequestedSong) {
        checkOutOfBounds(indexOfRequestedSong);

        plays[indexOfRequestedSong]++;
        return getSong(indexOfRequestedSong);

    }

    /**
     * Loops through the songs array, locating the song that you are searching for and returning its index.
     *
     * @param songName the name of the song you are finding the index of
     * @return the index of the found song, or -1 if the song cannot be found
     */
    public int indexOf(String songName) {
        for(int i = 0; i < capacity(); i++) {
            if(songs[i].equals(songName)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Removes a song and its number of plays from the playlist
     *
     * Preconditions: The requested index must be less than the size of the playlist or greater than or equal to 0
     * Postconditions: Removes one from the songs and plays array and decrements size by 1
     *
     * @param indexOfRequestedSong index of requested song
     * @throws RuntimeException when the array index is {@literal <} 0 or {@literal >}= the list size
     */
    public void remove(int indexOfRequestedSong) {
        if(indexOfRequestedSong >= size() || indexOfRequestedSong < 0) {
            throw new RuntimeException("The requested index is out of bounds (less than 0 or greater than or equal to the list size)");
        }

        if (capacity() - (indexOfRequestedSong + 1) >= 0) {
            System.arraycopy(songs, indexOfRequestedSong + 1, songs, indexOfRequestedSong + 1 - 1, capacity() - (indexOfRequestedSong + 1));
        }

        songs[capacity() - 1] = "";


        if (plays.length - (indexOfRequestedSong + 1) >= 0) {
            System.arraycopy(plays, indexOfRequestedSong + 1, plays, indexOfRequestedSong + 1 - 1, plays.length - (indexOfRequestedSong + 1));
        }

        plays[plays.length - 1] = 0;

        size--;
    }

    /**
     * Sets the value of the songs array stored at the index to the passed song name value
     *
     * @param indexOfRequestedSong index of requested song
     * @param songName the song name
     * @throws RuntimeException when the array index is {@literal <} 0 or {@literal >}= the list size
     */
    public void set(int indexOfRequestedSong, String songName) {
        checkOutOfBounds(indexOfRequestedSong);
        songs[indexOfRequestedSong] = songName;
        plays[indexOfRequestedSong] = 0;
    }

    /**
     * Returns the most played song
     *
     * Preconditions: The playlist must have something
     *
     * @return the name of the song with the most plays
     * @throws RuntimeException when the array index is {@literal <} 0 or {@literal >}= the list size
     */
    public String getFavorite() {
        if(size() == 0) {
            throw new RuntimeException("The list is empty");
        }

        int max = 0;
        String favoriteSong = "";
        for(int i = 0; i < capacity(); i++) {
            if(plays[i] > max) {
                max = plays[i];
                favoriteSong = songs[i];
            }
        }
        return favoriteSong;


    }

    /**
     * Helper method to check if an array index is out of bounds in the songs array.
     *
     * @param indexOfRequestedSong index of requested song
     * @throws RuntimeException when the array index is {@literal <} 0 or {@literal >}= the list size
     */
    private void checkOutOfBounds(int indexOfRequestedSong) {
        if(indexOfRequestedSong >= size() || indexOfRequestedSong < 0) {
            throw new RuntimeException("The requested index is out of bounds (less than 0 or greater than or equal to the list size)");
        }
    }

    /**
     * Expands the capacity of the list so that the new items can be added by 1.5x.
     */
    private void expand() {
        String[] newSongs = new String[(int) Math.ceil(capacity() * 1.5)];
        if (capacity() >= 0) System.arraycopy(songs, 0, newSongs, 0, size());

        int[] newPlays = new int[(int) Math.ceil(capacity() * 1.5)];
        if (capacity() >= 0) System.arraycopy(plays, 0, newPlays, 0, size());

        songs = newSongs;
        plays = newPlays;

    }

    @Override
    public String toString() {

        if(size() == 0) {
            return "The playlist is empty.";
        }
        StringBuilder output = new StringBuilder();

        for(int i = 0; i < size(); i++) {
            output.append(i).append(": Title: ").append(songs[i]).append("; Plays: ").append(plays[i]).append("\n");
        }

        return output.toString();
    }
}