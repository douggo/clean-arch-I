package org.douggo.dominio.aluno;

public class AlunoBuilder {

    private Aluno aluno;

    public AlunoBuilder withNomeCpfEmail(String nome, String cpf, String email) {
        this.aluno = new Aluno(new CPF(cpf), nome, new Email(email));
        return this;
    }

    public AlunoBuilder withTelefone(String ddd, String number) {
        this.aluno.addTelefone(new Telefone(ddd, number));
        return this;
    }

    public Aluno getAlunoCreated() {
        return this.aluno;
    }

}
