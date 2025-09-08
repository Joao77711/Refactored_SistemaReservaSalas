Refactored_SistemaReservaSalas
==============================

Conteúdo:
- src/main/java/com/example/sistema/...  
- Relatorio_PI.md (resumo do relatório)
- README.md

Como executar (linha de comando):
1. Compile:
   javac -d out $(find src/main/java -name "*.java")
2. Execute:
   java -cp out com.example.sistema.app.MainTest

No NetBeans:
- File > New Project > Java with Existing Sources > selecione a pasta 'src' como Source Package Folder
- Configure a classe principal: com.example.sistema.app.MainTest
- Run Project

