# Bugtracking — Registro de Falhas

| ID | Data       | Título                        | Passos para Reproduzir                                | Resultado Esperado               | Resultado Obtido                   | Status   | Commit/Correção |
|----|------------|-------------------------------|-------------------------------------------------------|----------------------------------|------------------------------------|----------|------------------|
| 1  | 2025-09-08 | Conflito de horário não trava | Criar reserva 09:00-10:00 e outra 09:30-10:30 mesma sala | Bloquear segunda reserva         | Segunda reserva estava passando     | Resolvido| `ReservaService.criarReserva` verificando `verificarConflitos` |
| 2  | 2025-09-08 | Login sem validação           | Enviar login vazio                                    | Retornar erro de validação       | Aceitava campos vazios no front    | Resolvido| Validação JS e `@NotBlank` no backend |
