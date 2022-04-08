module com.mycompany.listalibros {
    requires javafx.controls;
    requires java.xml.bind;
    requires jakarta.activation;
    requires java.activation;
    exports com.mycompany.listalibros;
    opens com.mycompany.listalibros to java.xml.bind;
}
