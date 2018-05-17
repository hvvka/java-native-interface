package com.hania;

import java.util.stream.IntStream;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class DotProduct {

    static {
        System.loadLibrary("dotproduct"); // Load native library at runtime
        // dotproduct.dll (Windows) or libdotproduct.so (Unixes)
    }

    private Double[] a;
    private Double[] b;
    private Double c;

    public static void main(String[] args) {
        Double[] a = new Double[2];
        a[0] = 1.0;
        a[1] = 2.0;

        Double[] b = new Double[2];
        b[0] = 3.0;
        b[1] = 4.0;

        DotProduct dotProduct = new DotProduct();
        System.out.println("Multi01: " + dotProduct.multi01(a, b));

        dotProduct.setB(b);
        System.out.println("Multi02: " + dotProduct.multi02(a));

//        dotProduct.multi03();
    }

    public Double[] getA() {
        return a;
    }

    public void setA(Double[] a) {
        this.a = a;
    }

    public Double[] getB() {
        return b;
    }

    public void setB(Double[] b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    /**
     * @return dot product of params a and b calculated in native code
     */
    public native Double multi01(Double[] a, Double[] b);

    /**
     * The second product is transferred by this object.
     * @return dot product
     */
    public native Double multi02(Double[] a);

    /**
     * In native code attributes window is invoked.
     * The a and b are loaded and saved.
     * Method multi04 counts the result to c that is displayed from native code.
     */
    public native void multi03();

    /**
     * Multiplies a and b. Saves the result to c.
     */
    private void multi04() {
        IntStream.range(0, a.length)
                .boxed()
                .forEach(this::multiply);
    }

    private void multiply(Integer i) {
        c += a[i] * b[i];
    }
}
