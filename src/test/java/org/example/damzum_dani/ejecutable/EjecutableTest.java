package org.example.damzum_dani.ejecutable;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class EjecutableTest {

    @BeforeEach
    public void setUp() {
       Ejecutable.cantidades = new double[]{1, 2, 1};
       Ejecutable.precios= new double[]{10.00, 25.50, 32.30};

    }

    @Test
    public void isArrayLonguitudMayorCero() {

        assertTrue(Ejecutable.isArrayLonguitudMayorCero());
        Ejecutable.precios= new double[]{10.00, 25.50};
        assertFalse(Ejecutable.isArrayLonguitudMayorCero());
        Ejecutable.precios= new double[]{};
        Ejecutable.cantidades = new double[]{};
        assertFalse(Ejecutable.isArrayLonguitudMayorCero());
    }

    @Test
    void isPositivos() {
        assertTrue(Ejecutable.isPositivos(Ejecutable.cantidades));
        assertTrue(Ejecutable.isPositivos(Ejecutable.precios));
        Ejecutable.cantidades = new double[]{1, -2, 1};
        Ejecutable.precios= new double[]{10.00, -25.50, 32.30};
        assertFalse(Ejecutable.isPositivos(Ejecutable.cantidades));
        assertFalse(Ejecutable.isPositivos(Ejecutable.precios));
    }

    @Test
    void redondeo(){
        assertEquals(22.16,Ejecutable.redondeo(22.156));
        assertNotEquals(22,Ejecutable.redondeo(22.009));
    }
    @Test
    void getDescuentoAplicado(){
        assertEquals(15.00,Ejecutable.getDescuentoAplicado(150));
        assertNotEquals(15.00,Ejecutable.getDescuentoAplicado(150.001));
    }

    @Test
    void isValid(){
        assertTrue(Ejecutable.isValid());
        Ejecutable.precios= new double[]{};
        assertFalse(Ejecutable.isValid());
        Ejecutable.precios= new double[]{10.00, 25.50, 32.30};
        Ejecutable.cantidades = new double[]{1, -2, 1};
        assertFalse(Ejecutable.isValid());
        Ejecutable.precios= new double[]{10.00, -25.50, 32.30};
        assertFalse(Ejecutable.isValid());
        Ejecutable.cantidades = new double[]{1, 2, 1};
        assertFalse(Ejecutable.isValid());
        Ejecutable.precios= new double[]{};
        assertFalse(Ejecutable.isValid());
        Ejecutable.precios= new double[]{10.00, 25.50, 32.30};
        Ejecutable.cantidades = new double[]{1, 2, -1};
        assertFalse(Ejecutable.isValid());
    }

    @Test
    void getIvaAplicado() {
        assertNotEquals(21,Ejecutable.getIvaAplicado(100));
        assertEquals(18.9,Ejecutable.getIvaAplicado(100));
    }

    @Test
    void getSubtotal(){
        assertEquals(93.3,Ejecutable.getSubtotal());
        assertNotEquals(93.31,Ejecutable.getSubtotal());

    }
}