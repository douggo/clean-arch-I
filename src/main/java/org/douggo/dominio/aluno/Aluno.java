package org.douggo.dominio.aluno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Entity Class (has attribute to differentiate [CPF]) */
public class Aluno {

    private CPF cpf;

    private String nome;

    private Email email;

    private final List<Telefone> telefones = new ArrayList<>();

    public Aluno(CPF cpf, String nome, Email email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public CPF getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Email getEmail() {
        return email;
    }

    public List<Telefone> getTelefones() {
        return Collections.unmodifiableList(telefones);
    }

    public void addTelefone(Telefone telefone) {
        this.telefones.add(telefone);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "cpf=" + cpf +
                ", nome='" + nome + '\'' +
                ", email=" + email +
                ", telefones=" + telefones +
                '}';
    }
}
