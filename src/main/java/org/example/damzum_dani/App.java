package org.example.damzum_dani;

import java.util.Scanner;
/*
 * @Author: Daniel Campos Rocha
 * Programa que raliza una transferencia desde el movil
 * */
public class App {
    public static void main( String[] args ) {
        double saldo = 500.00f;//saldo inicial
        Scanner sc = new Scanner(System.in);
        String telefono;
        int op;
        do {
            op=0;
            System.out.println("Dime el la cantidad a transferir");
            double cantidad = leerleerDouble(); //retorna la cantidad comprobando que sea un dato valido, sino salta una excepcion
            System.out.println("Dime el telefono");
            telefono = sc.nextLine();
            try {
                System.out.println(transferir(saldo, cantidad, telefono));
            } catch (CantidadIntervaloIncorrectoException e) {
                System.err.println("Error: la cantidad no es valida");
                op++;
            } catch (CantidadIncorrectaException e) {
                System.err.println("Error: saldo insuficiente");
                op++;
            } catch (CaracterIncorrectoTelefonoException e) {
                System.err.println("Error: el numero de telefono solo debe contener numeros");
                op++;
            } catch (PrimerCaracterTelefonoException e) {
                System.err.println("Error: el telefono debe ser movil");
                op++;
            } catch (TamanhoCaracteresTelefonoException e) {
                System.err.println("Error: el numero de telefono debe tener 9 numeros");
                op++;
            }
        }while(op!=0);
    }
    //comprueba que los datos sean válidos y devuelve el nuevo saldo tras la transferencia
    public static double transferir(double saldo, double cantidad, String telefono) throws CantidadIntervaloIncorrectoException, CantidadIncorrectaException, TamanhoCaracteresTelefonoException, PrimerCaracterTelefonoException, CaracterIncorrectoTelefonoException {
            if (!((0.50f <= cantidad) && (cantidad <= 500.00f)))throw new CantidadIntervaloIncorrectoException("El intervalo debe ser de 0,50 - 500,00");
            if (!(cantidad <= saldo)){throw new CantidadIncorrectaException("La cantidad transferida debe ser menor o igual que: " + saldo);}
            if(telefono.length()!= 9) throw new TamanhoCaracteresTelefonoException("El telefono debe tener 9 caracteres");
            if(telefono.charAt(0)!= '6') throw new PrimerCaracterTelefonoException("El primer caracter del telefono debe ser '6'");
            for(char c: telefono.toCharArray()) if(!Character.isDigit(c))  throw new CaracterIncorrectoTelefonoException("Todos los caracteres del telefono deben ser numeros");
        return saldo - cantidad;
    }
    //método que lee un valor double de teclado y lo devuelve
    public static double leerleerDouble() {
        boolean ok;
        double cantidad = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                cantidad = sc.nextDouble();
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
