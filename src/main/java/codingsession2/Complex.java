/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingsession2;

/**
 *
 * @author Skjallar
 */
public class Complex extends Object {

    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {

        this.real = real;
        this.imaginary = imaginary;

    }

    public Complex plus(Complex complex) {

        double resultReal = (real + complex.real);
        double resultImaginary = (imaginary + complex.imaginary);

        Complex result = new Complex(resultReal, resultImaginary);

        return result;

    }

    public static void main() {
        Complex a = new Complex(0.1d, 0.2d);
        Complex b = new Complex(0.1d, 0.2d);
        //a+b
        Complex sumOfAAndB = a.plus(b);
    }

    @Override
    public boolean equals(Object other) {
        if (other.getClass() != Complex.class) {
            return false;
        }
        Complex otherComplex = (Complex) other;
        return (this.imaginary == otherComplex.imaginary) && (this.real == otherComplex.real);

    }

}
