package org.douggo.infra.aluno;

import org.douggo.dominio.aluno.*;
import org.douggo.infra.aluno.exceptions.AlunoNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoJDBCRepository implements AlunoRepository {

    private final Connection connection;

    public AlunoJDBCRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {
        final String[] sql = {"INSERT INTO ALUNO VALUES(?,?,?)"};
        try {
            final PreparedStatement[] ps = {this.connection.prepareStatement(sql[0])};
            ps[0].setString(1, aluno.getCpf().getValue());
            ps[0].setString(2, aluno.getNome());
            ps[0].setString(3, aluno.getEmail().getAddress());
            ps[0].execute();

            sql[0] = "INSERT INTO TELEFONE VALUES (?,?,?)";
            ps[0] = this.connection.prepareStatement(sql[0]);
            aluno.getTelefones().forEach(telefone -> {
                try {
                    ps[0].setString(1, aluno.getCpf().getValue());
                    ps[0].setString(2, telefone.getDdd());
                    ps[0].setString(3, telefone.getNumber());
                    ps[0].execute();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Aluno buscarPorCpf(CPF cpf) throws AlunoNotFoundException {
        final String sql = "SELECT * FROM ALUNOS WHERE cpf = (?)";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, cpf.getValue());
            ResultSet resultSet = ps.executeQuery();

            boolean found = resultSet.next();

            if (!found) {
                throw new AlunoNotFoundException(cpf);
            }

            Aluno aluno = new Aluno(
                    new CPF(resultSet.getString("cpf")),
                    resultSet.getString("nome"),
                    new Email(resultSet.getString("email"))
            );

            final String sqlGetTelefones = "SELECT ddd, numero FROM TELEFONE WHERE cpf = (?)";
            ps = this.connection.prepareStatement(sqlGetTelefones);
            ps.setString(1, cpf.getValue());
            resultSet = ps.executeQuery();
            while(resultSet.next()) {
                aluno.addTelefone(new Telefone(resultSet.getString("ddd"), resultSet.getString("number")));
            }

            return aluno;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Aluno> listarTodos() {
        final String sql = "SELECT * FROM ALUNOS";
        try {
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            List<Aluno> alunos = new ArrayList<>();
            while(resultSet.next()) {
                Aluno aluno = new Aluno(
                        new CPF(resultSet.getString("cpf")),
                        resultSet.getString("nome"),
                        new Email(resultSet.getString("email"))
                );

                String sqlTelefones = "SELECT ddd, numero FROM TELEFONE WHERE cpf = (?)";
                ps = this.connection.prepareStatement(sqlTelefones);
                ps.setString(1, aluno.getCpf().getValue());
                ResultSet resultSetTelefones = ps.executeQuery();

                while(resultSetTelefones.next()) {
                    aluno.addTelefone(new Telefone(
                            resultSetTelefones.getString("ddd"),
                            resultSetTelefones.getString("number"))
                    );
                }

                alunos.add(aluno);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return List.of();
    }

}
