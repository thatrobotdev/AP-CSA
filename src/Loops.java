public class Loops {
    public static void main(String[] args) {

        /*
        This was part of homework for creating a series of numbers programmatically using loops.
        I used StringBuilder for the first time, as well as many new java classes to me.
         */

        StringBuilder sequence1 = new StringBuilder();
        for(int i = 0; i < 9; i++) { // 0, 1, 2, 3, 4, 5, 6, 7, 8
            sequence1.append(i).append(", ");
        }
        System.out.println(sequence1);

        StringBuilder sequence2 = new StringBuilder();
        for(int i = 7; i < 13; i++) { // 7, 8, 9, 10, 11, 12
            sequence2.append(i).append(", ");
        }
        System.out.println(sequence2);

        StringBuilder sequence3 = new StringBuilder();
        for(int i = 12; i < 31; i += 3) { // 12, 15, 18, 21, 24, 27, 30
            sequence3.append(i).append(", ");
        }
        System.out.println(sequence3);

        StringBuilder sequence4 = new StringBuilder();
        for(int i = 100; i > -1; i -= 2) { // 100, 98, 96, 94, 92, … 4, 2, 0
            sequence4.append(i).append(", ");
        }
        System.out.println(sequence4);

        StringBuilder sequence5 = new StringBuilder();
        for(int i = 0; i < 26; i++) { // Print 25 random numbers in the range [1, 6] on one line
            sequence5.append((int)((Math.random() * 6 + 1))).append(" ");
        }
        System.out.println(sequence5);

        StringBuilder sequence6 = new StringBuilder();
        for(int i = 0; i < 10; i++) { // Print 10 coin-flips on one line
            if(Math.random() < 0.5) {
                sequence6.append("heads ");
            } else {
                sequence6.append("tails ");
            }
        }
        System.out.println(sequence6);

        double r = Math.random();
        while(r <= 0.9) {
            System.out.println(r);
            r = Math.random();
        }
        System.out.println(r);

        StringBuilder sequence7 = new StringBuilder();
        for(int i = 1; i < 11; i++) { // 10 fractions 1/1, 1/2...
            sequence7.append("1/").append(i).append(", ");
        }
        System.out.println(sequence7);

        StringBuilder sequence8 = new StringBuilder();
        for(int i = 1; i < 11; i++) { // Switch between 1 and -1 ten times
            if(i % 2 == 0) {
                sequence8.append("1, ");
            } else {
                sequence8.append("-1, ");
            }
        }
        System.out.println(sequence8);


        int sum = 0;
        int val = 1;
        for(int i = 0; i < 10; i++) { // Add up the numbers 1 to 10 (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10)
            sum += val;
            val++;
        }
        System.out.println(sum);
    }
}
