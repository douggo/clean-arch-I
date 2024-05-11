package org.douggo.aplicacao.aluno;

import org.douggo.dominio.aluno.Aluno;
import org.douggo.dominio.aluno.CPF;
import org.douggo.infra.aluno.AlunoMemoryRepository;
import org.douggo.infra.aluno.exceptions.AlunoNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterAlunoTest {

    @Test
    void ShouldRegisterAluno() throws AlunoNotFoundException {
        AlunoMemoryRepository repository = new AlunoMemoryRepository();
        RegisterAluno useCase = new RegisterAluno(repository);
        RegisterAlunoDto alunoDto = new RegisterAlunoDto(
                "Douglas",
                "123.456.789-00",
                "douglas@mail.com"
        );
        useCase.execute(alunoDto);

        Aluno found = repository.buscarPorCpf(new CPF(alunoDto.createAlunoFromDto().getCpf().getValue()));

        assertNotNull(found);
        assertEquals("Douglas", found.getNome());
        assertEquals("123.456.789-00", found.getCpf().getValue());
        assertEquals("douglas@mail.com", found.getEmail().getAddress());
    }
}