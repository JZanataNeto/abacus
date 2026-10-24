# 🧮 Abacus - Calculadora JavaFX

O **Abacus** é uma aplicação de calculadora desktop desenvolvida em **Java** utilizando a interface gráfica **JavaFX** e **Scene Builder**. O projeto segue o padrão de arquitetura MVC (Model-View-Controller), onde a classe `CalculatorController` gerencia toda a lógica de eventos, cliques e interações do usuário.

---

## 📸 Demonstração (Screenshots)

| Tela Principal | Histórico de Operações |
| :---: | :---: |
| ![Interface da Calculadora](https://github.com/JZanataNeto/abacus/blob/master/src/main/resources/com/joaozanata/abacus/abacus-2.png) | ![Histórico em Ação](https://github.com/JZanataNeto/abacus/blob/master/src/main/resources/com/joaozanata/abacus/abacus_hist.png) |



---

## 🚀 Funcionalidades

| Categoria | Operações / Recursos |
| :--- | :--- |
| **Operações Básicas** | Adição (`+`), Subtração (`-`), Multiplicação (`*`), Divisão (`/`) e Porcentagem (`%`). |
| **Operações Unárias** | Raiz Quadrada (`√`), Elevação ao Quadrado (`X²`), Inversão (`1/x`) e Inversão de Sinal (`±`). |
| **Controles de Tela** | `C` (Limpar tudo), `CE` (Limpar entrada atual) e `Back` (Backspace / Apagar último dígito). |
| **Interface Visual** | **Histórico de operações** em tempo real (`historicoTela`) e campo de exibição principal (`tela`). |
| **Acessibilidade** | Suporte a cliques na interface visual e capturas de teclado (`KeyEvent`). |

---

## 🧪 Como Experimentar Rapidamente (Via `.exe`)

Se você quer apenas testar a calculadora sem precisar compilar o código fonte, pode executar o arquivo binário pré-compilado:

1. Acesse a aba **Releases** do repositório e baixe o arquivo `abacus.exe`.

---

## 🛠️ Tecnologias Utilizadas

* **Java SE** (Recomendado Java 17 ou superior)
* **JavaFX** (Para a construção da interface gráfica)
* **FXML** (Para a definição do layout visual da calculadora)

---

## 📁 Estrutura do Código (Controlador)

A lógica principal reside no pacote `com.joaozanata.abacus.CalculatorController`, destacando-se:

* `clicagem(ActionEvent event)`: Captura o clique dos botões da interface FXML.
* `processadorClique(String valor)`: Centraliza a triagem do botão pressionado ou tecla digitada.
* `processarDigito(String valor)`: Controla a entrada de números e regras de ponto flutuante (`.`).
* `processarOperadorBinario / Unario`: Executa as funções matemáticas baseadas no estado da aplicação.

---

## ⚙️ Como Compilar e Rodar o Código Fonte

### Pré-requisitos
* **JDK 17+**
* Gerenciador de dependências (**Maven** ou **Gradle**) com o plugin do JavaFX configurado.

### Passos
1. Clone o repositório:
   ```bash
   git clone https://github.com
   ```
2. Acesse a pasta do projeto:
   ```bash
   cd abacus
   ```
3. Se estiver utilizando Maven, execute:
   ```bash
   mvn javafx:run
   ```

---

## ✒️ Autor

* **João Zanata Neto** - *Desenvolvedor*
