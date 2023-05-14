package org.example.prueba;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {

    @Test()
    @DisplayName("Test Mayor de edad")
    void isMayorEdadTest() {
        Persona persona = new Persona(0);
        Persona persona1 = new Persona(17);
        Persona persona2 = new Persona(-1);
        Persona persona3 = new Persona(-200);
        Persona persona4 = new Persona(18);
        Persona persona5 = new Persona(100);

        Assertions.assertAll(
                () -> assertThrows(AssertionError.class, () -> {
                    persona2.isMayorEdad();
                }),
                () -> assertThrows(AssertionError.class, () -> {
                    persona3.isMayorEdad();
                }),
                () -> assertTrue(persona4.isMayorEdad()),
                () -> assertTrue(persona5.isMayorEdad()),
                () -> assertFalse(persona.isMayorEdad()),
                () -> assertFalse(persona1.isMayorEdad())
        );
    }

}