module com.alvaromorenogil.catalogohookas {
    requires javafx.controls;
    requires java.xml.bind;
    requires jakarta.activation;
    requires java.activation;
    exports com.alvaromorenogil.catalogohookas;
    opens com.alvaromorenogil.catalogohookas to java.xml.bind;
}
