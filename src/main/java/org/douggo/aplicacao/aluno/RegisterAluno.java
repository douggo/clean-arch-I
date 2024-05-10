package org.douggo.aplicacao.aluno;

import org.douggo.infra.aluno.AlunoMemoryRepository;

public class RegisterAluno {

    private final AlunoMemoryRepository repository;

    public RegisterAluno(AlunoMemoryRepository repository) {
        this.repository = repository;
    }

    public void execute(RegisterAlunoDto alunoDto) {
        this.repository.matricular(alunoDto.createAlunoFromDto());
    }
}
