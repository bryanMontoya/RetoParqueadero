package com.company;

public class Comercial extends Vehiculo{
    private int carga;

    public Comercial(String tipo, int cantidadPasajeros, int vel, String placa, int carga) {
        super(tipo, cantidadPasajeros, vel, placa);
        this.carga = carga;
    }

    @Override
    public int getCarga() {
        return this.carga;
    }

    @Override
    public String getColor() {
        return null;
    }
}
