/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listalibros;

/**
 *
 * @author usuario
 */
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListaLibros {
    private ArrayList<Libro> listaLibros = new ArrayList();
    
    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }
    
    @XmlElement(name = "libro")
    public void setListaLibros(ArrayList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }
    
    public void fusionarLibros(Libro libroNuevos) {
//        this.getListaLibros() <- librosNuevos.getListaLibros()
    }
}