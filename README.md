# SalaReservaWeb (Spring Boot)

Projeto web (Spring REST + JPA + H2) que implementa o back-end do Sistema de Reserva de Salas e integra com o front-end da Etapa 8 (arquivos estáticos em `src/main/resources/static`).

## Como rodar
```bash
# requer Java 17+ e Maven
mvn spring-boot:run
# app em: http://localhost:8080
# H2 console: http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:reservas)
```

## Endpoints principais
- `POST /api/usuarios` — cria usuário `{nome, login, senha}`
- `POST /api/usuarios/login` — login `{login, senha}`
- `GET /api/salas` / `POST /api/salas` — CRUD básico de salas
- `GET /api/reservas` / `POST /api/reservas` — cria reserva e valida conflitos

## Testes
```bash
mvn test
```
Inclui:
- `SalaRepositoryTest` — CRUD básico
- `ReservaServiceTest` — validação de conflito de horários

## Observações
- Banco em memória H2 (config em `application.properties`).
- CORS liberado nos controllers com `@CrossOrigin` para testes locais.
=======
Refactored_SistemaReservaSalas

 Sistema de Reserva de Salas desenvolvido em Java com MySQL.

Funcionalidades

-Login de usuários (com validação no banco de dados).

-Cadastro de salas.

-Cadastro de reservas.

-Consulta de reservas cadastradas.

-Navegação entre telas com botão Voltar.

-Projeto de testes com JUnit (Etapa 7).

-Tecnologias Utilizadas

-Java

-MySQL

-NetBeans

-JUnit

-Git/GitHub

-Status do Projeto

 -Em desenvolvimento

