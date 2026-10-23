module com.joaozanata.abacus {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;


    opens com.joaozanata.abacus to javafx.fxml;
    exports com.joaozanata.abacus;
}