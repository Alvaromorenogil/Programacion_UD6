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
    private int GB;
    private String fechaSalidaVenta;
    private float precio;
    
    
    
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
        this.nombre = nombre;
    }
    
    public String getMarca(){
        return marca;
    }
    
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    public String getModelo(){
        return modelo;
    }
    
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    
    public int getGB(){
        return GB;
    }
    
    public void setGB(int gb){
        this.GB = gb;
    }
   
    public String getFechaSalidaVenta(){
        return fechaSalidaVenta;
    }
    
    public void setFechaSalidaVenta(String fechaSalidaVenta){
        this.fechaSalidaVenta = fechaSalidaVenta;
    }
    
    public float getPrecio(){
        return precio;
    }
    
    public void setPrecio(float precio){
        this.precio = precio;
    }
    
    public String GBToString(){
       String r = "GB: " + GB;
       return r;
    }
    
    public String precioToString(){
       String r = "Precio: " + precio;
       return r;
    }
    
    @Override
    public String toString(){
        String r = "";
        r += "Nombre: " + nombre + "\n";
        r += "Marca: " + marca;
        return r;
    }
}
