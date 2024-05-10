package org.douggo.aplicacao.aluno;

import org.douggo.dominio.aluno.Aluno;
import org.douggo.dominio.aluno.CPF;
import org.douggo.dominio.aluno.Email;

public class RegisterAlunoDto {

    private final String nome;
    private final String cpf;
    private final String email;

    public RegisterAlunoDto(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public Aluno createAlunoFromDto() {
        return new Aluno(
          new CPF(this.cpf),
          this.nome,
          new Email(this.email)
        );
    }
}
