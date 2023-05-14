package org.example.prueba;

public class Persona {
    private int edad;


    public boolean isMayorEdad(){
        assert edad >= 0;
        return edad >= 18;
    }

    public Persona(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Persona{");
        sb.append("edad=").append(edad);
        return sb.toString();
    }
}
