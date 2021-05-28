package apcs.playList2;

import java.util.Objects;

public class Song {

  private String name;
  private String artist;
  private int plays;
  private int rating;

  Song(String name) {
    this.name = name;
    plays = 0;
    rating = 0;
  }

  Song(String name, String artist) {
    this.name = name;
    this.artist = artist;
    plays = 0;
    rating = 0;
  }

  @Override
  public String toString() {
    String output = "Title: " + name;
    if (!Objects.isNull(artist))
      output += " by " + artist;
    output += "; Plays: " + plays;

    if (rating == 0)
      output += "; Rating: Not Rated";
    else
      output += "; Rating: " + rating;
    return output;
  }

  String getSongName() {
    return name;
  }

  public void setSongName(String songName) {
    name = songName;
  }

  int getPlays() {
    return plays;
  }

  public void setPlays(int plays) {
    this.plays = plays;
  }

  void incrementPlays() {
    plays++;
  }

  int getRating() {
    return rating;
  }

  void setRating(int rating) {
    this.rating = rating;
  }

  String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }
}