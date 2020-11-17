package com.company;
//1&Particular&4&180&FFe 000&Rojo

import java.util.Scanner;
public class Inventario {
    private Vehiculo[] vehiculos;
    private int n = 0;
    private int precioComercial = 40000000;
    private int invComerciales = 100;
    private int precioParticular = 30000000;
    private int invParticulares = 100;

    public void procesarComandos(){
        String[] comando;
        Scanner sc = new Scanner(System.in);
        boolean terminar = true;
        while(terminar){
            comando = (sc.nextLine() + "&").split("&");
            if (Integer.parseInt(comando[0]) == 1){
                agregarVehiculo(comando,n);
                n++;
            }else if(Integer.parseInt(comando[0]) == 2){
                listarVehiculos();
            }else if(Integer.parseInt(comando[0]) == 3){
                facturarVehiculos(comando);
            }else if(Integer.parseInt(comando[0]) == 4){
                mostrarInventario();
            }else if(Integer.parseInt(comando[0]) == 5){
                terminar = false;
            }
        }
    }
    public void Inventario() {
        vehiculos = new Vehiculo[10000];
    }

    public void agregarVehiculo(String[] comando,int n){
        if(comando[1].equals("Particular")){
            vehiculos[n] = new Particular(comando[1],Integer.parseInt(comando[2]),Integer.parseInt(comando[3]),comando[4],comando[5]);
        }
        else
        {
            vehiculos[n] = new Comercial(comando[1],Integer.parseInt(comando[2]), Integer.parseInt(comando[3]),comando[4],Integer.parseInt(comando[5]));
        }
    }

    public void listarVehiculos(){
        int i = 0;
        System.out.println("***Inventario de vehículos***");
        while(vehiculos[i]!=null){
            System.out.println(Vehiculo.mostrarVehiculo(vehiculos[i]));
            if(vehiculos[i].getTipo().equals("Particular")){
                System.out.println("\tcolor: " + vehiculos[i].getColor());
            }
            else {
                System.out.println("\tCarga máxima: " + vehiculos[i].getCarga() + "kg");
            }
            i++;
        }
    }

    public void facturarVehiculos(String[] comando){
        if(invParticulares - Integer.parseInt(comando[2])>=0 && invComerciales - Integer.parseInt(comando[4])>=0){
            int cantidadCarros = Integer.parseInt(comando[2]) + Integer.parseInt(comando[4]);
            double ivaPercent = 0;
            if(cantidadCarros<21){
                ivaPercent = (double)(21 - cantidadCarros)/100;
            }
            double total = Integer.parseInt(comando[2])*30000000 + Integer.parseInt(comando[4])*40000000;
            long ivaLong = (long)(total*ivaPercent);
            total = total*(1 + ivaPercent);
            long totalLong = (long)total;
            invParticulares = invParticulares - Integer.parseInt(comando[2]);
            invComerciales = invComerciales - Integer.parseInt(comando[4]);
            System.out.println("CONCESIONARIO UNCAR" + "\nUNCAR - UNIVA" + "\nNIT: 899.999.063");
            System.out.println("Cliente: " + comando[5] + "\nVehículo Cant Precio");
            System.out.println("Particular x" +  comando[2] + " $30000000");
            System.out.println("Comercial x" +  comando[4] + " $40000000");
            System.out.println("Iva: $" + ivaLong);
            System.out.println("Total: $" + totalLong + "\n---");
        }else{
            System.out.println("Lo sentimos no tenemos stock suficiente" + "\n---");
        }
    }

    public void mostrarInventario(){
        System.out.println("Particular: " + invParticulares);
        System.out.println("Comercial: " + invComerciales);
    }
}
