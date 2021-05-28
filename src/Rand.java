public class Rand {

    public static void main(String[] args) {
        randIED(0.0, 10.0);
        randIED(0.0, 100.0);
        randIED(5.0, 6.0);
        randIED(-10.0, 10.0);
        randIEI(0, 100);
        randIII(1, 52);
        randTwoDiceII(1, 6);

    }

    static void randIED(double inclusive, double exclusive) { // Generate and print a double (inclusive, exclusive)
        double range = exclusive - inclusive;
        double r = (Math.random() * range) + inclusive;
        System.out.println("[" + inclusive + ", " + exclusive + "): " + r);
    }

    static void randIEI(int inclusive, int exclusive) { // Generate and print a int (inclusive, exclusive)
        int range = exclusive - inclusive;
        int r = (int)((Math.random() * range)) + inclusive;
        System.out.println("[" + inclusive + ", " + exclusive + "): " + r);
    }

    static int randIII(int inclusive1, int inclusive2) { // Generate and print a int (inclusive, inclusive)
        int range = inclusive2 - inclusive1;
        int r = (int)((Math.random() * (range + 1))) + inclusive1;
        System.out.println("[" + inclusive1 + ", " + inclusive2 + "]: " + r);
        return r;
    }

    static void randTwoDiceII(int inclusive1, int inclusive2) { // Generate and print TWO ints and print their sum (like dice)
        int r1 = randIII(inclusive1, inclusive2);
        int r2 = randIII(inclusive1, inclusive2);
        System.out.println("Sum of 2x [" + inclusive1 + ", " + inclusive2 + "]: " + (r1 + r2));
    }
    
}
