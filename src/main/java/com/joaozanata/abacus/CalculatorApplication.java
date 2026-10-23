package com.joaozanata.abacus;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculatorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CalculatorApplication.class.getResource("abacus.fxml"));
        Parent root = fxmlLoader.load();
        // recupera a instância do controlador criado pelo FXML
        CalculatorController controller = fxmlLoader.getController();
        Scene scene = new Scene(root, 400, 600);
        // direciona o teclado da scene para o controlador
        scene.setOnKeyPressed(controller::processadorTeclado);
        stage.setTitle("Abacus");
        stage.setScene(scene);
        stage.show();
        // garante que a janela tenha foco para capturar o teclado imediatamente
        root.requestFocus();
    }
}
