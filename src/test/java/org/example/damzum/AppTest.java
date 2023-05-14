package org.example.damzum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void main() {
    }

    @Test
    void cantidadIntervalo() {
        float cantidadTrue = 100f;
        float cantidadC1 = 0.51f;
        float cantidadC2 = 0.50f;
        float cantidadC3 = 0.49f;
        float cantidadC4 = 499.99f;
        float cantidadC5 = 500.00f;
        float cantidadC6 = 500.01f;

        Exception e = Assertions.assertThrows(Exception.class, () -> {
            App.cantidadIntervalo(cantidadC3);
        });
        Exception ex = Assertions.assertThrows(Exception.class, () -> {
            App.cantidadIntervalo(cantidadC6);
        });

        Assertions.assertAll(
                () -> assertTrue(App.cantidadIntervalo(cantidadTrue)),
                () -> assertTrue(App.cantidadIntervalo(cantidadC1)),
                () -> assertTrue(App.cantidadIntervalo(cantidadC2)),
                () -> assertTrue(App.cantidadIntervalo(cantidadC4)),
                () -> assertTrue(App.cantidadIntervalo(cantidadC5)),
                () -> assertEquals(ex.getMessage(),"El intervalo debe ser de 0,50 - 500,00"),
                () -> assertEquals(e.getMessage(),"El intervalo debe ser de 0,50 - 500,00")
        );

    }

    @Test
    void cantidadCorrecta() {
        String tTelefonoCorrecto = "674727272";
        String tDemasiadosParametros = "5252452452";

        //Para comprobar excepciones Personalizadas
        Assertions.assertAll(
                () -> assertThrows(TamanhoCaracteresTelefonoException.class,() -> {
                    App.telefonoCorrecto(tDemasiadosParametros);
                })
        );

    }

    @Test
    void telefonoCorrecto() {


    }

    @Test
    void transferir() {
    }

    @Test
    void leerFloat() {
    }
}