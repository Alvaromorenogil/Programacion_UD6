/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvaromorenogil.proyectocsv;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Exportar {
    
    public static void exportarCSV(String selecPais, String selecAnno, String bull){
        String nombreFichero = "porc_bullying.csv";
        String textoEncabezado = "Pais,Año,Porecentaje de derechos ";
        String textoDatos = selecPais+","+selecAnno+","+bull;
        //String texto = "Media de atentados en "+seleccionPais+" a lo largo de la historia: "+media;
        BufferedWriter w = null;
        
        try {
        //Crear un objeto BufferedWriter. Si ya existe el fichero, 
        //  se borra automáticamente su contenido anterior.
            w = new BufferedWriter(new FileWriter(nombreFichero));
        //Escribir en el fichero el texto con un salto de línea
            w.write(textoEncabezado + "\n");
            w.write(textoDatos + "\n");
        }
        // Comprobar si se ha producido algún error
        catch(Exception ex) {
            System.out.println("Error de escritura del fichero");
            ex.printStackTrace();
        }
        // Asegurar el cierre del fichero en cualquier caso
        finally {
            try {
                // Cerrar el fichero si se ha podido abrir
                if(w != null)
                    w.close();
            }
            catch (Exception ex) {
                System.out.println("Error al cerrar el fichero");
                ex.printStackTrace();
            }
        }
    }
    }

