# 🧮 Abacus - Calculadora JavaFX

O **Abacus** é uma aplicação de calculadora desktop desenvolvida em **Java** utilizando a interface gráfica **JavaFX**. O projeto segue o padrão de arquitetura MVC (Model-View-Controller), onde a classe `CalculatorController` gerencia toda a lógica de eventos, cliques e interações do usuário.

---

## 📸 Demonstração (Screenshots)

| Tela Principal | Histórico de Operações |
| :---: | :---: |
| ![Interface da Calculadora](https://placehold.co) | ![Histórico em Ação](https://placehold.co) |

> *Substitua os links das imagens acima pelos caminhos das suas capturas de tela reais (ex: `docs/screenshot1.png`).*

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

## 🧪 Como Experimentar Rapidamente (Via `.jar`)

Se você quer apenas testar a calculadora sem precisar compilar o código fonte, pode executar o arquivo binário pré-compilado:

1. Acesse a aba **Releases** do repositório e baixe o arquivo `abacus.jar`.
2. Certifique-se de ter o **Java 17 (ou superior)** instalado em sua máquina.
3. Abra o terminal na pasta onde o arquivo foi baixado e execute o comando:
   ```bash
   java -jar abacus.jar
   ```

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

* **João Zanata** - *Desenvolvedor Principal* - [Seu GitHub](https://github.com)
