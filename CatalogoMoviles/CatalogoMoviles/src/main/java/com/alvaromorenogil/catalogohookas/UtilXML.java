/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvaromorenogil.catalogohookas;

/**
 *
 * @author usuario
 */
import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class UtilXML {
    
    public static void guardarDatosXML(Stage stage, ListaMoviles listaMoviles) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar XML en");
        File fileListaMoviles = fileChooser.showSaveDialog(stage);        
        
        JAXBContext contexto;
        try {            
            //File file = fileChooser.showSaveDialog(stage);
            
            contexto = JAXBContext.newInstance(ListaMoviles.class);
            
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
            marshaller.marshal(listaMoviles, System.out);
            marshaller.marshal(listaMoviles, fileListaMoviles);
            
        } catch (JAXBException ex) {
            System.out.println("Se ha producido un error");
            ex.printStackTrace();
        }            
    }
    
    static public ListaMoviles importarDatosXML(Stage stage) {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Import XML en");
            File fileListaMoviles = fileChooser.showOpenDialog(stage);
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("XML", ".xml"));

            JAXBContext context = JAXBContext.newInstance( ListaMoviles.class );
            Unmarshaller unmarshaller = context.createUnmarshaller();
            
            ListaMoviles listaMovilesNuevos = new ListaMoviles();
            listaMovilesNuevos = (ListaMoviles)unmarshaller.unmarshal(fileListaMoviles);
            
            return listaMovilesNuevos;
        } catch (JAXBException ex) {
            System.out.println("Se ha producido un error");
            ex.printStackTrace();
            return null;
        }
    }
}

