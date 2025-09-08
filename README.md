Refactored_SistemaReservaSalas
==============================

Conteúdo:
- src/main/java/com/example/sistema/...  (código fonte refatorado)
- Relatorio_PI.md (resumo do relatório — abra o relatório completo gerado pelo assistente na conversa)
- README.md (este arquivo)

Como executar (linha de comando):
1. Compile:
   javac -d out $(find src/main/java -name "*.java")
2. Execute:
   java -cp out com.example.sistema.app.MainTest

No NetBeans:
- File > New Project > Java with Existing Sources > selecione a pasta 'src' como Source Package Folder
- Configure a classe principal: com.example.sistema.app.MainTest
- Run Project

O que enviar ao GitHub (sugestão):
- Commit inicial: "refactor: separar dominio, DAO, service e in-memory tests"
- Incluir Relatorio_PI.md (relatório completo), README.md e fonte.
- Criar branch 'melhorias' caso vá implementar JDBC depois.

Evidências para o relatório do PI:
- Prints do GitHub mostrando os arquivos e README.
- Output do MainTest (print/terminal).
- Histórico de commits (git log --oneline).
- Link do repositório GitHub.
