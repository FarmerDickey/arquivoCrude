
```markdown
# 🗂️ Simulador de Sistema de Arquivos (Java)

Este projeto é um **simulador de sistema de arquivos** que permite a navegação por diretórios reais do sistema operacional utilizando comandos semelhantes aos de um terminal Unix, como `ls`, `cd`, `tree` e `log`.

## 📁 Estrutura do Projeto

- `FileSystemSimulator.java`: Classe principal. Inicia o programa, lê comandos do usuário e executa ações.
- `DiretorioReal.java`: Lida diretamente com o sistema de arquivos real usando a API `java.io.File`.
- `Journal.java`: Responsável por registrar e exibir o histórico de ações realizadas pelo usuário.

## ✅ Funcionalidades

- `ls`: Lista os arquivos e pastas do diretório atual.
- `cd <nome>`: Navega para um subdiretório ou usa `cd ..` para voltar ao diretório pai.
- `tree`: Mostra a estrutura recursiva de diretórios a partir do diretório atual.
- `log`: Exibe um log com todas as ações executadas durante a sessão.
- `exit`: Encerra o programa.

## 🧪 Exemplo de Uso

```

C:\Users\Pablo\Documentos > ls
Projetos/
fatura.pdf
leitura.txt

C:\Users\Pablo\Documentos > cd Projetos
C:\Users\Pablo\Documentos\Projetos > tree
Projetos/
App1/
main.java
App2/
index.html
style.css

C:\Users\Pablo\Documentos\Projetos > log
Registro de ações:

* Listou conteúdo de: C:\Users\Pablo\Documentos
* Entrou no diretório: C:\Users\Pablo\Documentos\Projetos
* Visualizou árvore em: C:\Users\Pablo\Documentos\Projetos

````

## 🚀 Como Executar

1. Certifique-se de ter o Java instalado (JDK 11+).
2. Compile os arquivos:

```bash
javac FileSystemSimulator.java DiretorioReal.java Journal.java
````

3. Execute o simulador:

```bash
java FileSystemSimulator
```

## ⚠️ Observações

* O programa opera sobre **diretórios reais do sistema operacional**.
* Tenha cuidado ao navegar em diretórios sensíveis do sistema.
* O simulador é apenas de leitura, ou seja, **não altera nem deleta arquivos**.

## 👨‍💻 Autor

Desenvolvido por Pablo Amorim como parte de um projeto acadêmico de simulação de sistemas de arquivos em Java.
\
