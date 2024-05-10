package org.douggo.dominio.aluno;

import org.douggo.infra.aluno.exceptions.AlunoNotFoundException;

import java.util.List;

public interface AlunoRepository {

    void matricular(Aluno aluno);

    Aluno buscarPorCpf(CPF cpf) throws AlunoNotFoundException;

    List<Aluno> listarTodos();

}
