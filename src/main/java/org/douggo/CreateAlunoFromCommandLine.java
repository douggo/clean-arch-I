package org.douggo;

import org.douggo.aplicacao.aluno.RegisterAluno;
import org.douggo.aplicacao.aluno.RegisterAlunoDto;
import org.douggo.infra.aluno.AlunoMemoryRepository;

public class CreateAlunoFromCommandLine {

    public static void main(String[] args) {
        RegisterAlunoDto dto = new RegisterAlunoDto(
                "Douglas",
                "123.456.789-00",
                "douglas@mail.com"
        );
        RegisterAluno registerAluno = new RegisterAluno(new AlunoMemoryRepository());
        registerAluno.execute(dto);
    }

}
