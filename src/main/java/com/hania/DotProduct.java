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

    // Test Driver
    public static void main(String[] args) {
        Double[] a = new Double[2];
        a[0] = 1.0;
        a[1] = 2.0;

        Double[] b = new Double[2];
        b[0] = 2.0;
        b[1] = 1.0;

        DotProduct dotProduct = new DotProduct();
        Double result = dotProduct.multi01(a, b);
        System.out.println(result);
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

    /*
     * zakładamy, że po stronie kodu natywnego wyliczony zostanie iloczyn skalarny dwóch wektorów
     */
    public native Double multi01(Double[] a, Double[] b);

    /*
     * zakładamy, że drugi atrybut będzie pobrany z obiektu przekazanego do metody natywnej
     */
    public native Double multi02(Double[] a);

    /*
     * zakładamy, że po stronie natywnej utworzone zostanie okienko na atrybuty,
     * a po ich wczytaniu i przepisaniu do a, b obliczony zostanie wynik.
     * Wynik powinna wyliczać metoda Javy multi04
     * (korzystająca z parametrów a, b i wpisująca wynik do c).
     */
    public native void multi03();

    private void multi04() {
        // mnoży a i b, wynik wpisuje do c
        IntStream.range(0, a.length)
                .boxed()
                .forEach(this::multiply);
    }

    private void multiply(Integer i) {
        c += a[i] * b[i];
    }
}
