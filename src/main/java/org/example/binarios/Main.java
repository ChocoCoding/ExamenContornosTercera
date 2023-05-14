package org.example.binarios;

import static org.example.binarios.Binary.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Números Binarios");

        // Leemos un número binario y lo transformamos a vector de enteros
        // importante ver como una operación la he ido descomponiendo en pasos
        //int[] binary = readBinary();
        //System.out.print("Binary: ");
        //printBinary(binary);

        // Pasamos a decimal
        //int dec = binaryToDecimal(binary);
        //System.out.println("Decimal: " + dec);

        // A partir de aquí voy a usar dos numeros para no meterlos siempre
        int[] num1 = {1,1,1};
        int[] num2 = {1,0,0,0};

        // Vamos a sumar
        System.out.print("num1: ");
        printBinary(num1);
        System.out.print("num2: ");
        printBinary(num2);
        System.out.print("Suma: ");
        int[] sum = add(num1, num2);
        printBinary(sum);

        int [] sub = subtract(num2, num1);
        System.out.print("Resta: ");
        printBinary(sub);

    }

}