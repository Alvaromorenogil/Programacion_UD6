package com.alvaromorenogil.proyectocsv;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    ImageView encabezado;
    ImageView fondo;
    Pane root = new StackPane();  
    
    @Override
    public void start(Stage stage) { 
        
         
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
        // IMAGEN FONDO
        Image fondoIMG = new Image(getClass().getResourceAsStream("/images/fondo.png"));
        fondo = new ImageView(fondoIMG);
        root.getChildren().add(fondo);
        
         Operaciones op = new Operaciones();
         op.OpeCalc(root);
        
     
    }

    public static void main(String[] args) {
        launch();
    }

}