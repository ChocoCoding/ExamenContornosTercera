package org.example.damzum_dani;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    /*se prueba que devuelve valores validos en distintas combinaciones;
    primer caso transferencia normal dentro de los limites
    segundo caso transferencia de cantidad limite inferior
    tercer caso transferencia de cantidad limite superior
    cuarto caso transferencia que deja el limite de saldo a 0
     fuera de estos casos entran las excepciones
     */
    @Test
    void transferirFunciona(){
        Assertions.assertAll(
                ()->assertEquals(400,App.transferir(500,100,"666555444")),
                ()->assertEquals(399.50,App.transferir(400,0.50,"666555444")),
                ()->assertEquals(0,App.transferir(500,500,"666555444")),
                ()->assertEquals(0,App.transferir(300,300,"666555444"))
        );
    }


//un test que lanza cada una de las excepciones presentes
    @Test
    void transferirLanzaExcepciones() {
        Assertions.assertAll(
                ()->assertThrows(CantidadIntervaloIncorrectoException.class,()->App.transferir(500,-100,"666555444")),
                ()->assertThrows(CantidadIncorrectaException.class,()->App.transferir(300,400,"666555444")),
                ()->assertThrows(TamanhoCaracteresTelefonoException.class,()->App.transferir(500,100,"666444")),
                ()->assertThrows(PrimerCaracterTelefonoException.class,()->App.transferir(500,100,"166555444")),
                ()->assertThrows(CaracterIncorrectoTelefonoException.class,()->App.transferir(500,100,"666555A44"))
        );
    }


}