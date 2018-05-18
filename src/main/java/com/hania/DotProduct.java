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
        c = 0.0;
        int length = Integer.min(a.length, b.length);
        IntStream.range(0, length)
                .forEach(this::multiply);
    }

    private void multiply(Integer i) {
        c += a[i] * b[i];
    }
}
