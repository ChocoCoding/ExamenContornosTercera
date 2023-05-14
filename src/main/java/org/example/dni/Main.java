package org.example.dni;

import static org.example.dni.Dni.*;

public class Main {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        String dni = "12345678A";

        System.out.println(dniLongitud(dni));
        System.out.println(ultimoIsLetra(dni));

        System.out.println(getDniLetter(dni));
    }
}
