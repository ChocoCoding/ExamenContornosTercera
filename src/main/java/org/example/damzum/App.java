package org.example.damzum;

import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
        float saldo = 500.00f;
        System.out.println("Dime el la cantidad a transferir");
        float cantidad = leerFloat(); //retorna la cantidad comprobando que sea un dato valido, sino salta una excepcion
        System.out.println("Dime el telefono");
        Scanner sc = new Scanner(System.in);
        String telf = sc.nextLine();

        try {
            saldo = transferir(saldo, cantidad, telf);
            System.out.println(saldo);

        }catch (CantidadIncorrectaException |  CantidadIntervaloIncorrectoException | TamanhoCaracteresTelefonoException | PrimerCaracterTelefonoException | CaracterIncorrectoTelefonoException e){
            System.out.println(e.getMessage());
        }
    }

    public static boolean cantidadIntervalo(float cantidad) {
            if (!((0.50f <= cantidad) && (cantidad <= 500.00f))) {
                throw new CantidadIntervaloIncorrectoException("El intervalo debe ser de 0,50 - 500,00");
            }else return true;
    }

    public static boolean cantidadCorrecta(float cantidad, float saldo) {
        if (!(cantidad <= saldo)){
            throw new CantidadIncorrectaException("La cantidad transferida debe ser menor o igual que el saldo");
        }else return true;
    }

    public static boolean telefonoCorrecto(String telefono) {
        if(telefono.length()!= 9)
            throw new TamanhoCaracteresTelefonoException("El telefono debe tener 9 caracteres");
        if(telefono.charAt(0)!= '6')
            throw new PrimerCaracterTelefonoException("El primer caracter del telefono debe ser '6'");

        for(char c: telefono.toCharArray()) {
            if(!Character.isDigit(c))
                throw new CaracterIncorrectoTelefonoException("Todos los caracteres del telefono deben ser numeros");
        }
        return true;
    }


    public static float transferir(float saldo, float cantidad, String telf) {
        if (cantidadIntervalo(cantidad)) {
            if (cantidadCorrecta(cantidad, saldo)) {
                if (telefonoCorrecto(telf)) {
                    return saldo - cantidad;
                }
            }
        }
        return 0.0F;
    }
    public static float leerFloat() {
        boolean ok = true;
        float cantidad = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                cantidad = sc.nextFloat();
                ok = true;
            } catch (Exception ex) {
                System.err.println("No es una cantidad válida");
                ok = false;
                sc.next();
            }
        } while(!ok);
        return cantidad;
    }
}
