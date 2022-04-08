/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvaromorenogil.catalogohookas;

/**
 *
 * @author usuario
 */
public class Movil {
    
    //-- VARIABLES --\\
    private String nombre;
    private String marca;
    private String modelo;
    private String fechaSalidaVenta;
    private String precio;
    
    
    
    public Movil(){
       
    }
    
    public Movil(String nombre){
        this.nombre = nombre.toUpperCase();
    }
    
    public Movil (String nombre, String marca){
        this.nombre = nombre.toUpperCase();
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre.toUpperCase();
    }
    
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    public String getMarca(){
        return marca;
    }
    
    public String getModelo(){
        return modelo;
    }
    
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    
    public String getFechaSalidaVenta(){
        return fechaSalidaVenta;
    }
    
    public void setFechaSalidaVenta(String fechaSalidaVenta){
        this.fechaSalidaVenta = fechaSalidaVenta;
    }
    
    public String getPrecio(){
        return precio;
    }
    
    public void setPrecio(String precio){
        this.precio = precio;
    }
    
    @Override
    public String toString(){
        String r = "";
        r += "Nombre: " + nombre + "\n";
        r += "Marca: " + marca;
        return r;
    }
}
