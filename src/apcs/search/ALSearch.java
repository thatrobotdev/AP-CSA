package apcs.search;

import java.util.ArrayList;
import java.util.Collections;

public class ALSearch {

  public static void main(String[] args) {
    // create an array list
    ArrayList<Integer> ints = new ArrayList<>();
    // fill with random values
    for (int i = 0; i < 20; i++)
      ints.add((int) (Math.random() * 20));
    // print list
    System.out.println("The list is: \n" + ints);

    // search for all possible values
    for (int i = 0; i < 20; i++) {
      int loc = ints.indexOf(i);
      System.out.println("The value " + i + " is at position " + loc);
    }

    System.out.println("\nRepeating using your linearSearch");
    // repeat using your own linearSearch method
    for (int i = 0; i < 20; i++) {
      int loc = ALSearch.linearSearch(ints, i);
      System.out.println("The value " + i + " is at position " + loc);
    }

    System.out.println("\nSorting List");
    // sort the list
    Collections.sort(ints);

    // print list
    System.out.println("The list is now: \n" + ints);

    System.out.println("\nRepeating using your binarySearch");
    // repeat using your own binarySearch method
    for (int i = 0; i < 20; i++) {
      int loc = ALSearch.binarySearch(ints, i);
      System.out.println("The value " + i + " is at position " + loc);
    }
  }

  private static int linearSearch(ArrayList<Integer> vals, Integer item) {
    // loop through the arraylist
    // for each item in the list, check to see if it is the item
    for (int i = 0; i < vals.size(); i++)
      if (vals.get(i).equals(item)) {
        return i; // if it is, immediately return its position
      }

    // if you go through the entire loop without finding it, return -1
    return -1;
  }

  private static int binarySearch(ArrayList<Integer> vals, Integer item) {
    // set up a start and end index to 0 and size()-1
    int low = 0;
    int high = vals.size() - 1;

    // repeat as long as start and end are valid index values (end must be >= start)
    while (low <= high) {
      int mid = (low + high) / 2;
      // check the value at the midpoint to see if it the item
      // if it is, return its position (the midpoint)
      if (vals.get(mid).equals(item))
        return mid;
      else // if item comes "after" the midpoint, adjust the start index to narrow the search range by half
        //if item comes "before" the midpoint, adjust the end index to narrow the search range by half
        if (vals.get(mid) < item)
          low = mid + 1;
        else
          high = mid - 1;
    }

    return -1;

  }

}


