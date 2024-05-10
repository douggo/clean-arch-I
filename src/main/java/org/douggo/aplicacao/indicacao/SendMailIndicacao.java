package org.douggo.aplicacao.indicacao;

import org.douggo.dominio.aluno.Aluno;

public interface SendMailIndicacao {

    void sendTo(Aluno indicado);

}
