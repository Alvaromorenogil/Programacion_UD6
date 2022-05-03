/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvaromorenogil.proyectocsv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author usuario
 */
public class Operaciones {
    
    String Pais = "";
    String Anno = "";
    String A = "";
    
    String selecPais = "";
    String selecAnno = "";
    String bull = "";
    boolean y = true;
    boolean gD = false;
    
    public void OpeCalc(Pane root){
        
        //Vbox
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        root.getChildren().add(vbox);
        
         // LABEL
        Label titulo = new Label("Selecciona el país y el año del que quieras saber el %.");
        titulo.setStyle("-fx-font: 15 arial;");
        vbox.getChildren().add(titulo);
        
        // HBox para los combobox
        HBox hboxComboBox = new HBox(20);
        hboxComboBox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(hboxComboBox);
        
        //HBox para el botón
        HBox hboxBoton = new HBox(20);
        hboxBoton.setAlignment(Pos.CENTER);
        vbox.getChildren().add(hboxBoton);
 
        
        // Crear un ArrayList con el contenido que se desee para el ComboBox
        ArrayList<String> listaPais = new ArrayList();
        ArrayList<String> listaAnno = new ArrayList();  
        
        String nombreFichero = "bullying.csv";
        
        // Crear un ComboBox con el contenido de la lista de paises
        ComboBox<String> comboBox = new ComboBox(FXCollections.observableList(listaPais));
        comboBox.setPromptText("Selecciona un país");
        hboxComboBox.getChildren().add(comboBox);
        
        // Crear un ComboBox con el contenido de la lista de años
        ComboBox<String> comboBox2 = new ComboBox(FXCollections.observableList(listaAnno));
        comboBox2.setPromptText("Selecciona un Año");
        hboxComboBox.getChildren().add(comboBox2);
        
        
        // Añadir un label en el que se mostrará el elemento seleccionado
        Label seleccionado = new Label();
        vbox.getChildren().add(seleccionado);
 
        // Cuando el usuario seleccione algo del ComboBox, se mostrará en el Label
        comboBox.setOnAction((t) -> {
            seleccionado.setText("Pais: "+comboBox.getValue());
            selecPais = comboBox.getValue();
        });
        
        //Label Año
        Label selec = new Label();
        vbox.getChildren().add(selec);
        
         // Cuando el usuario seleccione algo del ComboBox, se mostrará en el Label del año
        comboBox2.setOnAction((t) -> {
            selec.setText("Año: "+comboBox2.getValue());
            selecAnno = comboBox2.getValue();
        });
        // Declarar una variable BufferedReader
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("bullying.csv"));
            String texto = br.readLine();
            while(texto != null) {
                String[] valores = texto.split(",");
                Datos datos = new Datos();
                
                datos.setPais(valores[0]);
                datos.setAnno(valores[2]);
                datos.setReporteBullying(valores[3]);
                
               if(!A.equals(datos.getPais()) && !datos.getPais().equals("Year")){
                    listaPais.add(A);
                    A = datos.getPais();
                }
               
               for(int i=0;i<listaAnno.size();i++){
                    if(datos.getAnno().equals(listaAnno.get(i))){
                        y = false;
                    }
                }

                if(y == true && !datos.getAnno().equals("Year")){

                    listaAnno.add(datos.getAnno());
                }
                // Leer la siguiente línea
                texto = br.readLine();
            }
            listaPais.remove(0);
            listaAnno.remove(0);
            listaPais.remove(1); // No se quita la primera selección del país
            listaAnno.remove(1);
        }
        // Captura de excepción por fichero no encontrado
        catch (FileNotFoundException ex) {
            System.out.println("Error: Fichero no encontrado");
            ex.printStackTrace();
        }
        // Captura de cualquier otra excepción
        catch(Exception ex) {
            System.out.println("Error de lectura del fichero");
            ex.printStackTrace();
        }
        // Asegurar el cierre del fichero en cualquier caso
        finally {
            try {
                // Cerrar el fichero si se ha podido abrir
                if(br != null) {
                    br.close();
                }
            }
            catch (Exception ex) {
                System.out.println("Error al cerrar el fichero");
                ex.printStackTrace();
            }
        }
        // Crear botón para buscar el filtro deseado
        Button bus = new Button("Buscar");
        hboxBoton.getChildren().add(bus);
        
         //BOTON GUARDAR
        Button gua = new Button("Exportar");
        hboxBoton.getChildren().add(gua);
        
        //DERECHOS HUMANOS
        Label por = new Label();
        vbox.getChildren().add(por);
        
        bus.setOnAction(t -> {
           String nom = "bullying.csv";

            BufferedReader br2 = null;
            try {           
                br2 = new BufferedReader(new FileReader(nom));
                String texto2 = br2.readLine();
                while(texto2 != null) {                
                    String[] valores = texto2.split(",");
                    
                    Datos dato = new Datos();
                    dato.setPais(valores[0]);
                    dato.setAnno(valores[2]);
                    dato.setReporteBullying(valores[3]);
                    System.out.println(selecPais);
                    if(selecPais.equals(dato.getPais()) && selecAnno.equals(dato.getAnno())){
                        System.out.println("entra");
                        bull = dato.getReporteBullying();
                        por.setText("El porcentaje de los derechos humanos obtenido es de "+bull);
                    }
                    texto2 = br2.readLine();
                } 
                
                gD = true;
            }   
            catch (FileNotFoundException ex) { 
                System.out.println("Error: Fichero no encontrado");
                ex.printStackTrace();   
            } 
            catch(Exception ex) {        
                System.out.println("Error de lectura del fichero");        
                ex.printStackTrace();    
            }
            finally {        
                try {            
                    if(br2 != null) {                
                        br2.close();            
                    }        
                }        
                catch (Exception ex) {            
                    System.out.println("Error al cerrar el fichero");            
                    ex.printStackTrace();       
                }   
            } 
        });
        
        gua.setOnAction(t -> {
            if (gD == true){   
                Exportar.exportarCSV(selecPais, selecAnno, bull);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Datos Guardados");
                alert.setHeaderText("Se ha guardado el fichero");
                alert.setContentText("Se han escrito correctamente los datos" );
                alert.showAndWait();
            }
        
        
        });
    }
}
