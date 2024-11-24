package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Funcionario;

public class FuncionarioView extends Application {
    
    private TextField nomeField;
    private TextField salarioField;
    private Label detalhesLabel;

    @Override
    public void start(Stage primaryStage) {
        // Criação dos componentes da interface
        nomeField = new TextField();
        salarioField = new TextField();
        Button exibirButton = new Button("Exibir Detalhes");
        detalhesLabel = new Label();
        
        // Configuração do layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(
            new Label("Nome: "), nomeField,
            new Label("Salário: "), salarioField,
            exibirButton, detalhesLabel
        );
        
        // Ação para o botão "Exibir Detalhes"
        exibirButton.setOnAction(event -> exibirDetalhes());
        
        // Configuração da janela principal
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setTitle("Detalhes do Funcionário");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Método para exibir os detalhes do funcionário
    private void exibirDetalhes() {
        String nome = nomeField.getText();
        double salario = Double.parseDouble(salarioField.getText());
        
        // Criando o objeto Funcionario
        Funcionario funcionario = new Funcionario(nome, salario);
        
        // Exibindo os detalhes do funcionário
        detalhesLabel.setText("Nome: " + funcionario.getNome() + "\nSalário: " + funcionario.getSalario());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
