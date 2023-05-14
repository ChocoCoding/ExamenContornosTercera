package org.example.dni;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DniTest {

    @Test
    void dniLongitudTest() {
        String dniTrue = "39490438J";
        String dniFalse = "3949043J";
        String dniFalseGrande = "394904384J";

        Assertions.assertAll(
                () -> assertTrue(Dni.dniLongitud(dniTrue)),
                () -> assertFalse(Dni.dniLongitud(dniFalse)),
                () -> assertFalse(Dni.dniLongitud(dniFalseGrande)));
    }

    @Test
    void ultimoIsLetraTest() {
        String dniTrue = "39490438J";
        String dniFalse = "394904355";

        Assertions.assertAll(
                () -> assertTrue(Dni.ultimoIsLetra(dniTrue)),
                () -> assertFalse(Dni.ultimoIsLetra(dniFalse))
        );
    }

    @Test
    void primerosAreNumberTest() {
        String dniTrue = "39490438J";
        String dniFalse = "A9490435J";
        Assertions.assertAll(
        () -> assertTrue(Dni.primerosAreNumber(dniTrue)),
        () -> assertFalse(Dni.primerosAreNumber(dniFalse))
        );
    }

    @Test
    void isValidLetterTest() {
    }

    @Test
    void getDniLetterTest() {
        String dniValido = "12345678J";
        char letraValida = 'J';
        String dniFalse = "12345678K";
        char letraFalse = 'J';
        Assertions.assertAll(
                () ->assertEquals(letraValida,Dni.getDniLetter(dniValido)),
                () ->assertEquals(letraFalse,Dni.getDniLetter(dniFalse))
        );
        
    }
}