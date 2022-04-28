package com.alvaromorenogil.proyectocsv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    ImageView encabezado;
    ImageView fondo;
    
    @Override
    public void start(Stage stage) { 
        
        Pane root = new StackPane();   
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
        // IMAGEN FONDO
        Image fondoIMG = new Image(getClass().getResourceAsStream("/images/fondo.png"));
        fondo = new ImageView(fondoIMG);
        root.getChildren().add(fondo);
        
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
        HBox hboxBoton = new HBox();
        hboxBoton.setAlignment(Pos.CENTER);
        vbox.getChildren().add(hboxBoton);
        
        // VBOX PARA PIE DE PAGINA
        HBox bottom = new HBox(10);
        vbox.getChildren().add(bottom);
        bottom.setAlignment(Pos.BOTTOM_CENTER);
        
        
        
        // Crear un ArrayList con el contenido que se desee para el ComboBox
        ArrayList<String> listaPais = new ArrayList();
        ArrayList<String> listaAnno = new ArrayList();       
        
        // Crear un ComboBox con el contenido de la lista de paises
        ComboBox<String> comboBox = new ComboBox(FXCollections.observableList(listaPais));
        comboBox.setPromptText("Selecciona un país");
        comboBox.setLayoutX(150);
        comboBox.setLayoutY(150);
        hboxComboBox.getChildren().add(comboBox);
        
        // Crear un ComboBox con el contenido de la lista de años
        ComboBox<String> comboBox2 = new ComboBox(FXCollections.observableList(listaPais));
        comboBox2.setPromptText("Selecciona un culo");
        comboBox2.setLayoutX(150);
        comboBox2.setLayoutY(150);
        hboxComboBox.getChildren().add(comboBox2);
        
        // Crear botón para buscar el filtro deseado
        Button buscar = new Button("Buscar");
        hboxBoton.getChildren().add(buscar);
        
        // Añadir un label en el que se mostrará el elemento seleccionado
        Label seleccionado = new Label();
        vbox.getChildren().add(seleccionado);
 
        // Cuando el usuario seleccione algo del ComboBox, se mostrará en el Label
        comboBox.setOnAction((t) -> {
        seleccionado.setText(comboBox.getValue());
        });
        
        String nombreFichero = "bullying.csv";
        // Declarar una variable BufferedReader
        BufferedReader br = null;
        try {
            // Crear un objeto BufferedReader al que se le pasa 
            //   un objeto FileReader con el nombre del fichero
            br = new BufferedReader(new FileReader("bullying.csv"));
            // Leer la primera línea, guardando en un String
            String texto = br.readLine();
            // Repetir mientras no se llegue al final del fichero
            while(texto != null) {
                String[] valores = texto.split(",");
                String edad = valores[3];
                System.out.println(edad);
                // Leer la siguiente línea
                texto = br.readLine();
            }
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
        
        
        
    }

    public static void main(String[] args) {
        launch();
    }

}