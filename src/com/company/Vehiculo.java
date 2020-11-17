package com.company;

public abstract class Vehiculo {
    private String tipo;
    private int cantidadPasajeros;
    private int vel;
    private String placa;

    public abstract int getCarga();

    public abstract String getColor();

    public String getTipo() {
        return tipo;
    }

    public Vehiculo(String tipo, int cantidadPasajeros, int vel, String placa) {
        this.tipo = tipo;
        this.cantidadPasajeros = cantidadPasajeros;
        this.vel = vel;
        this.placa = placa;
    }

    public static String mostrarVehiculo(Vehiculo v){
        return "\tVehículo " + v.tipo + " - Placa: " + v.placa +
                "\n\tvelocidad: " + v.vel + " km/h" +
                "\n\tpasajeros: " + v.cantidadPasajeros;
    }
}
