/*  PlayList Extensions:
        > We kept track of artists
        > We made a favoriteArtist method which finds the artist(s) which appear the most on your playlist
 */

package apcs.playList2;

import java.util.ArrayList;
import java.util.Collections;

public class PlayList {

  private final ArrayList<Song> songList;

  PlayList() {
    songList = new ArrayList<>();
  }

  public void add(String newSong) {
    songList.add(new Song(newSong));
  }

  public void add(int index, String newSong) {
    if (index > songList.size() || index < 0)
      throw new RuntimeException("The requested index is out of bounds");
    else
      songList.add(new Song(newSong));
  }

  public void add(String newSong, String artist) {
    songList.add(new Song(newSong, artist));
  }

  public void add(int index, String newSong, String artist) {
    if (index > songList.size() || index < 0)
      throw new RuntimeException("The requested index is out of bounds");
    else
      songList.add(new Song(newSong, artist));
  }

  public int size() {
    return songList.size();
  }

  String getSong(int index) {
    checkOverflow(index);
    return songList.get(index).getSongName();
  }

  int getPlays(int index) {
    checkOverflow(index);
    return songList.get(index).getPlays();
  }

  String play(int index) {
    checkOverflow(index);
    songList.get(index).incrementPlays();
    return songList.get(index).getSongName();
  }

  void remove(int index) {
    checkOverflow(index);
    songList.remove(index);
  }

  public void set(int index, String songName) {
    checkOverflow(index);
    songList.set(index, new Song(songName));
  }

  int indexOf(String songName) {
    for (int i = 0; i < songList.size(); i++)
      if (songName.equals(songList.get(i).getSongName())) {
        return i;
      }
    return -1;
  }

  ArrayList<Song> getMostPlayed() {
    if (songList.isEmpty())
      throw new RuntimeException("The playlist is empty.");

    int maxPlays = 0;
    for (Song val : songList) {
      if (val.getPlays() > maxPlays)
        maxPlays = val.getPlays();

      ArrayList<Song> mostPlayed = new ArrayList<>();
      for (Song song : songList)
        if (song.getPlays() == maxPlays) {
          mostPlayed.add(song);
        }
      return mostPlayed;
    }
    return null;
  }

  ArrayList<String> favoriteArtists() {
    if (songList.isEmpty())
      throw new RuntimeException("The playlist is empty.");

    ArrayList<String> artists = new ArrayList<>();
    for (Song val : songList)
      if (val.getArtist() != null) {
        artists.add(val.getArtist());
      }

    int highestFrequency = 0;
    ArrayList<String> favoriteArtists = new ArrayList<>();
    for (String val : artists)
      if (Collections.frequency(artists, val) >= highestFrequency) {
        highestFrequency = Collections.frequency(artists, val);
      }

    for (String val : artists)
      if (Collections.frequency(artists, val) == highestFrequency
          && Collections.frequency(favoriteArtists, val) < 1) {
        favoriteArtists.add(val);
      }

    return favoriteArtists;
  }

  void rate(int index, int rating) {
    checkOverflow(index);
    if (rating < 1 || rating > 5)
      throw new RuntimeException("Please rate between 1-5.");

    songList.get(index).setRating(rating);
  }

  ArrayList<Song> getFavorite() {
    if (songList.isEmpty())
      throw new RuntimeException("The playlist is empty.");

    int maxRating = 0;
    for (Song val : songList) {
      if (val.getRating() > maxRating)
        maxRating = val.getRating();

      ArrayList<Song> favorites = new ArrayList<>();
      for (Song song : songList)
        if (song.getRating() == maxRating) {
          favorites.add(song);
        }
      return favorites;
    }
    return null;
  }

  private void checkOverflow(int index) {
    if (index > songList.size() - 1 || index < 0)
      throw new RuntimeException("The requested index is out of bounds");
  }

  @Override
  public String toString() {

    System.out.println(songList);

    if (songList.isEmpty())
      return "The playlist is empty";
    else {
      StringBuilder playListString = new StringBuilder();
      for (int i = 0; i < songList.size(); i++)
        playListString.append(i).append(": ").append(songList.get(i))
            .append("; \n");
      return playListString.toString();
    }
  }
}