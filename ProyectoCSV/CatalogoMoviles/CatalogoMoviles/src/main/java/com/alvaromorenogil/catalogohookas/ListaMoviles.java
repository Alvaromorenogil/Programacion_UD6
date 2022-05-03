/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvaromorenogil.catalogohookas;

/**
 *
 * @author usuario
 */
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListaMoviles {
    private ArrayList<Movil> listaMoviles = new ArrayList();
    
    public ArrayList<Movil> getListaMoviles() {
        return listaMoviles;
    }
    
    @XmlElement(name = "movil")
    public void setListaMoviles(ArrayList<Movil> listaMoviles) {
        this.listaMoviles = listaMoviles;
    }
    
    public void fusionarMoviles(ListaMoviles movilNuevos) {
        this.getListaMoviles().addAll(movilNuevos.getListaMoviles());
    }
}

