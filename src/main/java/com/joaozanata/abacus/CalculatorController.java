package com.joaozanata.abacus;

import java.text.DecimalFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class CalculatorController {
    private double number1;
    private String operator = "";
    private boolean flag = true;

    @FXML private TextField tela;
    @FXML private Label historicoTela; //Label do histórico

    public void clicagem(ActionEvent event) {
        Button botaoClicado = (Button) event.getSource();
        processadorClique(botaoClicado.getText());
    }

    public void processadorClique(String valor) {
        if (valor.matches("[0-9.]")) {
            processarDigito(valor);
            return;
        }

        switch (valor) {
            case "C" -> {
                tela.setText("0");
                historicoTela.setText(""); // Limpa o histórico completo
                flag = true;
                number1 = 0;
                operator = "";
            }
            case "CE" -> {
                tela.setText("0");
                flag = true;
            }
            case "Back" -> processarBackspace();
            case "±" -> {
                double numeroAtual = Double.parseDouble(tela.getText());
                if (numeroAtual != 0.0) {
                    tela.setText(String.valueOf(-numeroAtual));
                }
            }
            case "√", "X²", "1/x" -> processarOperadorUnario(valor);
            case "=" -> executeCalculoFinal();
            default -> {
                if (valor.matches("[+*/%-]")) {
                    processarOperadorBinario(valor);
                }
            }
        }
    }

    private void processarDigito(String valor) {
        if (valor.equals(".")) {
            if (flag) {
                tela.setText("0.");
                flag = false;
            } else if (!tela.getText().contains(".")) {
                tela.appendText(".");
            }
            return;
        }

        if (flag || tela.getText().equals("0")) {
            tela.setText(valor);
            flag = false;
        } else {
            tela.appendText(valor);
        }
    }

    private void processarOperadorBinario(String novoOperador) {
        try {
            String textoAtual = tela.getText();

            if (!operator.isEmpty() && !flag) {
                double number2 = Double.parseDouble(textoAtual);
                number1 = calcular(number1, number2, operator);
                exibirResultado(number1);
            } else {
                number1 = Double.parseDouble(textoAtual);
            }

            operator = novoOperador;
            // atualiza o histórico mostrando o número acumulado e o novo operador escolhido
            historicoTela.setText(formatarNumero(number1) + " " + operator);
            flag = true;
        } catch (ArithmeticException e) {
            exibirErro();
        }
    }

    private void executeCalculoFinal() {
        if (operator.isEmpty()) return;
        try {
            double number2 = Double.parseDouble(tela.getText());
            double resultado = calcular(number1, number2, operator);

            // atualiza e formata o histórico completo da operação executada (Ex: "A + B =")
            historicoTela.setText(formatarNumero(number1) + " " + operator + " " + formatarNumero(number2) + " =");
            exibirResultado(resultado);
        } catch (ArithmeticException e) {
            exibirErro();
        }
        operator = "";
        flag = true;
    }

    private void processarOperadorUnario(String operador) {
        try {
            double numeroAtual = Double.parseDouble(tela.getText());
            double resultado = 0;

            // Define como a operação unária aparecerá no histórico (Ex: "√(9)")
            String representacaoHistorico = switch (operador) {
                case "√" -> {
                    if (numeroAtual < 0) throw new ArithmeticException();
                    resultado = Math.sqrt(numeroAtual);
                    yield "√(" + formatarNumero(numeroAtual) + ")";
                }
                case "X²" -> {
                    resultado = Math.pow(numeroAtual, 2);
                    yield "sqr(" + formatarNumero(numeroAtual) + ")";
                }
                case "1/x" -> {
                    if (numeroAtual == 0) throw new ArithmeticException();
                    resultado = 1 / numeroAtual;
                    yield "1/(" + formatarNumero(numeroAtual) + ")";
                }
                default -> "";
            };

            historicoTela.setText(representacaoHistorico);
            exibirResultado(resultado);
            flag = true;
        } catch (ArithmeticException e) {
            exibirErro();
        }
    }

    private void processarBackspace() {
        String textoAtual = tela.getText();
        if (textoAtual.isEmpty() || textoAtual.equals("0")) return;

        String newTexto = textoAtual.substring(0, textoAtual.length() - 1);
        if (newTexto.isEmpty() || newTexto.equals("-")) {
            tela.setText("0");
            flag = true;
        } else {
            tela.setText(newTexto);
        }
    }

    // Método que escuta as teclas do teclado físico
    public void processadorTeclado(KeyEvent event) {
        String tecla = event.getText();
        KeyCode codigo = event.getCode();

        //Captura números e pontos decimais (0-9 e .)
        if (tecla.matches("[0-9.]")) {
            processadorClique(tecla);
            return;
        }

        //Mapeamento de operadores e comandos especiais
        switch (codigo) {
            case ADD -> processadorClique("+");
            case SUBTRACT -> processadorClique("-");
            case MULTIPLY -> processadorClique("*");
            case DIVIDE -> processadorClique("/");
            case ENTER -> processadorClique("=");
            case BACK_SPACE -> processadorClique("Back");
            case ESCAPE -> processadorClique("C");
            case DELETE -> processadorClique("CE");
            default -> {
                // Caso o usuário use o teclado alfanumérico comum para os operadores
                if (tecla.equals("+") || tecla.equals("-") || tecla.equals("*") || tecla.equals("/")) {
                    processadorClique(tecla);
                } else if (tecla.equals("%")) {
                    processadorClique("%");
                }
            }
        }
    }


    private double calcular(double num1, double num2, String operador) {
        return switch (operador) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> {
                if (num2 == 0) throw new ArithmeticException();
                yield num1 / num2;
            }
            case "%" -> {
                if (num2 == 0) throw new ArithmeticException();
                yield (num1 * num2) / 100;
            }
            default -> num2;
        };
    }

    private void exibirResultado(double valor) {
        tela.setText(formatarNumero(valor));
    }

    private String formatarNumero(double valor) {
        DecimalFormat df = new DecimalFormat("0.0000");
        return df.format(valor);
    }

    private void exibirErro() {
        tela.setText("Erro");
        historicoTela.setText("");
        operator = "";
        flag = true;
    }
}

