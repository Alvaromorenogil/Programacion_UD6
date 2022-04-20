package com.alvaromorenogil.catalogohookas;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    int movilActual = 0;
    
    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        var scene = new Scene(root, 640, 480);
        
        stage.setScene(scene);
        stage.show();
        
        Movil movil1 = new Movil("Iphone X");
        movil1.setNombre("Apple Iphone X");
        movil1.setMarca("Apple");
        movil1.setModelo("X");
        movil1.setGB(32);
        movil1.setFechaSalidaVenta("3 de Noviembre de 2017");
        movil1.setPrecio(250);
        
        Movil movil2 = new Movil("Iphone 11");
        movil2.setNombre("Apple Iphone 11");
        movil2.setMarca("Apple");
        movil2.setModelo("11");
        movil2.setGB(64);
        movil2.setFechaSalidaVenta("20 de Septiembre de 2019");
        movil2.setPrecio(350);
        
        Movil movil3 = new Movil("Iphone 12");
        movil3.setNombre("Apple Iphone 12");
        movil3.setMarca("Apple");
        movil3.setModelo("11");
        movil3.setGB(128);
        movil3.setFechaSalidaVenta("16 de Octubre de 2020");
        movil3.setPrecio(500);
        
        Movil movil4 = new Movil("Iphone 13");
        movil4.setNombre("Apple Iphone 13");
        movil4.setMarca("Apple");
        movil4.setModelo("13");
        movil4.setGB(256);
        movil4.setFechaSalidaVenta("17 de Septiembre de 2021");
        movil4.setPrecio(800);
        
        System.out.println(movil1.getNombre());
        System.out.println(movil2.getNombre());
        System.out.println(movil3.getNombre());
        System.out.println(movil4.getNombre());
        
        ListaMoviles listaMoviles = new ListaMoviles();
        listaMoviles.getListaMoviles().add(movil1);
        listaMoviles.getListaMoviles().add(movil2);
        listaMoviles.getListaMoviles().add(movil3);
        listaMoviles.getListaMoviles().add(movil4);
        
        // BOTÓN DE GUARDAR 
        Button exportar = new Button("Exportar XML");
        root.getChildren().add(exportar);
        
        exportar.setOnMousePressed((MouseEvent mouseEvent) -> {
            System.out.println("Has pulsado el botón exportar");
            UtilXML.guardarDatosXML(stage, listaMoviles);
        });
        
        // BOTÓN DE IMPORTAR
        Button importar = new Button("Importar XML");
        root.getChildren().add(importar);
        importar.setLayoutX(100);
        
        importar.setOnMousePressed((MouseEvent mouseEvent) -> {
            System.out.println("Has pulsado el botón importar");
            ListaMoviles movilesImport = UtilXML.importarDatosXML(stage);
            listaMoviles.fusionarMoviles(movilesImport);
        });
        
        Label labelNombre = new Label();
//        labelNombre.setLayoutX(100);
//        labelNombre.setLayoutY(200);
        
        Label labelMarca = new Label();
//        labelMarca.setLayoutX(100);
//        labelMarca.setLayoutY(220);
        
        Label labelModelo = new Label();
//        labelModelo.setLayoutX(100);
//        labelModelo.setLayoutY(240);

        Label labelGB = new Label();

        Label labelFechaSalidaVenta = new Label();
//        labelFechaSalidaVenta.setLayoutX(100);
//        labelFechaSalidaVenta.setLayoutY(260);
        
        Label labelPrecio = new Label();
//        labelPrecio.setLayoutX(100);
//        labelPrecio.setLayoutY(280);
        
        root.getChildren().add(labelNombre);
        root.getChildren().add(labelMarca);
        root.getChildren().add(labelModelo);
        root.getChildren().add(labelGB);
        root.getChildren().add(labelFechaSalidaVenta);
        root.getChildren().add(labelPrecio);
        
        //BOTÓN SIGUIENTE
        Button siguiente = new Button("Siguiente"); 
//        siguiente.setLayoutX(220);
//        siguiente.setLayoutY(150);
        root.getChildren().add(siguiente);
        siguiente.setOnAction((t) -> { 
            movilActual++;
            System.out.println(movilActual);
            try {
                labelNombre.setText("Nombre: "+ listaMoviles.getListaMoviles().get(movilActual).getNombre());
                labelMarca.setText("Marca: "+ listaMoviles.getListaMoviles().get(movilActual).getMarca());
                labelModelo.setText("Modelo: "+ listaMoviles.getListaMoviles().get(movilActual).getModelo());
                labelGB.setText("GB: "+ listaMoviles.getListaMoviles().get(movilActual).getGB());
                labelFechaSalidaVenta.setText("Fecha salida venta: "+ listaMoviles.getListaMoviles().get(movilActual).getFechaSalidaVenta());
                labelPrecio.setText("Precio: "+ listaMoviles.getListaMoviles().get(movilActual).getPrecio());
            } catch (Exception ex){}
         });
        
        //BOTÓN ANTERIOR
        Button botonAnterior = new Button("Anterior"); 
//        botonAnterior.setLayoutX(350);
//        botonAnterior.setLayoutY(150);
        root.getChildren().add(botonAnterior);
        botonAnterior.setOnAction((t) -> { 
            movilActual--;
            System.out.println(movilActual);
            try {
                labelNombre.setText("Nombre: "+ listaMoviles.getListaMoviles().get(movilActual).getNombre());
                labelMarca.setText("Marca: "+ listaMoviles.getListaMoviles().get(movilActual).getMarca());
                labelModelo.setText("Modelo: "+ listaMoviles.getListaMoviles().get(movilActual).getModelo());
                labelGB.setText("GB: "+ listaMoviles.getListaMoviles().get(movilActual).getGB());
                labelFechaSalidaVenta.setText("Fecha salida venta: "+ listaMoviles.getListaMoviles().get(movilActual).getFechaSalidaVenta());
                labelPrecio.setText("Precio: "+ listaMoviles.getListaMoviles().get(movilActual).getPrecio());
            } catch (Exception ex){} 
         });
    }
    
    

    public static void main(String[] args) {
        launch();
    }

}