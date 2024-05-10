package org.douggo.infra.aluno;

import org.douggo.dominio.aluno.Aluno;
import org.douggo.dominio.aluno.AlunoRepository;
import org.douggo.dominio.aluno.CPF;
import org.douggo.infra.aluno.exceptions.AlunoNotFoundException;

import java.util.List;

public class AlunoMemoryRepository implements AlunoRepository {

    private List<Aluno> table;

    @Override
    public void matricular(Aluno aluno) {
        this.table.add(aluno);
    }

    @Override
    public Aluno buscarPorCpf(CPF cpf) throws AlunoNotFoundException {
        return this.table.stream()
                .filter(aluno -> aluno.getCpf().getValue().equals(cpf.getValue()))
                .findFirst()
                .orElseThrow(() -> new AlunoNotFoundException(cpf));
    }

    @Override
    public List<Aluno> listarTodos() {
        return this.table;
    }

}
