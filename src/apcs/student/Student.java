package apcs.student;

import java.util.Arrays;

/**
 * This class models a single Student and their test scores.
 *
 * @author JP Kerrane (hi@jameskerrane.com)
 * @version 1.0.0
 */

public class Student {
    private String name;
    private final int id;
    private double[] scores = new double[0];

    /**
     * Creates a new instance of Student with the specific id number.
     *
     * @since 1.0.0
     * @param id The student's id
     */

    public Student(int id) {
        this.id = id;
    }

    /**
     * Creates a new instance of Student with a name, id, and two test scores.
     * The score in test1 and test2 must be 0.0 through 100.0.
     *
     * @since 1.0.0
     * @param name The student's name
     * @param id The student's id number
     * @param test1 The student's first test score
     * @param test2 The student's second test score
     */

    public Student(String name, int id, double test1, double test2) {
        this.setName(name);
        this.id = id;
        this.setScore(1, test1);
        this.setScore(2, test2);
    }

    /**
     * Creates a new instance of Student with a name, id, and one test score.
     * The score is test1 must be 0.0 through 100.0.
     *
     * @param name The student's name
     * @param id The student's id number
     * @param test1 The student's first test score
     */

    public Student(String name, int id, double test1) {
        this.setName(name);
        this.id = id;
        this.setScore(1, test1);
    }

    /**
     * Gets the student's name.
     *
     * @since 1.0.0
     * @return The student's name.
     */

    public String getName() {
        return this.name;
    }

    /**
     * Sets the student's name.
     *
     * @since 1.0.0
     * @param name The student's name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the student's id.
     *
     * @since 1.0.0
     * @return The student's id.
     */

    public int getId() {
        return this.id;
    }

    /**
     * Gets the student's test score that matches the test number. If the test does not exist, -1.0 will be returned.
     *
     * @since 1.0.0
     * @param test The test's number that you want to get a test score from.
     * @return The student's test score that matches the test number. If the test does not exist, -1.0 will be returned.
     */

    public double getScore(int test) {
        int index = test - 1; // Convert test into java index (test scores start being stored at 0)
        if(index >= 0 && getScores().length >= index) { // Test if the index falls within the array
            return getScores()[index];
        } else {
            return -1.0;
        }
    }

    /**
     * Gets the full array of test scores for a student. Empty scores will be filled with a placeholder of -1.0.
     *
     * @since 1.0.0
     * @return Array of test scores for a student.
     */

    public double[] getScores() {
        return scores;
    }

    /**
     * Sets/Updates a test score for a Student. Returns -1.0 if the test does not exist.
     *
     * @since 1.0.0
     * @param test The test number to update.
     * @param score The new score
     * @throws IllegalArgumentException if test {@literal <=} 0 or score is not 0.0 through 100.0.
     */

    public void setScore(int test, double score) {
        if(test <= 0) throw new IllegalArgumentException("The test number must be greater than 0.");
        if(score != -1.0 && (score < 0.0 || score > 100.0)) throw new IllegalArgumentException("The new score must be 0.0 through 100.0.");

        int index = test - 1; // Convert test into java index (test scores start being stored at 0)

        // If array is too small to set the score
        if(test > getScores().length) {
            int oldSize = getScores().length;
            this.scores = Arrays.copyOf(getScores(), test); // Create new array with copy of old array, adding to the size
            int newSize = getScores().length;
            for(int i = oldSize; i < newSize; i++) { // Fill empty test scores with -1
                if(getScores()[i] == 0) {
                    setScore(i + 1, -1.0);
                }
            }
        }

        getScores()[index] = score;
    }

    /**
     * Calculates and returns the average of any tests taken.
     *
     * @since 1.0.0
     * @return The average test score or -1.0 if none have been taken yet.
     */

    public double getAverage() {
        return Arrays.stream(getScores()).filter(i -> i != -1).average().orElse(-1.0); // Filter out zeroes in average calculation, then calculate average. (if empty, return -1.0)
    }

    /**
     * Gets the maximum test score for a student.
     *
     * @since 1.0.0
     * @return The maximum test score for a student.
     */

    public double getMaximum() {
        return Arrays.stream(getScores()).max().orElse(-1.0); // Returns maximum of array (if empty, return -1.0)
    }

    /**
     * Converts the object to a string with all of the data for a student. Whenever there are empty test scores, -1.0 will be filled in as a placeholder.
     *
     * @since 1.0.0
     * @return All of the data for a student. Whenever there are empty test scores, -1.0 will be filled in as a placeholder.
     */

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", testScores=" + Arrays.toString(getScores()) +
                '}';
    }

    /**
     * Returns whether the two students are the same. This is determined if the students have matching ID numbers or not.
     *
     * @since 1.0.0
     * @param other Object to compare to
     * @return Whether the two students are the same.
     */

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Student student = (Student) other;
        return getId() == student.getId();
    }


}