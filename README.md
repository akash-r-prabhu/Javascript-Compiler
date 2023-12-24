# JavaScript Compiler

This repository contains a JavaScript compiler implemented using ANTLRv4 and Java. The compiler performs lexical analysis, parsing, semantic analysis, and generates both a parse tree and an abstract syntax tree (AST) for JavaScript code.

## Features

- **ANTLR Grammar:** Utilizes the `hello.g4` file in the `src` directory to define the JavaScript grammar.
- **ANTLR Recognizer Generation:** Generates ANTLR recognizer classes using the ANTLR tool.
- **Lexer and Parser:** Utilizes ANTLR-generated lexer and parser for JavaScript grammar.
- **Semantic Analysis:** Performs semantic analysis to ensure correctness and coherence of the input code.
- **Parse Tree and AST Generation:** Generates a parse tree and an abstract syntax tree (AST) representing the structure of the JavaScript code.
- **Error Handling:** Implements robust error handling mechanisms to provide informative messages for syntax and semantic errors.
- **Optimizations:** (Optional) Includes any optimizations or enhancements applied to the generated AST or code.

## Getting Started

### Prerequisites

- Java Development Kit (JDK): [Download and install JDK](https://www.oracle.com/java/technologies/javase-downloads.html)
- ANTLRv4: [Download and install ANTLR](https://www.antlr.org/download.html)

### Building ANTLR Recognizer

1. Install ANTLR:

    ```bash
    # On Unix-based systems (Linux/Mac)
    cd /usr/local/lib
    sudo curl -O https://www.antlr.org/download/antlr-4.x-complete.jar
    export CLASSPATH=".:/usr/local/lib/antlr-4.x-complete.jar:$CLASSPATH"
    alias antlr4='java -jar /usr/local/lib/antlr-4.x-complete.jar'
    alias grun='java org.antlr.v4.gui.TestRig'
    ```

    ```bash
    # On Windows
    # Download the ANTLR JAR from https://www.antlr.org/download.html
    # Set up CLASSPATH and alias commands accordingly
    ```

2. Generate ANTLR Recognizer:

    ```bash
    antlr4 src/hello.g4
    ```

3. Compile the generated files:

    ```bash
    javac -cp .:antlr-4.x-complete.jar src/*.java
    ```

### Running the Compiler

1. Run the compiler:

    ```bash
    # Replace 'YourMainClass' with the actual main class of your compiler
    java -cp .:antlr-4.x-complete.jar src/YourMainClass input.js
    ```

## Example Usage

```bash
# Replace 'YourCompilerExecutable' with the actual name of your compiled executable
./YourCompilerExecutable input.js
