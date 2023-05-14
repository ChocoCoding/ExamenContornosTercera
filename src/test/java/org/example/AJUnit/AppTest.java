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
        Assertions.assertTrue(App.isPrimo(2));
        Assertions.assertFalse(App.isPrimo(-1));
        Assertions.assertFalse(App.isPrimo(0));
        Assertions.assertFalse(App.isPrimo(1));
        Assertions.assertFalse(App.isPrimo(8));
        Assertions.assertTrue(App.isPrimo(17));
        Assertions.assertFalse(App.isPrimo(22));
    }

    @Test
    void isPalindromoTest() {
        String palindromo = "ana";
        String noPalindromo = "mipolla";

        Assertions.assertTrue(App.isPalindromo(palindromo));
        Assertions.assertFalse(App.isPalindromo(noPalindromo));

    }

    @Test
    void burbujaTest() {
        int[] V = {6,20,17,8};
        int[] V2 = {6,8,17,20};
        App.burbuja(V);
        Assertions.assertArrayEquals(V2,V);

    }

    @Test
    void busquedaSecuencialTest() {
        int[] V = {6,20,17,8};
        int x = 20;
        int x2 = 678;

        Assertions.assertEquals(1,App.busquedaSecuencial(V, x));
        Assertions.assertEquals(-1,App.busquedaSecuencial(V,x2));

    }
}