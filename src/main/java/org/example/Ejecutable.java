package org.example;

public class Ejecutable {
    private static final double IVA = 0.21;
    private static final double DESCUENTO = 0.10;
    private static double[] cantidades;
    private static double[] precios;
    public static void main(String[] args) {
           run();
    }

    private static void run() {
        System.out.println("Carro compra");
        cantidades = new double[]{1, 2, 1};
        precios= new double[]{10.00, 25.50, 32.30};

        if(isValid()){
            printCarroCompra();
            System.out.println("Subtotal: "+ redondeo(getSubtotal()));
            System.out.println("Descuento: "+ redondeo(getDescuentoAplicado(getSubtotal())));
            System.out.println("IVA: " + redondeo(getIvaAplicado(getSubtotal())));
            System.out.println("Total: " + (redondeo(getSubtotal()) - redondeo(getDescuentoAplicado(getSubtotal())) + redondeo(getIvaAplicado(getSubtotal()))));
        }
    }

    private static double getIvaAplicado(double subtotal) {  return (subtotal-getDescuentoAplicado(subtotal))*IVA;   }

    private static double getSubtotal() {
        double subTotal = 0;
        for (int i = 0; i < cantidades.length; i++) {
            subTotal += cantidades[i] * precios[i];
        }
        return subTotal;
    }

    private static double getDescuentoAplicado(double subtotal) { return subtotal*DESCUENTO;  }

    private static boolean isValid() { return isArrayLonguitudMayorCero() && isPositivos(precios) && isPositivos(cantidades); }

    public static boolean isArrayLonguitudMayorCero() {return cantidades.length == precios.length && cantidades.length > 0;}

    public static boolean isPositivos(double[] array) {
        for (double valor : array) {
            if (valor <= 0) {
                return false;
            }
        }
        return true;
    }

    private static double redondeo(double subTotal) { return (Math.round(subTotal*100.0)/100.0); }
    private static void printCarroCompra() {
        for (int i = 0; i < cantidades.length; i++) {
            System.out.println("Cantidad: " + cantidades[i] + " Precio: " + precios[i]);
        }
    }
}