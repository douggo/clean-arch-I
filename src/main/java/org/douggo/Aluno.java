package org.douggo;

import java.util.ArrayList;
import java.util.List;

/* Entity Class (has attribute to differentiate [CPF]) */
public class Aluno {

    private CPF cpf;
    private String nome;

    private Email email;

    private final List<Telefone> telefones = new ArrayList<>();

    public void addTelefone(Telefone telefone) {
        this.telefones.add(telefone);
    }

}
