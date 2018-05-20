package com.hania;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class DotProductTest {

    private DotProduct dotProduct;

    @Before
    public void setUp() {
        dotProduct = new DotProduct();
    }

    @Test
    public void multi01() {
        // given
        Double[] a = new Double[3];
        a[0] = 3.6;
        a[1] = 4.5;
        a[2] = 5.4;
        Double[] b = new Double[3];
        b[0] = 6.3;
        b[1] = 7.2;
        b[2] = 8.1;

        // when
        Double result = dotProduct.multi01(a, b);

        // then
        Double expected = 98.82;
        assertEquals(expected, result);
    }

    @Test
    public void multi02() {
        // given
        Double[] a = new Double[2];
        a[0] = 1.0;
        a[1] = 2.0;
        Double[] b = new Double[3];
        b[0] = 5.4;
        b[1] = 3.2;
        b[2] = 100.0;

        // when
        dotProduct.setB(b);
        Double result = dotProduct.multi02(a);

        // then
        Double expected = 11.8;
        assertEquals(expected, result);
    }

    @Test
    public void multi03() {
        // given
        Double[] a = new Double[3];
        a[0] = -1.4;
        a[1] = 0.4;
        Double[] b = new Double[3];
        b[0] = 2.0;

        // when
        dotProduct.setA(a);
        dotProduct.setB(b);
        dotProduct.multi03();
        double result = dotProduct.getC();

        // then
        double expected = -2.8;
        double delta = 0.0001;
        assertEquals(expected, result, delta);
    }
}