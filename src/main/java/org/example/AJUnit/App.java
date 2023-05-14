package org.example.AJUnit;


public final class App {

    public static void main( String[] args ) {
        System.out.println( saludo() );
    }

    /**
     * Metodo estatico que retorna un saludo
     * @return String con el saludo
     */
    public static String saludo() {
        return "Hola 1DAM";
    }

    /**
     * Metodo estatico que calcula la suma de dos numeros
     * @param number1 parametro 1 a sumar
     * @param number2 parametro 2 a sumar
     * @return double con el resultado
     */
    public static double sumaDosNumerosEnteros(double number1, double number2){
        return number1 + number2;
    }

    /**
     * Metodo estatico que calcula la resta de dos numeros
     * @param number1 parametro 1 a restar
     * @param number2 parametro 2 a restar
     * @return double con el resultado
     */
    public static double restaDosNumerosEnteros(double number1, double number2){
        return number1 - number2;
    }

    /**
     * Metodo estatico que calcula la multiplicacion de dos numeros
     * @param number1 parametro 1 a multiplicar
     * @param number2 parametro 2 a multiplicar
     * @return double con el resultado
     */
    public static double multiply(double number1, double number2) {
        return number1 * number2;
    }

    /**
     * Metodo estatico que calcula la division de dos numeros
     * @param number1 parametro 1 a dividir
     * @param number2 parametro 2 a dividir
     * @return double con el resultado
     */
    public static double divide(double number1, double number2){
        if (number2 == 0){
            throw new ArithmeticException("No se puede dividir por 0");
        }return number1 / number2;
    }

    /**
     * Metodo que comprueba si un año pasado por parametro es bisiesto.
     * @param year año a comprobar
     * @return int con el resultado
     */
    public static boolean isBisiesto(int year) {
        return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
    }

    /**
     * Metodo que comprueba si un numero es primo o no
     * @param num numero a comprobar
     * @return true si el numero es primo, de otra forma, false
     */
    public static boolean isPrimo(int num) {
        if (num == 2) {
            return true;
        } else if (num <= 1 || num % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(num); i+=2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodo que comprueba si una cadena de texto es palindromo
     * @param cadena String a comprobar
     * @return True si es palindromo o false si no lo es
     */
    public static boolean isPalindromo(String cadena) {
        String clean = cadena.replaceAll("\\s+", "").toLowerCase();
        int longitud = clean.length();
        int inicio = 0;
        int fin = longitud - 1;
        while (fin > inicio) {
            char inicioChar = clean.charAt(inicio++);
            char finChar = clean.charAt(fin--);
            if (inicioChar != finChar)
                return false;
        }
        return true;
    }


    /**
     * Metodo que ordena un array "V" de menor a mayor
     * @param V Array a ordenar
     */
    public static void burbuja(int[] V){
        int i, j;
        int aux;
        for(i=0;i<V.length-1;i++)
            for(j=0;j<V.length-i-1;j++)
                if(V[j+1]<V[j]){
                    aux=V[j+1];
                    V[j+1]=V[j];
                    V[j]=aux;
                }
    }

    /**
     * Metodo que busca un valor "x" en el array "A"
     * @param A Int[] a recorrer
     * @param x Int a buscar
     * @return la posicion "i" si la encuentra, sino retorna "-1"
     */
    public static int busquedaSecuencial(int[] A, int x){
        int i;
        for(i=0;i<A.length;i++)
            if(A[i]==x)
                return i;
        return -1;
    }
}
