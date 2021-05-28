package apcs.fraction;

/**
 * This class models a Fraction and implements common operations
 *
 * @author JP Kerrane (hi@jameskerrane.com)
 * @version 1.0.0
 */

public class Fraction {
    private int numerator;
    private int denominator;

    /**
     * Creates a new instance of fraction with a numerator and denominator.
     *
     * @since 1.0.0
     * @param numerator Numerator for the fraction you want to create.
     * @param denominator Denominator for the fraction you want to create.
     */

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Creates a new instance of fraction using a mixed fraction. You supply a whole number and the accompanying fraction.
     *
     * @since 1.0.0
     * @param wholeNumber Whole number for the first part of the fraction.
     * @param mixed Fraction that accompanies the whole number.
     */

    public Fraction(int wholeNumber, Fraction mixed) {
        this.numerator = intToFraction(wholeNumber).add(mixed).getNumerator();
        this.denominator = intToFraction(wholeNumber).add(mixed).getDenominator();
    }

    /**
     * Gives the greatest common denominator for two denominators.
     *
     * @since 1.0.0
     * @param d1 denominator 1
     * @param d2 denominator 2
     * @return greatest common denominator
     */

    private int gcd(int d1, int d2) {
        int gcd = 1;
        for (int i = d1 * d2; i > 0; i--) {
            if (i % d1 == 0 && i % d2 == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    /**
     * Returns the greatest common factor for a fraction.
     *
     * @since 1.0.0
     * @param n numerator
     * @param d denominator
     * @return greatest common factor
     */

    private int gcf(int n, int d) {
        int gcf = 1;
        for (int i = 1; i <= Math.max(n, d); i++) {
            if(n % i == 0 && d % i == 0) {
                gcf = i;
            }
        }
        return gcf;
    }

    /**
     * Takes an integer and creates a new fraction from the integer.
     *
     * @since 1.0.0
     * @param i integer
     * @return fraction from integer
     */

    private Fraction intToFraction(int i) {
        return new Fraction(i, 1);
    }

    /**
     * Takes two fractions, and returns an array with the numerators and a common denominator.
     *
     * @since 1.0.0
     * @param o The other fraction
     * @return array with two ints of simplified numerators
     * @throws ArithmeticException if a fraction is undefined
     */

    private int[] getSameDenominator(Fraction o) {
        int gcd = gcd(this.getDenominator(), o.getDenominator());

        int n1 = this.getNumerator() * (gcd / this.getDenominator());
        int n2 = o.getNumerator() * (gcd / o.getDenominator());

        return new int[]{n1, n2, gcd};
    }

    /**
     * Gets numerator.
     *
     * @since 1.0.0
     * @return numerator
     */

    public int getNumerator() {
        return numerator;
    }

    /**
     * Sets numerator.
     *
     * @since 1.0.0
     * @param numerator What you want to set the numerator to.
     */

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**
     * Gets denominator.
     *
     * @since 1.0.0
     * @return denominator
     */

    public int getDenominator() {
        return denominator;
    }

    /**
     * Sets denominator.
     *
     * @since 1.0.0
     * @param denominator What you want to set the denominator to.
     */

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    /**
     * Adds one fraction with a 2nd fraction.
     *
     * @since 1.0.0
     * @param o 2nd fraction
     * @return result of adding two fractions
     * @throws ArithmeticException if a fraction is undefined
     */

    public Fraction add(Fraction o) {
        this.checkValidOperation(o);

        int n1 = getSameDenominator(o)[0];
        int n2 = getSameDenominator(o)[1];
        int d = getSameDenominator(o)[2];

        return new Fraction(n1 + n2, d).simplify();
    }

    /**
     * Adds a fraction with an int.
     *
     * @since 1.0.0
     * @param addTo int to add to fraction
     * @return result of adding the fraction and the int
     * @throws ArithmeticException if the fraction is undefined
     */

    public Fraction addInt(int addTo) {
        Fraction convertedInt = intToFraction(addTo);
        this.checkValidOperation(convertedInt);
        return this.add(convertedInt).simplify();
    }

    /**
     * Subtracts one fraction from a 2nd fraction.
     *
     * @since 1.0.0
     * @param o 2nd fraction
     * @return result of subtracting two fractions
     * @throws ArithmeticException if a fraction is undefined
     */

    public Fraction subtract(Fraction o) {
        this.checkValidOperation(o);
        return this.add(o.negate()).simplify();
    }

    /**
     * Subtracts an int from the fraction.
     *
     * @since 1.0.0
     * @param subtractFrom int to subtract from the fraction
     * @return result of subtracting the int from the fraction
     * @throws ArithmeticException if a fraction is undefined
     */

    public Fraction subtractInt(int subtractFrom) {
        Fraction convertedInt = intToFraction(subtractFrom);
        this.checkValidOperation(convertedInt);
        return this.subtract(convertedInt).simplify();
    }

    /**
     * Multiplies one fraction with another fraction.
     *
     * @since 1.0.0
     * @param o 2nd fraction
     * @return result of multiplying two fractions
     * @throws ArithmeticException if a fraction is undefined
     */

    public Fraction multiply(Fraction o) {
        this.checkValidOperation(o);
        return new Fraction(this.getNumerator() * o.getNumerator(), this.getDenominator() * o.getDenominator()).simplify();
    }

    /**
     * Multiplies a fraction with an integer.
     *
     * @since 1.0.0
     * @param multiplyWith int to multiply with the fraction
     * @return result of multiplying the int with the fraction
     * @throws ArithmeticException if a fraction is undefined
     */

    public Fraction multiplyInt(int multiplyWith) {
        Fraction convertedInt = intToFraction(multiplyWith);
        this.checkValidOperation(convertedInt);
        return this.multiply(convertedInt).simplify();
    }

    /**
     * Divides one fraction from another fraction.
     *
     * @since 1.0.0
     * @param o 2nd fraction
     * @return result of dividing one fraction from another fraction.
     * @throws ArithmeticException if a fraction is undefined
     */

    public Fraction divide(Fraction o) {
        this.checkValidOperation(o);
        return this.multiply(o.getReciprocal()).simplify();
    }

    /**
     * Divides a fraction with an integer.
     *
     * @since 1.0.0
     * @param divideWith int to multiply with the fraction
     * @return result of dividing the fraction with the integer
     * @throws ArithmeticException if a fraction is undefined
     */

    public Fraction divideInt(int divideWith) {
        Fraction convertedInt = intToFraction(divideWith);
        this.checkValidOperation(convertedInt);
        return this.divide(convertedInt).simplify();
    }

    /**
     * Increments the value of the fraction by 1
     *
     * @since 1.0.0
     * @return the fraction + 1
     * @throws ArithmeticException if the fraction is undefined
     */

    public Fraction increment() {
        this.checkValidOperation();

        return this.add(intToFraction(1)).simplify();
    }

    /**
     * Decrements the value of the fraction by 1
     *
     * @since 1.0.0
     * @return the fraction - 1
     * @throws ArithmeticException if the fraction is undefined
     */

    public Fraction decrement() {
        this.checkValidOperation();

        return this.subtract(intToFraction(1)).simplify();
    }

    /**
     * Negates the fraction (positive {@literal <->} negative)
     *
     * @since 1.0.0
     * @return the negated fraction
     * @throws ArithmeticException if the fraction is undefined
     */

    public Fraction negate() {
        this.checkValidOperation();

        return new Fraction(-this.getNumerator(), this.getDenominator()).simplify();
    }

    /**
     * Simplifies the fraction
     *
     * @since 1.0.0
     * @return the simplified fraction
     * @throws ArithmeticException if the fraction is undefined
     */

    public Fraction simplify() {

        this.checkValidOperation();

        int n = this.getNumerator();
        int d = this.getDenominator();

        int gcf = gcf(n, d);

        n /= gcf;
        d /= gcf;

        return new Fraction(n, d);
    }

    /**
     * Compares if the 1st fraction is greater than the 2nd fraction.
     *
     * @since 1.0.0
     * @param o 2nd fraction
     * @return boolean result
     * @throws ArithmeticException if a fraction is undefined
     */

    public boolean greaterThan(Fraction o) {

        this.checkValidOperation(o);

        if (o == null || getClass() != o.getClass()) return false;

        int[] numerators = this.getSameDenominator(o);
        return numerators[0] > numerators[1];
    }

    /**
     * Compares if the 1st fraction is less than the 2nd fraction.
     *
     * @since 1.0.0
     * @param o 2nd fraction
     * @return boolean result
     * @throws ArithmeticException if a fraction is undefined
     */

    public boolean lessThan(Fraction o) {

        this.checkValidOperation(o);

        if (o == null || getClass() != o.getClass()) return false;

        int[] numerators = this.getSameDenominator(o);
        return numerators[0] < numerators[1];
    }

    /**
     * Compares if the 1st fraction is greater than or equal to the 2nd fraction.
     *
     * @since 1.0.0
     * @param o 2nd fraction
     * @return boolean result
     * @throws ArithmeticException if a fraction is undefined
     */

    public boolean greaterThanOrEqualTo(Fraction o) {

        this.checkValidOperation(o);

        if (o == null || getClass() != o.getClass()) return false;

        int[] numerators = this.getSameDenominator(o);
        return numerators[0] >= numerators[1];
    }

    /**
     * Compares if the 1st fraction is less than or equal to the 2nd fraction.
     *
     * @since 1.0.0
     * @param o 2nd fraction
     * @return boolean result
     * @throws ArithmeticException if a fraction is undefined
     */

    public boolean lessThanOrEqualTo(Fraction o) {

        this.checkValidOperation(o);

        if (o == null || getClass() != o.getClass()) return false;

        int[] numerators = this.getSameDenominator(o);
        return numerators[0] <= numerators[1];
    }

    /**
     * Turns the fraction into its reciprocal (numerator/denominator {@literal ->} denominator/numerator)
     *
     * @since 1.0.0
     * @return the reciprocal of the fraction
     * @throws ArithmeticException if the fraction is undefined
     */

    public Fraction getReciprocal() {
        this.checkValidOperation();
        return new Fraction(this.getDenominator(), this.getNumerator()).simplify();
    }

    /**
     * Checks if an operation is valid. Throws an exception if a fraction is undefined (the denominator is 0). Gives explanation with the 2 values compared.
     *
     * @since 1.0.0
     * @throws ArithmeticException if the fraction is undefined
     */

    private void checkValidOperation(Fraction o) {
        if(this.isUndefined() || o.isUndefined()) {
            throw new ArithmeticException("Cannot perform operation on an undefined fraction. Compared " + this + " with " + o);
        }
    }

    /**
     * Checks if an operation is valid. Throws an exception if a fraction is undefined (the denominator is 0).
     *
     * @since 1.0.0
     * @throws ArithmeticException if the fraction is undefined
     */

    private void checkValidOperation() {
        if(this.isUndefined()) {
            throw new ArithmeticException("Cannot perform operation on an undefined fraction.");
        }
    }

    /**
     * Checks if a fraction is undefined.
     *
     * @since 1.0.0
     * @return boolean check
     */

    public boolean isUndefined() {
        return this.getDenominator() == 0;
    }

    /**
     * Gets the fraction as a mixed fraction.
     *
     * @since 1.0.0
     * @return a mixed fraction
     * @throws ArithmeticException if the fraction is undefined
     */

    public String getMixed() {
       Fraction simplified = this.simplify();
       int numerator = simplified.getNumerator();
       int denominator = simplified.getDenominator();
       int wholeNumber = numerator / denominator;
       int remainder = numerator % denominator;

       return wholeNumber + " " + remainder + " / " + denominator;
    }

    /**
     * Converts the fraction to a string in the format: numerator / denominator
     *
     * @since 1.0.0
     * @return "numerator / denominator"
     */

    @Override
    public String toString() {
        if(this.isUndefined()) {
            return "undefined";
        }
        return this.getNumerator() + " / " + this.getDenominator();
    }

    /**
     * Checks if a fraction is equal to another fraction
     *
     * @since 1.0.0
     * @param o The 2nd fraction
     * @return boolean result
     * @throws ArithmeticException if a fraction is undefined
     */

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Fraction f2 = (Fraction) o;
        this.checkValidOperation(f2);
        Fraction f1 = this.simplify();
        f2 = f2.simplify();

        if (this == o) return true;

        return f1.getNumerator() == f2.getNumerator() &&
                f1.getDenominator() == f2.getDenominator();
    }
}