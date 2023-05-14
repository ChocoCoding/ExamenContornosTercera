package org.example.AJUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {


    @Test
    @DisplayName("Saludo Test")
    void saludoTest() {
        Assertions.assertEquals("Hola 1DAM",App.saludo());
    }

    @Tag("Arimetica")
    @Test
    @DisplayName("Suma de dos numeros Enteros Test")
    void sumaDosNumerosEnterosTest() {
        int num1 = 2;
        int num2 = 2;
        int num = Integer.MAX_VALUE;
        Assertions.assertAll(
                () -> assertEquals(4,App.sumaDosNumerosEnteros(num1,num2))
        );
    }

    @Tag("Metodos")
    @Test
    void restaDosNumerosEnterosTest() {
        int num1 = 5;
        int num2 = 2;
        int numMax = Integer.MAX_VALUE;

        Assertions.assertEquals(3,App.restaDosNumerosEnteros(num1,num2));
        Assertions.assertEquals(0,App.restaDosNumerosEnteros(numMax,numMax));
    }

    @Tag("Metodos")
    @Test
    void multiplyTest() {
        int num1 = 5;
        int num2 = 2;

        Assertions.assertEquals(10,App.multiply(num1,num2));
    }

    @Tag("Metodos")
    @Test
    void divideTest() {
        double num1 = 2;
        double num2 = 2;

        Assertions.assertAll(
                () -> assertEquals(1,App.divide(2,2)),
                () -> assertThrows(ArithmeticException.class, () -> {
                    App.divide(num1,0);
                })
        );
    }


    @Test
    void isBisiestoTest() {
        int year = 2024;
        Assertions.assertTrue(App.isBisiesto(year));
        Assertions.assertFalse(App.isBisiesto(43231));
        Assertions.assertTrue(App.isBisiesto(4));
        Assertions.assertFalse(App.isBisiesto(100));
        Assertions.assertTrue(App.isBisiesto(400));
    }

    @Test
    void isPrimoTest() {
        int numPrimo = 7;
        int numNoPrimo = 6;

        Assertions.assertTrue(App.isPrimo(numPrimo));
        Assertions.assertFalse(App.isPrimo(numNoPrimo));


    }

    @Test
    void isPalindromoTest() {
    }

    @Test
    void burbujaTest() {
    }

    @Test
    void busquedaSecuencialTest() {
    }
}