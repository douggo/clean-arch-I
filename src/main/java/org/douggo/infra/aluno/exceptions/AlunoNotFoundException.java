package org.douggo.infra.aluno.exceptions;

import org.douggo.dominio.aluno.CPF;

public class AlunoNotFoundException extends Throwable {

    public AlunoNotFoundException(CPF cpf) {
        super("Aluno com o CPF " + cpf.getValue() + " não foi encontrado!");
    }

}
