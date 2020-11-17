package com.company;

public class Particular extends Vehiculo{
    private String color;

    public Particular(String tipo, int cantidadPasajeros, int vel, String placa, String color) {
        super(tipo, cantidadPasajeros, vel, placa);
        this.color = color;
    }

    @Override
    public int getCarga() {
        return 0;
    }

    @Override
    public String getColor() {
        return this.color;
    }
}
