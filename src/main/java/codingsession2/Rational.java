package codingsession2;

public class Rational implements Comparable<Rational> {

    private int nominator;
    private int denominator;

    public Rational(int nominator, int denominator) {
        this.nominator = nominator;
        this.denominator = denominator;
        minimize();
    }

    @Override
    public String toString() {
        return nominator + "/" + denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Rational) {
            Rational r = (Rational) o;
            if (nominator == r.getUpperNumber() && denominator == r.getUnderNumber()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return nominator * denominator;
    }

    @Override
    public int compareTo(Rational o) {

        double decimal1 = (double) nominator / (double) denominator;
        double decimal2 = (double) o.getUpperNumber() / (double) o.getUnderNumber();
        if (decimal1 == decimal2) {
            return 0;
        } else if (decimal1 > decimal2) {
            return 1;
        }
        return -1;  	//returns -1 if decimal1 < decimal2
    }

    public static Rational plus(Rational r1, Rational r2) {
        int under1 = r1.getUnderNumber();
        int under2 = r2.getUnderNumber();
        int newUnder = under1 * under2; //set identical underNumber
        //recalculate new upperNumbers and add them
        int newUpper = (r1.getUpperNumber() * under2) + (r2.getUpperNumber() * under1);
        return new Rational(newUpper, newUnder);
    }

    public static Rational minus(Rational r1, Rational r2) {
        int under1 = r1.getUnderNumber();
        int under2 = r2.getUnderNumber();
        int newUnder = under1 * under2; //set identical underNumber
        //recalculate new upperNumbers and sub them
        int newUpper = (r1.getUpperNumber() * under2) - (r2.getUpperNumber() * under1);
        return new Rational(newUpper, newUnder);
    }

    public static Rational times(Rational r1, Rational r2) {
        int newUpper = r1.getUpperNumber() * r2.getUpperNumber();
        int newUnder = r1.getUnderNumber() * r2.getUnderNumber();
        return new Rational(newUpper, newUnder);
    }

    public static Rational divide(Rational r1, Rational r2) {
        int newUpper = r1.getUpperNumber() * r2.getUnderNumber();
        int newUnder = r1.getUnderNumber() * r2.getUpperNumber();
        return new Rational(newUpper, newUnder);
    }

    public void print() {
        System.out.println(toString());
    }

    private void minimize() {
        //calculates highest divider and divide both with it
        int newNominator = nominator;
        int newDenominator = denominator;
        //getting the negativeSign from under to upper number
        if (newDenominator < 0) {
            newNominator *= -1;
            newDenominator *= -1;
        }
        //make upperNumber positive
        int positiveNominator = newNominator;
//        if (positiveNominator < 0) {
//            positiveNominator *= -1;
//        }
        //get divider of both and set them new
        int divider = getHighestDivider(positiveNominator, denominator);
        nominator = (newNominator / divider);
        denominator = (newDenominator / divider);
    }

    private static int getHighestDivider(int number1, int number2) {
        // seperating max and min number
        int max = number1 < number2 ? number2 : number1;
        int min = number1 < number2 ? number1 : number2;

        // counting down from max to the first divider both accept
        // max needs to be > 0, or 1 is returned.
        for (int i = max; i > 0; i--) {
            if (max % i == 0 && min % i == 0) {
                return i;
            }
        }
        // primeNumbers always have 1
        return 1;
    }

    public int getUpperNumber() {
        return nominator;
    }

    public int getUnderNumber() {
        return denominator;
    }

}
